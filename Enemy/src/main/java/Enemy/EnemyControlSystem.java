package Enemy;

import Common.data.Entity;
import Common.data.GameData;
import Common.data.World;
import Common.data.entityparts.LifePart;
import Common.data.entityparts.MovingPart;
import Common.data.entityparts.PositionPart;
import Common.services.IEntityProcessingService;
import Common.services.IGameBulletPluginService;
import Common.util.SPILocator;

import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 *
 * @author jcs
 */
public class EnemyControlSystem implements IEntityProcessingService {

    private boolean up;
    private boolean left;
    private  boolean right;
    private Random random;
    private float shootTimer;
    private float moveTimer;

    public EnemyControlSystem(){
        this.random = new Random();
        this.shootTimer = 2;
        this.moveTimer = 3;
    }

    @Override
    public void process(GameData gameData, World world) {

        for (Entity enemy : world.getEntities(Enemy.class)) {
            PositionPart positionPart = enemy.getPart(PositionPart.class);
            MovingPart movingPart = enemy.getPart(MovingPart.class);
            LifePart lifePart = enemy.getPart(LifePart.class);

            moveTimer -= gameData.getDelta();
            if (moveTimer <= 0){
                up = random.nextBoolean();
                left = random.nextBoolean();
                right = random.nextBoolean();
                moveTimer = 3;
            }

            shootTimer -= gameData.getDelta();
            if(shootTimer <= 0){
                shoot(gameData, world, positionPart);
                shootTimer = 2;
            }

            movingPart.setLeft(left);
            movingPart.setRight(right);
            movingPart.setUp(up);

            movingPart.process(gameData, enemy);
            positionPart.process(gameData, enemy);

            updateShape(enemy);
            if(lifePart.getLife() <= 0){
                world.removeEntity(enemy);
            }
        }
    }

    private void shoot(GameData gameData, World world, PositionPart positionPart) {
        Optional<IGameBulletPluginService> bullet = getAll(IGameBulletPluginService.class).stream().findAny();

        bullet.get().shoot(positionPart.getRadians(), (float) (positionPart.getX()+(10*Math.cos(positionPart.getRadians()))),
                (float) (positionPart.getY()+(10*Math.sin(positionPart.getRadians()))), gameData, world);
    }

    private void updateShape(Entity entity) {
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x + Math.cos(radians) * 8);
        shapey[0] = (float) (y + Math.sin(radians) * 8);

        shapex[1] = (float) (x + Math.cos(radians - 4 * 3.1415f / 5) * 8);
        shapey[1] = (float) (y + Math.sin(radians - 4 * 3.1145f / 5) * 8);

        shapex[2] = (float) (x + Math.cos(radians + 3.1415f) * 5);
        shapey[2] = (float) (y + Math.sin(radians + 3.1415f) * 5);

        shapex[3] = (float) (x + Math.cos(radians + 4 * 3.1415f / 5) * 8);
        shapey[3] = (float) (y + Math.sin(radians + 4 * 3.1415f / 5) * 8);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }

    public <T> List<T> getAll(Class<T> service){
        return SPILocator.locateAll(service);
    }
}

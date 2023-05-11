package Enemy;

import Common.data.Entity;
import Common.data.GameData;
import Common.data.GameKeys;
import Common.data.World;
import Common.data.entityparts.MovingPart;
import Common.data.entityparts.PositionPart;
import Common.services.IEntityProcessingService;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author jcs
 */
public class EnemyControlSystem implements IEntityProcessingService {

    private ScheduledExecutorService randomMovement;
    private boolean up;
    private boolean left;
    private  boolean right;
    private Random random;

    public EnemyControlSystem(){
        this.randomMovement = Executors.newSingleThreadScheduledExecutor();
        this.random = new Random();
        randomMovement.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                up = random.nextBoolean();
                left = random.nextBoolean();
                right = random.nextBoolean();
            }
        },0,5, TimeUnit.SECONDS);
    }

    @Override
    public void process(GameData gameData, World world) {

        for (Entity Enemy : world.getEntities(Enemy.class)) {
            PositionPart positionPart = Enemy.getPart(PositionPart.class);
            MovingPart movingPart = Enemy.getPart(MovingPart.class);

            movingPart.setLeft(left);
            movingPart.setRight(right);
            movingPart.setUp(up);
            
            
            movingPart.process(gameData, Enemy);
            positionPart.process(gameData, Enemy);

            updateShape(Enemy);
        }
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

}

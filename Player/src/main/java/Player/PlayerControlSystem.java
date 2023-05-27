package Player;

import Common.data.Entity;
import Common.data.GameData;
import Common.data.World;
import Common.data.entityparts.LifePart;
import Common.data.entityparts.MovingPart;
import Common.data.entityparts.PositionPart;
import Common.services.IEntityProcessingService;
import Common.data.GameKeys;
import Common.services.IGameBulletPluginService;
import Common.util.SPILocator;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author jcs
 */
public class PlayerControlSystem implements IEntityProcessingService {


    @Override
    public void process(GameData gameData, World world) {

        for (Entity player : world.getEntities(Player.class)) {
            PositionPart positionPart = player.getPart(PositionPart.class);
            MovingPart movingPart = player.getPart(MovingPart.class);
            LifePart lifePart = player.getPart(LifePart.class);

            movingPart.setLeft(gameData.getKeys().isDown(GameKeys.LEFT));
            movingPart.setRight(gameData.getKeys().isDown(GameKeys.RIGHT));
            movingPart.setUp(gameData.getKeys().isDown(GameKeys.UP));

            if (gameData.getKeys().isDown(GameKeys.SPACE)){

                Optional<IGameBulletPluginService> bullet = getAll(IGameBulletPluginService.class).stream().findAny();

                bullet.get().shot(positionPart.getRadians(), (float) (positionPart.getX()+(10*Math.cos(positionPart.getRadians()))), (float) (positionPart.getY()+(10*Math.sin(positionPart.getRadians()))), gameData,world);
            }

            movingPart.process(gameData, player);
            positionPart.process(gameData, player);

            updateShape(player);

            if(lifePart.getLife() <= 0){
                world.removeEntity(player);
            }
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


    public <T> List<T> getAll(Class<T> service){
        return SPILocator.locateAll(service);
    }
}

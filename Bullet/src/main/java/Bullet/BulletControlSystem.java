package Bullet;

import Common.data.Entity;
import Common.data.GameData;
import Common.data.World;
import Common.data.entityparts.LifePart;
import Common.data.entityparts.MovingPart;
import Common.data.entityparts.PositionPart;
import Common.services.IEntityProcessingService;

public class BulletControlSystem implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {
        for (Entity bullet : world.getEntities(Bullet.class)) {
            PositionPart positionPart = bullet.getPart(PositionPart.class);
            MovingPart movingPart = bullet.getPart(MovingPart.class);
            LifePart lifePart = bullet.getPart(LifePart.class);

            movingPart.setUp(true);

            movingPart.process(gameData, bullet);
            positionPart.process(gameData, bullet);
            lifePart.reduceExpiration(gameData.getDelta());
            lifePart.process(gameData, bullet);

            updateShape(bullet);
            if(lifePart.getLife() <= 0){
                world.removeEntity(bullet);
            }
        }
    }
    private void updateShape(Entity entity) {
        float[] shapeX = entity.getShapeX();
        float[] shapeY = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapeX[0] = (float) (x + Math.cos(radians) * 1);
        shapeY[0] = (float) (y + Math.sin(radians) * 1);

        shapeX[1] = (float) (x + Math.cos(radians) * 0);
        shapeY[1] = (float) (y + Math.sin(radians) * 0);

        shapeX[2] = (float) (x + Math.cos(radians) * 2);
        shapeY[2] = (float) (y + Math.sin(radians) * 2);

        shapeX[3] = (float) (x + Math.cos(radians) * -2);
        shapeY[3] = (float) (y + Math.sin(radians) * -2);

        entity.setShapeX(shapeX);
        entity.setShapeY(shapeY);
    }
}

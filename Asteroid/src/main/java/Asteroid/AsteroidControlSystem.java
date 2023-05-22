package Asteroid;

import Common.data.Entity;
import Common.data.GameData;
import Common.data.World;
import Common.data.entityparts.LifePart;
import Common.data.entityparts.MovingPart;
import Common.data.entityparts.PositionPart;
import Common.data.entityparts.SplitterPart;
import Common.services.IEntityProcessingService;

import java.util.Random;

public class AsteroidControlSystem implements IEntityProcessingService {

    private int numPoints = 6;
    private float angle = 0;
    private Random random = new Random();
    @Override
    public void process(GameData gameData, World world) {
        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            PositionPart positionPart = asteroid.getPart(PositionPart.class);
            MovingPart movingPart = asteroid.getPart(MovingPart.class);
            LifePart lifePart = asteroid.getPart(LifePart.class);
            SplitterPart splitterPart = asteroid.getPart(SplitterPart.class);



            float speed = (float) Math.random() * 10f + 40f;
            if (random.nextInt() < 8) {
                movingPart.setMaxSpeed(speed);
                movingPart.setUp(true);
            } else {
                movingPart.setLeft(true);
            }

            Asteroid asteroid1 = (Asteroid) asteroid;

            if(lifePart.getLife() <= 0 && asteroid1.getType() == AsteroidSize.SMALL){
                world.removeEntity(asteroid);
            } else if(lifePart.getLife() <= 0){
                splitterPart.setShouldSplit(true);
            }

            movingPart.process(gameData, asteroid);
            positionPart.process(gameData, asteroid);
            updateShape(asteroid);
            movingPart.setLeft(false);
            movingPart.setUp(false);
        }
    }



    private void updateShape(Entity asteroid) {

        PositionPart positionPart = asteroid.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        float[] shapex = new float[6];
        float[] shapey = new float[6];
        Asteroid asAsteroid = (Asteroid) asteroid;
//        SplitterPart splitter = asAsteroid.getPart(SplitterPart.class);
        if(asAsteroid.getSize().equals("LARGE")){
            for (int i = 0; i < numPoints; i++) {
                shapex[i] = x + (float) Math.cos(angle + radians) * 26;
                shapey[i] = y + (float) Math.sin(angle + radians) * 26;
                angle += 2 * 3.1415f / numPoints;
            }
        }
        if(asAsteroid.getSize().equals("MEDIUM")){
            for (int i = 0; i < numPoints; i++) {
                shapex[i] = x + (float) Math.cos(angle + radians) * 16;
                shapey[i] = y + (float) Math.sin(angle + radians) * 16;
                angle += 2 * 3.1415f / numPoints;
            }
        }
        if(asAsteroid.getSize().equals("SMALL")){
            for (int i = 0; i < numPoints; i++) {
                shapex[i] = x + (float) Math.cos(angle + radians) * 26;
                shapey[i] = y + (float) Math.sin(angle + radians) * 26;
                angle += 2 * 3.1415f / numPoints;
            }
        }


        asteroid.setShapeX(shapex);
        asteroid.setShapeY(shapey);
    }
}

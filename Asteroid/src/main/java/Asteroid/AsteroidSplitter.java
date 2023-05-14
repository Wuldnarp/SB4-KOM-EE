package Asteroid;

import Common.data.Entity;
import Common.data.GameData;
import Common.data.World;
import Common.data.entityparts.PositionPart;
import Common.data.entityparts.SplitterPart;
import Common.services.IEntityProcessingService;

public class AsteroidSplitter implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {
        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            Asteroid theAsteroid = (Asteroid) asteroid;
            PositionPart posPart = asteroid.getPart(PositionPart.class);
            SplitterPart splitter = asteroid.getPart(SplitterPart.class);

            if (theAsteroid.getSize().equals("LARGE") && splitter.ShouldSplit()) {
                splitter.setShouldSplit(false);
                Asteroid mediumAsteroidOne = AsteroidCreator.createMediumAsteroid(posPart.getX(), posPart.getY());
                Asteroid mediumAsteroidTwo = AsteroidCreator.createMediumAsteroid(posPart.getX(), posPart.getY());
                world.addEntity(mediumAsteroidOne);
                world.addEntity(mediumAsteroidTwo);
                world.removeEntity(asteroid);
            }

            if (theAsteroid.getSize().equals("MEDIUM") && splitter.ShouldSplit()) {
                splitter.setShouldSplit(false);
                Asteroid smallAsteroidOne = AsteroidCreator.createSmallAsteroid(posPart.getX(), posPart.getY());
                Asteroid smallAsteroidTwo = AsteroidCreator.createSmallAsteroid(posPart.getX(), posPart.getY());
                world.addEntity(smallAsteroidOne);
                world.addEntity(smallAsteroidTwo);
                world.removeEntity(asteroid);
            }

        }
    }
}

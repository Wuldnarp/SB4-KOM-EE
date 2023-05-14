package Asteroid;

import Common.data.Entity;
import Common.data.GameData;
import Common.data.World;
import Common.data.entityparts.MovingPart;
import Common.data.entityparts.PositionPart;
import Common.services.IGamePluginService;
import java.util.Random;

public class AsteroidPlugin implements IGamePluginService {

    private Entity asteroid;

    public AsteroidPlugin(){
    }


    @Override
    public void start(GameData gameData, World world) {
        asteroid = AsteroidCreator.createLargeAsteroid(gameData);
        world.addEntity(asteroid);
    }


    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(asteroid);

    }
}

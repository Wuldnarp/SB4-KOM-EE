package Asteroid;

import Common.data.Entity;
import Common.data.GameData;
import Common.data.entityparts.LifePart;
import Common.data.entityparts.MovingPart;
import Common.data.entityparts.PositionPart;
import Common.data.entityparts.SplitterPart;

import java.util.Random;

import static Asteroid.AsteroidSize.*;

public class AsteroidCreator {

    private static Random  random = new Random();

    static Asteroid createLargeAsteroid(GameData gameData){
        float speed = (float) Math.random() * 10f + 40f;
        float radians = 3.1415f / 2 + (float) Math.random();
        float x = gameData.getDisplayWidth() / 2 + 100;
        float y = gameData.getDisplayHeight() / 2 + 50;
        Entity asteroid = new Asteroid(LARGE);

        asteroid.add(new MovingPart(0, speed, speed, 0));
        asteroid.add(new PositionPart(x, y, radians));
        asteroid.add(new LifePart(6, 69));
        asteroid.add(new SplitterPart());
        asteroid.setRadius(15);

        return (Asteroid) asteroid;
    }

    static Asteroid createSmallAsteroid(float x, float y) {
        float speed = (float) Math.random() * 10f + 13f;
        float radians = 3.1415f / 2 + (float) Math.random();

        Entity asteroid = new Asteroid(SMALL);
        asteroid.add(new MovingPart(0, speed, speed, 0));
        asteroid.add(new PositionPart(x + random.nextInt(50), y+random.nextInt(50), radians));
        asteroid.add(new LifePart(2, 69));
        asteroid.add(new SplitterPart());
        asteroid.setRadius(5);

        return (Asteroid) asteroid;
    }

    static Asteroid createMediumAsteroid(float x, float y) {
        float speed = (float) Math.random() * 10f + 40f;
        float radians = 3.1415f / 2 + (float) Math.random();

        Entity asteroid = new Asteroid(MEDIUM);

        asteroid.add(new MovingPart(0, speed, speed, 0));
        asteroid.add(new PositionPart(x + random.nextInt(50), y + random.nextInt(50), radians));
        asteroid.add(new LifePart(4, 69));
        asteroid.add(new SplitterPart());
        asteroid.setRadius(10);

        return (Asteroid) asteroid;
    }
}

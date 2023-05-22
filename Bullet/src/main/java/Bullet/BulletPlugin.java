package Bullet;

import Common.data.Entity;
import Common.data.GameData;
import Common.data.World;
import Common.data.entityparts.LifePart;
import Common.data.entityparts.MovingPart;
import Common.data.entityparts.PositionPart;
import Common.services.IGamePluginService;

public class BulletPlugin implements IGamePluginService {

    private Entity bullet;
    private float radians;
    private float x;
    private float y;
    @Override
    public void start(GameData gameData, World world) {
        bullet = createBullet(gameData);
        world.addEntity(bullet);
    }

    private Entity createBullet(GameData gameData){
        float deacceleration = 0;
        float acceleration = 600;
        float maxSpeed = 600;
        float rotationSpeed = 1;

        Entity bullet = new Bullet();
        bullet.setRadius(3);

        bullet.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        bullet.add(new PositionPart(x, y, radians));
        bullet.add(new LifePart(1,2));

        return bullet;
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(bullet);
    }

    public void shot(float radians, float posX, float posY, GameData gameData, World world){
        this.radians = radians;
        this.x = posX;
        this.y = posY;
        start(gameData,world);
    }
}

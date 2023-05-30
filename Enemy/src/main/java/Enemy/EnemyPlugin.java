package Enemy;

import Common.data.Entity;
import Common.data.GameData;
import Common.data.World;
import Common.data.entityparts.LifePart;
import Common.data.entityparts.MovingPart;
import Common.data.entityparts.PositionPart;
import Common.services.IGamePluginService;

public class EnemyPlugin implements IGamePluginService {

    private Entity Enemy;

    public EnemyPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {
        
        // Add entities to the world
        Enemy = createEnemyShip(gameData);
        world.addEntity(Enemy);
    }

    private Entity createEnemyShip(GameData gameData) {

        float deacceleration = 10;
        float acceleration = 200;
        float maxSpeed = 300;
        float rotationSpeed = 5;
        float x = gameData.getDisplayWidth() / 3;
        float y = gameData.getDisplayHeight() / 3;
        float radians = 3.1415f / 2;
        
        Entity enemyShip = new Enemy();
        enemyShip.setColor(new float[]{1,0,0,1});
        enemyShip.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        enemyShip.add(new PositionPart(x, y, radians));
        enemyShip.add(new LifePart(5,69));
        enemyShip.setRadius(3);

        return enemyShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(Enemy);
    }

}

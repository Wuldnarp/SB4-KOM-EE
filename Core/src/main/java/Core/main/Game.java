package Core.main;

import Asteroid.AsteroidControlSystem;
import Asteroid.AsteroidPlugin;
import Asteroid.AsteroidSplitter;
import Bullet.BulletControlSystem;
import Collision.Collider;
import Enemy.EnemyControlSystem;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import Common.data.Entity;
import Common.data.GameData;
import Common.data.World;
import Common.services.IEntityProcessingService;
import Common.services.IGamePluginService;
import Core.managers.GameInputProcessor;
import Player.PlayerControlSystem;
import Player.PlayerPlugin;
import Enemy.EnemyPlugin;

import java.util.ArrayList;
import java.util.List;

public class Game
        implements ApplicationListener {

    private static OrthographicCamera cam;
    private ShapeRenderer sr;

    private final GameData gameData = new GameData();
    private List<IEntityProcessingService> entityProcessors = new ArrayList<>();
    private List<IGamePluginService> entityPlugins = new ArrayList<>();
    private World world = new World();

    @Override
    public void create() {

        gameData.setDisplayWidth(Gdx.graphics.getWidth());
        gameData.setDisplayHeight(Gdx.graphics.getHeight());

        cam = new OrthographicCamera(gameData.getDisplayWidth(), gameData.getDisplayHeight());
        cam.translate(gameData.getDisplayWidth() / 2, gameData.getDisplayHeight() / 2);
        cam.update();

        sr = new ShapeRenderer();

        Gdx.input.setInputProcessor(
                new GameInputProcessor(gameData)
        );

        IGamePluginService playerPlugin = new PlayerPlugin();
        IEntityProcessingService playerProcess = new PlayerControlSystem();
        IGamePluginService enemyPlugin = new EnemyPlugin();
        IEntityProcessingService enemyProcess = new EnemyControlSystem();
        IGamePluginService asteroidPlugin = new AsteroidPlugin();
        IEntityProcessingService asteroidProcess = new AsteroidControlSystem();
        IEntityProcessingService asteroidSplitter = new AsteroidSplitter();
        IEntityProcessingService collider = new Collider();
        IEntityProcessingService bullet = new BulletControlSystem();

        entityPlugins.add(playerPlugin);
        entityProcessors.add(playerProcess);
        entityPlugins.add(enemyPlugin);
        entityProcessors.add(enemyProcess);
        entityPlugins.add(asteroidPlugin);
        entityProcessors.add(asteroidProcess);
        entityProcessors.add(asteroidSplitter);
        entityProcessors.add(collider);
        entityProcessors.add(bullet);
        // Lookup all Game Plugins using ServiceLoader
        for (IGamePluginService iGamePlugin : entityPlugins) {
            iGamePlugin.start(gameData, world);
        }
    }

    @Override
    public void render() {

        // clear screen to black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gameData.setDelta(Gdx.graphics.getDeltaTime());

        update();

        draw();

        gameData.getKeys().update();
    }

    private void update() {
        // Update
        for (IEntityProcessingService entityProcessorService : entityProcessors) {
            entityProcessorService.process(gameData, world);
        }
    }

    private void draw() {
        for (Entity entity : world.getEntities()) {

            float[] color = entity.getColor();
            sr.setColor(color[0],color[1],color[2],color[3]);

            sr.begin(ShapeRenderer.ShapeType.Line);

            float[] shapex = entity.getShapeX();
            float[] shapey = entity.getShapeY();

            for (int i = 0, j = shapex.length - 1;
                    i < shapex.length;
                    j = i++) {

                sr.line(shapex[i], shapey[i], shapex[j], shapey[j]);
            }

            sr.setColor(1, 1, 1, 1);
            sr.end();
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}

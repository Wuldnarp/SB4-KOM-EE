module Core {
    requires Common;
    requires java.desktop;
    requires com.badlogic.gdx;

    requires Player;
    requires Collision;
    requires Asteroid;
    requires Bullet;
    requires Enemy;

    uses Common.services.IEntityProcessingService;
    uses Common.services.IGamePluginService;
}
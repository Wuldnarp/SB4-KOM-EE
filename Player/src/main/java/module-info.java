module Player {
    requires Common;
    requires Bullet;

    uses Common.services.IGameBulletPluginService;

    provides Common.services.IGamePluginService with Player.PlayerPlugin;
    provides Common.services.IEntityProcessingService with Player.PlayerControlSystem;

}
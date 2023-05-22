module Player {
    requires Common;
    requires Bullet;

    provides Common.services.IGamePluginService with Player.PlayerPlugin;
    provides Common.services.IEntityProcessingService with Player.PlayerControlSystem;

    uses Common.services.IGameBulletPluginService;
}
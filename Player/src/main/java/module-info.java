module Player {
    requires Common;

    uses Common.services.IGameBulletPluginService;

    exports Player;

    provides Common.services.IGamePluginService with Player.PlayerPlugin;
    provides Common.services.IEntityProcessingService with Player.PlayerControlSystem;

}
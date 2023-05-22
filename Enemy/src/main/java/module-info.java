module Enemy {
    requires Common;

    provides Common.services.IGamePluginService with Enemy.EnemyPlugin;
    provides Common.services.IEntityProcessingService with Enemy.EnemyControlSystem;
}
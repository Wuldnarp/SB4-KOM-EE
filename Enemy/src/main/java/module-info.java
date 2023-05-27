module Enemy {
    requires Common;

    exports Enemy;

    provides Common.services.IGamePluginService with Enemy.EnemyPlugin;
    provides Common.services.IEntityProcessingService with Enemy.EnemyControlSystem;
}
module Bullet {
    requires Common;

    provides Common.services.IGameBulletPluginService with Bullet.BulletPlugin;
    provides Common.services.IEntityProcessingService with Bullet.BulletControlSystem;
}
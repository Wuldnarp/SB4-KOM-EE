module Bullet {
    requires Common;

    exports Bullet;

    provides Common.services.IGameBulletPluginService with Bullet.BulletPlugin;
    provides Common.services.IEntityProcessingService with Bullet.BulletControlSystem;
}
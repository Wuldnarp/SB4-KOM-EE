module Asteroid {
    requires Common;
    exports Asteroid;

    provides Common.services.IGamePluginService with Asteroid.AsteroidPlugin;
    provides Common.services.IEntityProcessingService with Asteroid.AsteroidSplitter, Asteroid.AsteroidControlSystem;

}
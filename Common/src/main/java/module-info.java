import Common.services.IEntityProcessingService;
import Common.services.IGameBulletPluginService;
import Common.services.IGamePluginService;

module Common {
    requires java.desktop;

    exports Common.services;
    exports Common.data;
    exports Common.data.entityparts;
    exports Common.util;

    uses IEntityProcessingService;
    uses IGamePluginService;
    uses IGameBulletPluginService;
}
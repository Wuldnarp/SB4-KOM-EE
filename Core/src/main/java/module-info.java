module Core {
    requires Common;
    requires java.desktop;
    requires com.badlogic.gdx;
    requires spring.context;

    exports Core.main;
    exports Core.injectors;

    uses Common.services.IEntityProcessingService;
    uses Common.services.IGamePluginService;
}
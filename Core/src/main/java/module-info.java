module Core {
    requires Common;
    requires java.desktop;
    requires gdx;

    uses Common.services.IEntityProcessingService;
    uses Common.services.IGamePluginService;
}
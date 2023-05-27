module Collision {
    requires Common;

    exports Collision;

    provides Common.services.IEntityProcessingService with Collision.Collider;
}
module Collision {
    requires Common;

    provides Common.services.IEntityProcessingService with Collision.Collider;
}
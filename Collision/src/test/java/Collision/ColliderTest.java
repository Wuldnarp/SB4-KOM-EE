package Collision;

import Common.data.Entity;
import Common.data.entityparts.LifePart;
import Common.data.entityparts.PositionPart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ColliderTest {

    //Arrange
    Entity entity1;
    Entity entity2;
    int startLife;
    Collider collider;

    @BeforeEach
    void setUp() {
        //Arrange
       this.collider = new Collider();
       this.startLife = 10;
    }

    private Entity createentity(float x, float y) {
        float radians = 3.1415f / 2;
        Entity entity = new Entity();
        entity.add(new PositionPart(x, y, radians));
        entity.add(new LifePart(startLife,69));
        entity.setRadius(3);

        return entity;
    }

    @Test
    void noCollision(){
        //Arrange
        entity1 = createentity(5,5);
        entity2= createentity(10,10);

        //Act
        boolean collides = collider.Collides(entity1,entity2);

        //Assert
        assertFalse(collides);
    }

    @Test
    void collision(){
        //Arrange
        entity1 = createentity(5,5);
        entity2= createentity(6,6);

        //Act
        boolean collides = collider.Collides(entity1,entity2);

        //Assert
        assertTrue(collides);
    }
}
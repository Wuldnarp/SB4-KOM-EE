package Common.data;

import Common.data.entityparts.LifePart;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


class EntityTest {

    //Arrange
    private Entity entity;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        //Arrange
        this.entity = new Entity();
    }

    @Test
    void addRemoveGetPartTest() {
        //Arrange
        LifePart lifePart = new LifePart(10,5);

        //Act
        boolean added = this.entity.add(lifePart);
        LifePart lifePart1 = this.entity.getPart(LifePart.class);
        boolean removed = this.entity.remove(lifePart.getClass());

        //Assert
        assertTrue(added);
        assertTrue(removed);
        assertEquals(lifePart,lifePart1);
    }

    @Test
    void setGetRadiusTest() {
        //Arrange
        float radius = 5;

        //Act
        this.entity.setRadius(radius);

        //Assert
        assertEquals(radius,this.entity.getRadius());
    }

    @Test
    void getIDTest() {
        //Act
        String id = this.entity.getID();

        //Assert
        assertNotNull(id);
    }

    @Test
    void setGetShapeXTest() {
        //Arrange
        float[] shapeX = new float[]{1,2,3,4};

        //Act
        this.entity.setShapeX(shapeX);

        //Assert
        assertArrayEquals(shapeX,this.entity.getShapeX());
    }


    @Test
    void setGetShapeYTest() {
        //Arrange
        float[] shapeY = new float[]{1,2,3,4};

        //Act
        this.entity.setShapeY(shapeY);

        //Assert
        assertArrayEquals(shapeY,this.entity.getShapeY());
    }

    @Test
    void setGetColorTest() {
        //Arrange
        float[] color = new float[]{1,1,1,1};

        //Act
        this.entity.setColor(color);

        //Assert
        assertArrayEquals(color,this.entity.getColor());
    }
}
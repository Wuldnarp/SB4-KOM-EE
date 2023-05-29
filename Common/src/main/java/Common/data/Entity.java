package Common.data;

import Common.data.entityparts.EntityPart;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Entity implements Serializable {
    private final UUID ID = UUID.randomUUID();

    private float[] shapeX;
    private float[] shapeY;
    private float radius;
    private Map<Class, EntityPart> parts;
    
    private float[] color;
    
    public Entity() {
        parts = new ConcurrentHashMap<>();
        color = new float[]{1,1,1,1};
        shapeX = new float[4];
        shapeY = new float[4];
    }
    
    public Boolean add(EntityPart part) {
        try {
            parts.put(part.getClass(), part);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    
    public boolean remove(Class partClass) {
        try {
            parts.remove(partClass);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    
    public <E extends EntityPart> E getPart(Class partClass) {
        return (E) parts.get(partClass);
    }
    
    public void setRadius(float r){
        this.radius = r;
    }
    
    public float getRadius(){
        return radius;
    }

    public String getID() {
        return ID.toString();
    }

    public float[] getShapeX() {
        return shapeX;
    }

    public void setShapeX(float[] shapeX) {
        this.shapeX = shapeX;
    }

    public float[] getShapeY() {
        return shapeY;
    }

    public void setShapeY(float[] shapeY) {
        this.shapeY = shapeY;
    }

    public void setColor(float[] color) {
        this.color = color;
    }

    public float[] getColor() {
        return color;
    }
}

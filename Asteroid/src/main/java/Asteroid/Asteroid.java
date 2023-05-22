package Asteroid;

import Common.data.Entity;

public class Asteroid extends Entity {
    private AsteroidSize type;

    public Asteroid(AsteroidSize type)
    {
        this.type = type;
    }

    public String getSize() {
        return type.getSize();
    }
    public AsteroidSize getType(){
        return type;
    }
}

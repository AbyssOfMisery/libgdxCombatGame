package com.mygdx.game.BetaClass;

public class CollisionRect {
    float x,y;
    float width,height;

    public CollisionRect(float x, float y, float width, float height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean collidesWith(CollisionRect rect)
    {
        return x<rect.x + rect.width && y < rect.y + rect.height && x+width>rect.x && y+ height >rect.height;
    }

}

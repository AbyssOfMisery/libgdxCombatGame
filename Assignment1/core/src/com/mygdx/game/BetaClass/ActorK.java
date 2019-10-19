package com.mygdx.game.BetaClass;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class ActorK extends ActorBeta {
    public ActorK(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("kof/K-1.png");
        setPosition(x,y);
        this.setBoundaryRectangle();

    }
    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
    }
}

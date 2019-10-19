package com.mygdx.game.BetaClass;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class ActorIori extends ActorBeta {
    public ActorIori(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("kof/Iori-5.png");
        setPosition(x,y);
        this.setBoundaryRectangle();
    }
    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
    }
}

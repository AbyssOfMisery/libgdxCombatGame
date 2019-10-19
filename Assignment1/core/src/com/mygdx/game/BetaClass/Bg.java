package com.mygdx.game.BetaClass;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Bg extends ActorBeta {
    public Bg(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("kof/Stage.png");
        setPosition(x,y);
        scaleBy(0.5f);
        this.setBoundaryRectangle();
    }
    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
    }
}

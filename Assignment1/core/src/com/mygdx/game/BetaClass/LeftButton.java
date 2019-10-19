package com.mygdx.game.BetaClass;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class LeftButton extends ActorBeta {
    public LeftButton(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("Buttons/Left_Button.gif");
        setPosition(x,y);
        this.setBoundaryRectangle();
    }
    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
    }
}

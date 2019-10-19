package com.mygdx.game.BetaClass;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class UpButton extends ActorBeta {
    public UpButton(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("Buttons/Up_Button.gif");
        setPosition(x,y);
        this.setBoundaryRectangle();
    }
    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
    }
}

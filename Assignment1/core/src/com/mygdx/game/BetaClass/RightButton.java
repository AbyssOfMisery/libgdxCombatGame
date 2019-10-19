package com.mygdx.game.BetaClass;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class RightButton extends ActorBeta {
    public RightButton(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("Buttons/Right_Button.gif");
        setPosition(x,y);
        this.setBoundaryRectangle();
    }
    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
    }
}

package com.mygdx.game.BetaClass;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class YButton extends ActorBeta {
    public YButton(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("Buttons/Y_button.gif");
        setPosition(x,y);
        this.setBoundaryRectangle();
    }
    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
    }
}

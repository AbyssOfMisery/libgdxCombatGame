package com.mygdx.game.BetaClass;

import com.badlogic.gdx.scenes.scene2d.Stage;

import java.awt.Color;

public class HealthBar extends ActorBeta {
        public HealthBar(float x, float y, Stage s) {
            super(x, y, s);
            loadTexture("kof/HealthBar.png");
            setPosition(x,y);
            setScale(3,2);
            this.setBoundaryRectangle();
        }
        public void act(float dt) {
            super.act(dt);
            applyPhysics(dt);
        }
}

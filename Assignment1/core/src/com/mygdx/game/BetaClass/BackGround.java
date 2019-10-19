package com.mygdx.game.BetaClass;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class BackGround extends ActorBeta {

    public BackGround(float x, float y, Stage s) {
        super(x, y, s);
        Animation<TextureRegion> backGround;
        backGround = com.mygdx.game.BetaClass.GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("kof/backGround.gif").read());
        setAnimation(backGround);
        setPosition(x,y);
        this.setBoundaryRectangle();
    }
    @Override
    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
    }
}

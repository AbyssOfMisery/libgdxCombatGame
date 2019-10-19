package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.BetaClass.ActorK;
import com.mygdx.game.BetaClass.BackGround;
import com.mygdx.game.BetaClass.ScreenBeta;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;
import static com.mygdx.game.BetaClass.GameBeta.setActiveScreen;

public class PlayerWon extends ScreenBeta {
    Skin uiSkin;
    Dialog dialog;
    ActorK actorK;
    BackGround backGround;
    Menu menu;
    float width = Gdx.graphics.getWidth();
    float height = Gdx.graphics.getHeight();
    @Override
    public void initialize() {
        uiSkin = new Skin(Gdx.files.internal("freezing/skin/freezing-ui.json"));
        backGround = new BackGround(width,height,mainStage);
        backGround.scaleBy(4);
        actorK = new ActorK(0,-500,mainStage);
        dialog = new Dialog("K", uiSkin) {};
        dialog.scaleBy(6f,3);
        dialog.text("I won this one");
        dialog.pack();
        dialog.show(mainStage, sequence(Actions.alpha(0), Actions.fadeIn(0.4f, Interpolation.fade)));
        dialog.addListener(new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                 menu = new Menu();
                 setActiveScreen(menu);
                return false;
            }
        });
    }

    @Override
    public void update(float dt) {

    }
}

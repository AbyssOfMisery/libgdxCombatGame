package com.mygdx.game.BetaClass;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.Screen.GameState;
import com.mygdx.game.Screen.TalkingState;


import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;
import static com.mygdx.game.BetaClass.GameBeta.setActiveScreen;

public class MessageBox {
    Skin uiSkin;
    Dialog dialog;
    Dialog dialog2;
    Dialog dialog3;
    ActorK actorK;
    ActorIori actorIori;
    BackGround backGround;
    GameState gameState;
    float width = Gdx.graphics.getWidth();
    float height = Gdx.graphics.getHeight();
    public void Talking(final Stage s){

        uiSkin = new Skin(Gdx.files.internal("freezing/skin/freezing-ui.json"));
        backGround = new BackGround(width/4,height/4,s);
        backGround.scaleBy(2);
        actorIori = new ActorIori(0,-200,s);
        dialog = new Dialog("Iori", uiSkin) {};
        dialog.scaleBy(6f,3);
        dialog.text("Who are you?");
        dialog.pack();
        dialog.show(s, sequence(Actions.alpha(0), Actions.fadeIn(0.4f, Interpolation.fade)));

        dialog2 = new Dialog("K", uiSkin) {};
        dialog2.scaleBy(6f,3);
        dialog2.text("K");
        dialog2.hide();
        dialog2.pack();
        dialog.show(s, sequence(Actions.alpha(0), Actions.fadeIn(0.4f, Interpolation.fade)));
        dialog.addListener(new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                dialog.hide();
                actorK = new ActorK(800,-800,s);
                dialog2.show(s, sequence(Actions.alpha(0), Actions.fadeIn(0.4f, Interpolation.fade)));
                return false;
            }
        });
       dialog3 = new Dialog("Iori", uiSkin) {};
       dialog3.scaleBy(6f,3);
       dialog3.text("Another prey!");
       dialog3.hide();
       dialog3.pack();
       dialog2.addListener(new InputListener(){
           public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
           {
               dialog2.hide();
               dialog3.show(s, sequence(Actions.alpha(0), Actions.fadeIn(0.4f, Interpolation.fade)));
               return false;
           }
       });

        dialog3.addListener(new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                gameState = new GameState();
                setActiveScreen(gameState);
                return false;
            }
        });


    }

}

package com.mygdx.game.Screen;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.BetaClass.MessageBox;
import com.mygdx.game.BetaClass.ScreenBeta;

public class TalkingState extends ScreenBeta {
    float width = Gdx.graphics.getWidth();
    float height = Gdx.graphics.getHeight();
    MessageBox messageBox;

    @Override
    public void initialize() {
        messageBox = new MessageBox();
        messageBox.Talking(mainStage);
    }

    @Override
    public void update(float dt) {

    }
}

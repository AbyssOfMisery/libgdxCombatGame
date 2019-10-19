package com.mygdx.game.Screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.BetaClass.Bg;
import com.mygdx.game.BetaClass.ScreenBeta;

import static com.mygdx.game.BetaClass.GameBeta.setActiveScreen;

public class Menu extends ScreenBeta{

    Skin skin;
    TalkingState talkingState;
    ImageTextButton StartButton;
    CheckBox muteMusic;
    Bg bg;
    Music bgMusic;
    @Override
    public void initialize() {
        skin = new Skin(Gdx.files.internal("freezing/skin/freezing-ui.json"));
        bgMusic = Gdx.audio.newMusic((Gdx.files.internal("kof/BgMusic.mp3")));
        bgMusic.play();
        bg = new Bg(0,0,mainStage);

        muteMusic = new CheckBox("Mute Music",skin);
        mainStage.addActor(muteMusic);
        muteMusic.setPosition(0,0);

        StartButton = new ImageTextButton("Start",skin);
        StartButton.setSize(300,100);
        mainStage.addActor(StartButton);
        StartButton.setPosition(700,500);
    }


    @Override
    public void update(float dt) {
        if(StartButton.isChecked()){
            bgMusic.stop();
            talkingState = new TalkingState();
            setActiveScreen(talkingState);
        }
        if (muteMusic.isChecked()){
            bgMusic.stop();
        }
    }
}

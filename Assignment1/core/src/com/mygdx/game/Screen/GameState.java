package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.BetaClass.ActorBeta;
import com.mygdx.game.BetaClass.AiIori;
import com.mygdx.game.BetaClass.BackGround;
import com.mygdx.game.BetaClass.DownButton;
import com.mygdx.game.BetaClass.HealthBar;
import com.mygdx.game.BetaClass.LeftButton;
import com.mygdx.game.BetaClass.PlayerK;
import com.mygdx.game.BetaClass.RightButton;
import com.mygdx.game.BetaClass.ScreenBeta;
import com.mygdx.game.BetaClass.UpButton;
import com.mygdx.game.BetaClass.XButton;
import com.mygdx.game.BetaClass.YButton;
import com.mygdx.game.BetaClass.ZButton;
import com.mygdx.game.ParticleActor;

import static com.mygdx.game.BetaClass.GameBeta.setActiveScreen;


public class GameState extends ScreenBeta {


    boolean gameStart = false;
    boolean gameEnd = false;
    BackGround backGround;

    PlayerK playerK;
    AiIori aiIori;

    UpButton upButton;
    DownButton downButton;
    LeftButton leftButton;
    RightButton rightButton;

    XButton xButton;
    YButton yButton;
    ZButton zButton;

    Timer timer;
    Integer worldTimer;
    float timeCount;
    Label countdownLabel;
    int flipK;

    HealthBar playerHealthBar;
    HealthBar aiHealthBar;

    Music beginMusic;
    Music punchMusic;


    PlayerWon playerWon;
    AiWon aiWon;
    ParticleActor particleActor;
    @Override
    public void initialize() {
        worldTimer = 63;
        timeCount = 0;
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        backGround = new BackGround(width/3,height/3,mainStage);
        backGround.setScale(3.0f);

        countdownLabel = new Label(String.format("%03d", worldTimer), new Label.LabelStyle(new BitmapFont(), Color.BLUE));
        mainStage.addActor(countdownLabel);
        countdownLabel.setPosition(width/2 - 100,height-50);
        countdownLabel.setFontScale(4);

        particleActor = new ParticleActor("Effect/Effect.pfx", "Effect");
        mainStage.addActor(particleActor);
        particleActor.stop();

        timer = new Timer();
        beginMusic = Gdx.audio.newMusic((Gdx.files.internal("kof/Start.mp3")));
        beginMusic.play();
        punchMusic = Gdx.audio.newMusic((Gdx.files.internal("kof/Light_Boxing.mp3")));
        playerHealthBar = new HealthBar(350,1000,mainStage);
        aiHealthBar = new HealthBar(1800,1000,mainStage);
        playerK = new PlayerK(500,40,mainStage);
        particleActor.centerAtActor(playerK);
        aiIori = new AiIori(1200,40,mainStage);
        aiIori.setScaleX(aiIori.getScaleX()* -1);
        timer.schedule(new Timer.Task(){
                           @Override
                           public void run() {
                               gameStart = true;
                           }

                       }
                , 3        //    (delay)
                , 0     //    (seconds)

        );
        flipK = (int)playerK.getScaleX()*-1;

        upButton = new UpButton(250,500,mainStage);
        upButton.setScale(4);
        upButton.addListener(new InputListener(){
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                playerK.isJump = false;
            }
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                if(gameStart){
                    playerK.isJump = true;
                }
                return true;
            }
        });

        downButton = new DownButton(250,200,mainStage);
        downButton.setScale(4);
        downButton.addListener(new InputListener(){
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                playerK.isCrouch = false;
            }
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                if(gameStart){
                    playerK.isCrouch = true;
                }
                return true;
            }
        });

        leftButton = new LeftButton(100,350, mainStage);
        leftButton.setScale(4);
        leftButton.addListener(new InputListener(){
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Input Test", "touch Up: " + x + ", " + y + ", button: " );
                playerK.isMovingLeft = false;
            }
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                if(gameStart)
                {
                    playerK.isMovingLeft =true;
                    playerK.setScaleX(flipK);
                }
                return true;
            }
        });

        rightButton = new RightButton(400,350,mainStage);
        rightButton.setScale(4);
        rightButton.addListener(new InputListener(){
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                playerK.isMovingRight = false;

            }
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                if(gameStart)
                {
                        playerK.setScaleX(flipK*-1);
                        playerK.isMovingRight =true;
                }
                 return true;
            }
        });


        xButton = new XButton(1700,400,mainStage);
        xButton.setScale(4);
        xButton.addListener(new InputListener(){
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                playerK.isPunching = false;
                playerK.isAttack = false;
            }
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                if(gameStart)
                {
                        particleActor.start();
                        playerK.isPunching = true;
                        playerK.isAttack = true;
                }
                return true;
            }
        });

        yButton = new YButton(1600,300,mainStage);
        yButton.setScale(4);
        yButton.addListener(new InputListener(){
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                playerK.isKick = false;
                playerK.isAttack = false;
            }
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                if(gameStart)
                {
                    playerK.isKick = true;
                    playerK.isAttack = true;
                }
                return true;
            }
        });

        zButton = new ZButton(1500,200,mainStage);
        zButton.setScale(4);
        zButton.addListener(new InputListener(){
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                playerK.isDefence = false;
            }
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                if(gameStart)
                {
                    playerK.isDefence = true;
                }
                return true;
            }
        });
        ActorBeta.setWorldBounds(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
}


    @Override
    public void update(float dt) {

        playerK.act(dt);
        if(!gameStart)
        {
            playerK.onGameBegin();
            aiIori.onGameBegin();
        }
        if(playerK.getX()<= 0)
        {
            playerK.setPosition(0, 50);
        }else if(playerK.getX()>= 1700)
        {
            playerK.setPosition(1700, 50);
        }
        timeCount += dt;
        if(timeCount >= 1){
            if (worldTimer > 0) {
                worldTimer--;
            } else {
                gameStart = false;
            }
            countdownLabel.setText(String.format("%03d", worldTimer));
            timeCount = 0;
        }
        if(gameStart)
        {
            if(playerK.isAttack){
                punchMusic.play();
            }
            else {
                punchMusic.stop();
            }
            beginMusic.stop();

            if(!aiIori.isDead)
            {
                if(aiIori.getX() - playerK.getX()>=100)
                {
                    aiIori.isMovingLeft = true;
                }else if(aiIori.getX() - playerK.getX() <=100){
                    aiIori.isMovingRight = true;
                    aiIori.setScaleX(flipK*-1);
                }else
                {
                    aiIori.isMovingLeft = true;
                }
                if(aiIori.overlaps(playerK))
                {
                    aiIori.isAttack = true;
                    if( aiIori.isAttack)
                    {
                        aiIori.isPunching = true;
                        playerK.currentHealth();
                    }
                }else
                {
                    aiIori.isPunching = false;
                    aiIori.isAttack = false;
                }
            }else
            {
                aiIori.moveBy(0,0);
            }

            if(!playerK.isDead)
            {
                if(playerK.overlaps(aiIori))
                {
                    if(playerK.isAttack)
                    {
                        aiIori.currentHealth();
                    }
                }
                if(particleActor.isRunning())
                {
                    aiIori.currentHealth();
                }
            }else
            {
                playerK.moveBy(0,0);
            }

        }

        if(playerK.isDead || aiIori.isDead || worldTimer==0) {
            gameStart = false;
            gameEnd = true;
        }
            if(aiIori.isDead && gameEnd)
            {
                playerWon = new PlayerWon();
                setActiveScreen(playerWon);
            }else if(playerK.isDead && gameEnd)
            {
                aiWon = new AiWon();
                setActiveScreen(aiWon);
            }





        playerHealthBar.setSize(playerK.currentHealth * 2,300);
        aiHealthBar.setSize(aiIori.currentHealth * -2,300);
        ActorBeta.setWorldBounds(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

}

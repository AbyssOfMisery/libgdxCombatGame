package com.mygdx.game.BetaClass;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;

public class AiIori extends ActorBeta {
    public  boolean isPunching = false, isCrouch= false, isMovingRight = false, isMovingLeft = false, isJump = false, isDefence = false, isKick = false,isDead = false,isAttack = false;

    Animation<TextureRegion> standAnim = com.mygdx.game.BetaClass.GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("kof/Iori/Standing.gif").read());
    Animation<TextureRegion> jumpAnim = com.mygdx.game.BetaClass.GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("kof/Iori/Jump.gif").read());
    Animation<TextureRegion> punchAnim = com.mygdx.game.BetaClass.GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("kof/Iori/Punch.gif").read());
    Animation<TextureRegion> downAnim = com.mygdx.game.BetaClass.GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("kof/Iori/GetDown.gif").read());
    Animation<TextureRegion> walkAnim = com.mygdx.game.BetaClass.GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("kof/Iori/Walking.gif").read());
    Animation<TextureRegion> kickAnim = com.mygdx.game.BetaClass.GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("kof/Iori/Knock.gif").read());
    Animation<TextureRegion> defenceAnim = com.mygdx.game.BetaClass.GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("kof/Iori/Defence.gif").read());
    Animation<TextureRegion> beginAnim = com.mygdx.game.BetaClass.GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("kof/Iori/Begin.gif").read());
    Animation<TextureRegion> deadAnim  = com.mygdx.game.BetaClass.GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("kof/Iori/Dead.gif").read());
    public Integer currentHealth = 100;
    public Integer maxHealth = 100;
    Timer timer;
    public AiIori(float x, float y, Stage s) {
        super(x, y, s);
        setPosition(x,y);
        setSpeed(20);
        setMotionAngle(90);
        setScale(2);
        loadTexture("kof/Iori/Begin.gif");
        this.setBoundaryRectangle();

    }

    @Override
    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
        boundToWorld();
        if(isCrouch)
        {
            setAnimation(downAnim);
        }else if(isPunching)
        {
            setAnimation(punchAnim);

        } else if(isJump)
        {
            //moveBy(0,15);
            setAnimation(jumpAnim);
        }else if(isMovingRight)
        {
            moveBy(10,0.0f);
            setAnimation(walkAnim);

        }else if(isMovingLeft)
        {
            moveBy(-10,0.0f);
            setAnimation(walkAnim);
            //setAnimation(punchAnim);

        } else if(isKick)
        {
            setAnimation(kickAnim);
        }else if(isDefence)
        {
            setAnimation(defenceAnim);
        }else if(isDead) {
            setAnimation(deadAnim);
            timer = new Timer();
            timer.schedule(new Timer.Task() {
                               @Override
                               public void run() {
                                   isDead = false;
                               }
                           }
                    , 2        //    (delay)
                    , 0     //    (seconds)
            );
        } else
        {
            moveBy(0,0);
            setAnimation(standAnim);
        }

        if (getY() > 110) {
            setMotionAngle(-45);
        }
        if (getY() < 50) {
            setMotionAngle(45);
            setSpeed(0);
        }

    }
    public void onGameBegin()
    {
        setAnimation(beginAnim);
    }

    public void currentHealth()
    {
        if(currentHealth<= maxHealth && currentHealth >= 1)
        {
            currentHealth = currentHealth - 10;
        }else if(currentHealth <= 0)
        {
            isDead = true;
            currentHealth = 0;

        }

    }
    public void boost() {
        setSpeed(800);
        setMotionAngle(90);
    }
}
package com.mygdx.game.Screen;


import com.mygdx.game.BetaClass.GameBeta;


public class Main extends GameBeta {
    Menu menu;
    GameState gameState;
    PlayerWon playerWon;
    AiWon aiWon;
    @Override
    public void create() {
        super.create();
        menu = new Menu();
        setActiveScreen(menu);
       // playerWon = new PlayerWon();
       // setActiveScreen(playerWon);
        //aiWon = new AiWon();
        //setActiveScreen(aiWon);
        //gameState = new GameState();
        //setActiveScreen(gameState);
    }
}

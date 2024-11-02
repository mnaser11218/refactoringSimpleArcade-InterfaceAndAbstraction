package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;

abstract public class NumberGuessAbstractClass implements  NumberGuessInterface{
    private int randomNumber;
    private final List<PlayerInterface> players;

    private boolean appClosed = false;
    public NumberGuessPlayer player;
    public boolean gamerunning=true;

    final IOConsole console = new IOConsole(AnsiColor.BLUE);

    @Override
    public Integer getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber() {
        this.randomNumber = (int) (Math.random() * (100 - 1)) + 1;
    }

    public boolean isAppClosed() {
        return appClosed;
    }

    public void setAppClosed(boolean appClosed) {
        this.appClosed = appClosed;
    }

    public NumberGuessPlayer getPlayer() {
        return player;
    }

    public void setPlayer(NumberGuessPlayer player) {
        this.player = player;
    }

    public boolean isGamerunning() {
        return gamerunning;
    }
    public void endGame(){
        gamerunning = false;
    }

    public void setGamerunning(boolean gamerunning) {
        this.gamerunning = gamerunning;
    }

    @Override
    public IOConsole getConsole() {
        return console;
    }

    public NumberGuessAbstractClass(List<PlayerInterface> players) {
        this.players = players;
    }

//    public AbstractGame(List<PlayerInterface> players) {
//        this.players = players;
//    }
//
    public NumberGuessAbstractClass() {
        this(new ArrayList<>());
    }

    public List<PlayerInterface> getPlayerList() {
        return players;
    }
}

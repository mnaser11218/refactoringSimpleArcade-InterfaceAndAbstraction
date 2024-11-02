package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;

abstract public class NumberGuessAbstractClass implements  NumberGuessInterface{
    private int randomNumber;
    private final List<PlayerInterface> players;
    public boolean gamerunning=true;

    final IOConsole console = new IOConsole(AnsiColor.BLUE);


    public NumberGuessAbstractClass(List<PlayerInterface> players) {
        this.players = players;
    }

    public NumberGuessAbstractClass() {
        this(new ArrayList<>());
    }

    @Override
    public Integer getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber() {
        this.randomNumber = (int) (Math.random() * (100 - 1)) + 1;
    }

    public boolean isGamerunning() {
        return gamerunning;
    }
    public void endGame(){
        gamerunning = false;
    }


    @Override
    public IOConsole getConsole() {
        return console;
    }



    public List<PlayerInterface> getPlayerList() {
        return players;
    }
}

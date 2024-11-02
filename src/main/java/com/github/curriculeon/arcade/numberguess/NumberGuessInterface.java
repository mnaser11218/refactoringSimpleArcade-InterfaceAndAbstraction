package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.IOConsole;

import java.util.List;

public interface NumberGuessInterface {
    IOConsole getConsole();
    Integer getRandomNumber();

    boolean isGamerunning();
    public void setRandomNumber();
    List<PlayerInterface> getPlayerList();
    public void endGame();




    default boolean checkIfNumberTooHighOrTooLow(int userNumber){

        if(userNumber > getRandomNumber()){
            getConsole().println("My Number is less than " + userNumber);
            return false;
        } else if(userNumber < getRandomNumber()){
            getConsole().println("My Number is greater than " + userNumber);
            return false;
        }

        String userInput = getConsole().getStringInput(" Well Done ! It took you " + 0 +" amount of tries \n Would you like to play again? yes/no");
        if(userInput.equalsIgnoreCase("no")){
            endGame();
            return true;
        }

        setRandomNumber();
        return true;
    }

    default void evaluatePlayer(PlayerInterface playerInterface) {
        setRandomNumber();
        Integer numberGuessed= playerInterface.play();
        while(numberGuessed != getRandomNumber()){

            checkIfNumberTooHighOrTooLow(numberGuessed);
            numberGuessed= playerInterface.play();
        }

        getConsole().println("Congrats you got it in " + playerInterface.getCounter()  + " amount of tries");
        endGame();
    }

    default void add(PlayerInterface player){
        getPlayerList().add(player);
    };

    default void remove(PlayerInterface player){
        getPlayerList().remove(player);
    };

    default void run(){
        do{
            for(PlayerInterface playerInterface : getPlayerList())
                evaluatePlayer(playerInterface);
        }while(isGamerunning());
    }
}

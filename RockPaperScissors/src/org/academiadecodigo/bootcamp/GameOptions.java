package org.academiadecodigo.bootcamp;

public enum GameOptions {
    ROCK ("Rock"),
    PAPER ("Paper"),
    SCISSORS("Scissors");

    private String description;
    //private int value;

    GameOptions(String description){
        this.description = description;
        //this.value = value;
    }

    public String getDescription(){
        return this.description;
    }

    //public int getValue(){
        //return this.value;
    //}
}

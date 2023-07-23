package org.academiadecodigo.bootcamp;

public class Player {
    private String name;
    public Player(String name) {

        this.name = name;
    }
    public String getName() {
        return name;
    }
    public static GameOptions chooseHand(){

        int objectPicked = (int) (Math.random() * 3 + 0);
        GameOptions handOption = GameOptions.values()[objectPicked];

        return handOption;

    }
}

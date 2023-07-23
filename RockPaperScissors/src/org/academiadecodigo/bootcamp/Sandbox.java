package org.academiadecodigo.bootcamp;

import java.util.Arrays;

public class Sandbox {
    public static void main(String[] args) {
        Player[] players = new Player[]{
                new Player("Nancy"),
                new Player("Zé")
        };

        /*for (Player player : players) {


            System.out.println(player.getName() + " Choose " + Player.chooseHand());

        }*/
        Game.startGame();
    }
}
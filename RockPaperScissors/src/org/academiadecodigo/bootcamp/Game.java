package org.academiadecodigo.bootcamp;

public class Game {

    private Player[] players;
    private static int count1= 0;
    private static int count2= 0;


    public Game(int maxMoves, Player[] players) {
        this.players = players;
    }
    public static void startGame() {

       if (count1 <2 && count2 <2) {

           GameOptions handPlayer1 = Player.chooseHand();
           GameOptions handPlayer2 = Player.chooseHand();

           if (handPlayer1 == handPlayer2) {

               System.out.println("Its a tie");
               startGame();
           }

           if (handPlayer1 == GameOptions.PAPER && handPlayer2 == GameOptions.SCISSORS) {

               System.out.println("Player Two  " + "Wins");
               count2++;
               startGame();
           }

           if (handPlayer1 == GameOptions.PAPER && handPlayer2 == GameOptions.ROCK) {

               System.out.println("Player One " + "Wins");
               count1++;
               startGame();
           }

           if (handPlayer1 == GameOptions.SCISSORS && handPlayer2 == GameOptions.PAPER) {

               System.out.println("Player One " + "Wins");
               count1++;
               startGame();
           }

           if (handPlayer1 == GameOptions.SCISSORS && handPlayer2 == GameOptions.ROCK) {

               System.out.println("Player One " + "Wins");
               count1++;
               startGame();
           }

           if (handPlayer1 == GameOptions.ROCK && handPlayer2 == GameOptions.PAPER) {

               System.out.println("Player Two " + "Wins");
               count2++;
               startGame();
           }

           if (handPlayer1 == GameOptions.ROCK && handPlayer2 == GameOptions.SCISSORS) {

               System.out.println("Player One " + "Wins");
               count1++;
               startGame();
           }
       }else{
           if(count2>count1){
               System.out.println("Congrats player2.getName()");
           }else{
               System.out.println("Congrats player 1");
           }
       }

    }
}










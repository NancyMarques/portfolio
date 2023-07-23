package org.academiadecodigo.bootcamp;

public class Game {
        Game game1 = new Game();

        public static int gameFinalNumber;
        public static int getNumber () {
            int gameNumber = Generator.generatorNumber();
            return gameNumber;
        }
        public static int startPlay(){
            gameFinalNumber = Game.getNumber();
            System.out.println("Game Guess: " + gameFinalNumber);
            return gameFinalNumber;
        }
        public static void play(){

            int guessNumber = Player.getNumber2();


            while (gameFinalNumber != guessNumber){

                guessNumber = Player.getNumber2();
                System.out.println("Player Guess: " + guessNumber);

            }

            System.out.println("The game number is: " + guessNumber);
        }
    }


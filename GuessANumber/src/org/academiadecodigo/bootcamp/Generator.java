package org.academiadecodigo.bootcamp;

public class Generator{
    public  static  int count;

    public static int maxRounds = 10;
    public static int[] unrepeatedNumbers = new int[9];
    public static int generatorNumber() {
        int number = (int) (Math.random() * 9) + 1;
        return number;
            }
    public static int generatorUnrepeatedNumbers() {
        
        int number = (int) (Math.random() * 9) + 1;
        boolean flag = false;
        for (int i = 0; i < unrepeatedNumbers.length-1; i++) {
            if (unrepeatedNumbers[i] == number) {
                flag = true;
                maxRounds--;
            }
            if(maxRounds==0){
                break;
            }
        }
        if (flag == true){

            generatorUnrepeatedNumbers();
        }else{
            unrepeatedNumbers[count] = number;
            count++;
        }
        return number;
    }
}

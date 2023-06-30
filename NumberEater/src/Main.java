// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);
       boolean play = true;
       int startDecider = 10;
       int walletOne = 10;
       int walletTwo = 10;
       ArrayList<Integer> playerOneNumbers = new ArrayList<>();
       ArrayList<Integer> playerTwoNumbers = new ArrayList<>();
       ArrayList<Integer> battleOneNumbers = new ArrayList<>();
       ArrayList<Integer> battleTwoNumbers = new ArrayList<>();

       /** Get the names of the players instead of using player one/ player two all the time
       System.out.println("What is the name of player one?");
       String playerOne = scanner.nextLine();
       System.out.println("What is the name of player two?");
       String playerTwo = scanner.nextLine();

        */

       //Player one choosing its numbers
       for (int i = 0; i < 5 && walletOne > 0; i++) {
          System.out.println("Player one can buy numbers now!");
          System.out.println("You currently have: " + walletOne + " to spend");
          System.out.println("You have currently bought: " + playerOneNumbers);
          emptyLines(1);
          int bought = Integer.valueOf(scanner.nextLine());

          if (bought <= walletOne && bought > 0 ) {
             numberCheck(bought);
             if (bought == 30) {
                System.out.println("You did not enter a valid number");
                emptyLines(1);
             }
             else {
                playerOneNumbers.add(bought);
                walletOne = walletOne - bought;
             }
          }

          else {
             System.out.println("You did not enter a valid number!");
             emptyLines(1);
             i--;
          }
       }
          //summary for player one
          emptyLines(2);
          System.out.println("Player one is out of money or has reached the maximum of 5 numbers!!");
          System.out.println("Player one has bought: " + playerOneNumbers);
          emptyLines(1);

          //Player two choosing its numbers
       for (int i = 0; i < 5 && walletTwo > 0; i++) {
          System.out.println("Player Two can buy numbers now!");
          System.out.println("You currently have: " + walletTwo + " to spend");
          System.out.println("You have currently bought: " + playerTwoNumbers);
          int boughtTwo = Integer.valueOf(scanner.nextLine());
          emptyLines(1);

          if (boughtTwo <= walletTwo && boughtTwo > 0 ) {
             numberCheck(boughtTwo);
             if (boughtTwo == 30) {
                System.out.println("You did not enter a valid number");
                emptyLines(1);
             }
             else {
                playerTwoNumbers.add(boughtTwo);
                walletTwo = walletTwo - boughtTwo;
             }
          }
          else {
             System.out.println("You did not enter a valid number!");
             emptyLines(1);
             i--;
          }
       }

       //summary of player Two
       emptyLines(2);
       System.out.println("Player one is out of money or has reached the maximum of 5 numbers!!");
       System.out.println("Player one has bought: " + playerTwoNumbers);

       //Summarizing the numbers everyone bought.
       emptyLines(5);
       System.out.println("The game is about to start with the following numbers");
       System.out.println("Player one has the following numbers: " + playerOneNumbers);
       System.out.println("Player two has the following numbers: " + playerTwoNumbers);
       emptyLines(5);
       System.out.println("Who will have the first turn?");
       System.out.println("Press 1 for player 1 and 2 for player 2");

       //Gives the choice who starts first in the first set.
       // if input is 2 it gets into an infinite loop.
       for (int i = 0; i != 1; i++) {
          int firstTurn = Integer.valueOf(scanner.nextLine());
          if (firstTurn == 1) {
             startDecider = 1;
             break;
          }
          else if (firstTurn == 2) {
             startDecider = 2;
             break;
          }
          else {
             System.out.println("The choice you made was wrong!");
             System.out.println("Only type 1 or 2!");
             i--;
          }
       }
       //deels kladblok
       //stel hier heeft speler 1 de beurt
       //System.out.println(startDecider); //de gekozen beurt is hier hetzelfde, 1 heeft dus de beurt
       //System.out.println(startDecider); // hier is 2 dus aan de beurt.
       //einde kladblok

       while (play == true) {
          int keuze = 0;
          //Hier kiest speler 1 zijn volgorde
          for (int i = 0; i < 6; i++) {
             if (startDecider == 1 && playerOneNumbers.size() > 0) {
                System.out.println("Player one, you must now decide in which order you want to employ your numbers");
                System.out.println("You have the following numbers to choose from");
                emptyLines(1);
                System.out.println(playerOneNumbers);
                emptyLines(1);
                System.out.println("Type in the number you want to play first.");
                System.out.println("For example if you have the numbers [4,3,2,1] and you want to use number 4, type 1.");
                keuze = Integer.valueOf(scanner.nextLine()) - 1;
                battleOneNumbers.add(keuze);
                playerOneNumbers.remove(keuze);

             }
             else if (startDecider == 2 && playerTwoNumbers.size() == 0) {
                startDecider = (setDecider(startDecider));
               i = 6;
                break;

             }
             else {
                System.out.println("The order for player one is");
                System.out.println(battleOneNumbers);
                startDecider = (setDecider(startDecider)); //hier wordt beurt doorgegeven aan de ander, 2 krijt de beurt
                i = 6;
                break;
             }

          }
          // hier kies speler twee zin volgorde
          for (int i = 0; i < 6; i++) {
             if (startDecider == 2 && playerTwoNumbers.size() > 0) {
                System.out.println("Player Two, you must now decide in which order you want to employ your numbers");
                System.out.println("You have the following numbers to choose from");
                emptyLines(1);
                System.out.println(playerTwoNumbers);
                emptyLines(1);
                System.out.println("Type in the number you want to play first.");
                System.out.println("For example if you have the numbers [4,3,2,1] and you want to use number 4, type 1.");
                keuze = Integer.valueOf(scanner.nextLine()) - 1;
                battleTwoNumbers.add(keuze);
                playerTwoNumbers.remove(keuze);
             }
             else if (startDecider == 2 && playerTwoNumbers.size() == 0) {
                i = 6;
                startDecider = (setDecider(startDecider));
                break;

             }
             else {
                System.out.println("The order for player Two is");
                System.out.println(battleTwoNumbers);
                i = 6;
                startDecider = (setDecider(startDecider));
                break;
             }
          }
          if (playerOneNumbers.size() == 0 && playerTwoNumbers.size() == 0){
             play = false;
          }
       }
       emptyLines(2);
       System.out.println("The following orders are set.");
       System.out.println("Player one: " + battleOneNumbers);
       System.out.println("Player two: " + battleTwoNumbers);


    }


   static int numberCheck(int input) {
      if (input > 5 && input < 0) {
         return input;
      }
      else {
         return 30;
      }
   }
   static void emptyLines(int aantal) {
       for (int i = 0; i < aantal; i++ ) {
          System.out.println("");
       }
   }
   static int setDecider(int i) {
       if (i == 1) {
          return 2;
       }
       else if (i == 2) {
          return 1;
       } else {
          System.out.println("You filled in a wrong number!");
          return setDecider(i); //correctionattempt
          // return 0;
       }
   }
   static void turnOne() {
      System.out.println("DIt is speler 1");
   }
   static void turnTwo() {
      System.out.println("Dit is speler 2");
   }
   static int choice(int i) {
       return 0;
   }
}



/**
 //Game explaining!
 System.out.println("Welcome to NumberEater");
 System.out.println("The rules are as follows, you have 10 points, with which you can buy numbers, the minimum number is 1, the highest is 5.");
 System.out.println("Every number costs its value, so a 2 costs 2 points.");
 System.out.println("After each player has chosen: their numbers the battle begins");
 System.out.println("Each player then picks which number he will insert, ");
 System.out.println("There are no decimal points, only whole numbers.");
 System.out.println("Entering decimal points might crash the app and I am too lazy to fix this.");
 System.out.println("MAKE SURE TO NEVER USE DECIMAL POINTS");
 emptyLines(1)
 System.out.println("Every set, contains of two turns, one from each player.");
 System.out.println("Every set the player who makes the first turn is altered");
 */



import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Random r = new Random();

        int sc = 0;
        char playAgn;

        System.out.println("WELCOME TO THE GUESSING NUMBER GAME ^.^");

        do {

            int rNmbr = r.nextInt(100) + 1; 
            System.out.println("RANDOM NUMBER" + rNmbr);
            int gs = 0;
            int atmpt = 0;
            int maxAtmpt = 10;

            System.out.println("i have selected a number between 1 and 100.");
            System.out.println("NOTE : YOU HAVE ONLY " + maxAtmpt + " ATTEMPTS.");

            while (gs != rNmbr && atmpt < maxAtmpt) {

                System.out.println("enter your guess: ");
                gs = s.nextInt();

                atmpt++;

                if (gs > rNmbr) {
                    System.out.println("too high.");
                } 
                else if (gs < rNmbr) {
                    System.out.println("too low.");
                } 
                else {
                    System.out.println("YO MAN U GUESSED THE RIGHT NUMBER-.-");
                    sc++;
                }

                System.out.println("ATTEMPTS LEFT: " + (maxAtmpt - atmpt));
            }

            if (gs != rNmbr) {
                System.out.println("oh no(heart break emoji)..u lost the game.");
                System.out.println("correct number was: " + rNmbr);
            }

            System.out.println("your current score" + sc);

            System.out.print("DO YOU WANT TO PLAY AGAIN  (y/n): ");
            playAgn = s.next().charAt(0);

        } while (playAgn == 'y' || playAgn == 'Y');

        System.out.println("thank you for playing... come back againn..see yaa");

        s.close();
    }
}
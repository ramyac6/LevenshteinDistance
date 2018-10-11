import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to LevDistance Calculator!");

        String word1;
        String word2;

        do {
            System.out.println("Enter first word: ");
            word1 = scan.next();
            System.out.println("Enter second word: ");
            word2 = scan.next();

            if (word1.length() != word2.length()) {
                System.out.println("Sorry the words must be of same length.");
            }
        } while (word1.length() != word2.length());

        new LevDistance(word1,word2);

    }
}





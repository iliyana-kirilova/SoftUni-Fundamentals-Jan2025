package Week7_objectsAndClasses;

import java.util.Random;
import java.util.Scanner;

public class RandomizeWords_Lab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        Random rnd = new Random();
        for (int position = 0; position <=words.length -1 ; position++) {
            int position1 = rnd.nextInt(words.length);
            int position2 = rnd.nextInt(words.length);

            String oldWord = words[position1];
            words[position1] = words[position2];
            words[position2] = oldWord;
        }
        System.out.println(String.join(System.lineSeparator(),words));
    }
}

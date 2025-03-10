package Week9_TextProcessing;

import java.util.Scanner;

public class Lab4_TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] forbiddenWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String forbiddenWord : forbiddenWords) {
            String replacement = "*".repeat(forbiddenWord.length());
            text = text.replace(forbiddenWord, replacement);
        }
        System.out.println(text);
    }
}

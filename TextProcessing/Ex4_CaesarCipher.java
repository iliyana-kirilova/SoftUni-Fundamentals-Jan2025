package Week9_TextProcessing;

import java.util.Scanner;

public class Ex4_CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder encryptedText = new StringBuilder();
        for (char symbol : input.toCharArray()) {
            char encryptedSymbol = (char) (symbol+3);
            encryptedText.append(encryptedSymbol);
        }
        System.out.println(encryptedText);

    }
}

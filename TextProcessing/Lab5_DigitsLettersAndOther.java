package Week9_TextProcessing;

import java.util.Scanner;

public class Lab5_DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder digit = new StringBuilder();
        StringBuilder letter = new StringBuilder();
        StringBuilder symbol = new StringBuilder();
        for (int i = 0; i <input.length() ; i++) {
            char currentChar = input.charAt(i);
            if (Character.isDigit(currentChar)) {
                digit.append(currentChar);
            } else if (Character.isAlphabetic(currentChar)) {
                letter.append(currentChar);
            }else {
                symbol.append(currentChar);
            }
        }
        System.out.println(digit);
        System.out.println(letter);
        System.out.println(symbol);
    }
}

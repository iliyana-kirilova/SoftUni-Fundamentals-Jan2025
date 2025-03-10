package Week9_TextProcessing;

import java.util.Scanner;

public class Lab1_ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("end")){
            String reverseText = "";
            for (int i = input.length()-1; i >=0 ; i--) {
                char currentSymbol = input.charAt(i);
                reverseText += currentSymbol;
            }
            System.out.println(input + " = " + reverseText);
            input = scanner.nextLine();
        }

    }
}

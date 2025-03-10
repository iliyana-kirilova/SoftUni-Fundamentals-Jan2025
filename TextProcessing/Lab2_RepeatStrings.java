package Week9_TextProcessing;

import java.util.Scanner;

public class Lab2_RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] text = scanner.nextLine().split(" ");

        for (String data : text) {
            int lenght = data.length();
            for (int count = 1; count <=lenght ; count++) {
                System.out.print(data);
            }
        }
    }
}

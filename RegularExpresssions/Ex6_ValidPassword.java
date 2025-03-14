package Week10_RegularExpresssions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex6_ValidPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countPassword = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("\\_\\.+(?<passwordText>[A-Z][A-Za-z0-9]{4,}[A-Z])\\_\\.+");

        for (int i = 1; i <=countPassword ; i++) {
            String text = scanner.nextLine();
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()){
                String passwordText = matcher.group("passwordText");
                StringBuilder sbDigit = new StringBuilder();
                //обхожда всички символи в паролата, взема и долепя всички цифри
                for (char symbol : passwordText.toCharArray()) {
                    if(Character.isDigit(symbol)){
                        sbDigit.append(symbol);
                    }
                }
                if (sbDigit.isEmpty()){
                    System.out.println("Group: default");
                } else {
                    System.out.println("Group: "+ sbDigit);
                }
            } else {
                System.out.println("Invalid pass!");
            }

        }
    }
}

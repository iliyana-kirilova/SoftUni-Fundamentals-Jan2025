package FinalExamPrep;

import java.util.Scanner;

public class Lab11_Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String command = scanner.nextLine();
        
        while (!command.equals("Registration")){
            if (command.contains("Letters")){
                if (command.contains("Lower")){
                    username = username.toLowerCase();
                    System.out.println(username);
                } else if (command.contains("Upper")) {
                    username = username.toUpperCase();
                    System.out.println(username);
                }
            } else if (command.contains("Reverse")) {
                int startIndex = Integer.parseInt(command.split("\\s+")[1]);
                int endIndex = Integer.parseInt(command.split("\\s+")[2]);
                if (startIndex>=0 && startIndex<username.length()
                    && endIndex>startIndex && endIndex<=username.length()){
                    String substring = username.substring(startIndex, endIndex+1);
                    StringBuilder reversed = new StringBuilder(substring);
                    reversed.reverse();
                    System.out.println(reversed);
                }
            } else if (command.contains("Substring")) {
                String substring = command.split("\\s+")[1];
                if (username.contains(substring)){
                    username = username.replace(substring, "");
                    System.out.println(username);
                }else {
                    System.out.printf("The username %s doesn't contain %s.%n",username, substring);
                }
            } else if (command.contains("Replace")) {
                String symbol = command.split("\\s+")[1];
                username = username.replace(symbol, "-");
                System.out.println(username);
            } else if (command.contains("IsValid")) {
                String symbol = command.split("\\s+")[1];
                if (username.contains(symbol)) {
                    System.out.println("Valid username.");
                }else {
                    System.out.printf("%s must be contained in your username.%n", symbol);
                }
            }
            command = scanner.nextLine();
        }
    }
}

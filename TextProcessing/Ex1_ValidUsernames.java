package Week9_TextProcessing;

import java.util.Scanner;

public class Ex1_ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split(", ");

        for (String username : input) {
            boolean validUsername = validateUsername(username);
            if (validUsername){
                System.out.println(username);
            }
        }
    }

    private static boolean validateUsername(String username) {
        if (username.length()<3 || username.length()>16){
            return false;
        }

        for (char symbol : username.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol) && symbol!='-' && symbol !='_'){
                return false;
            }
        }
        return true;
    }
}

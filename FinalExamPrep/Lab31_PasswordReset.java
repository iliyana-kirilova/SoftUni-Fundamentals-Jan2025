package FinalExamPrep;

import java.util.Scanner;

public class Lab31_PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();
        while (!command.equals("Done")){
            if (command.contains("TakeOdd")){
                StringBuilder password = new StringBuilder();
                for (int i = 1; i < input.length(); i+=2) {
                    password.append(input.charAt(i));
                }
                input=password;
                System.out.println(input);
            } else if (command.contains("Cut")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                int length = Integer.parseInt(command.split(" ")[2]);
                input.delete(index,index+length);
                System.out.println(input);
            } else if (command.contains("Substitute ")) {
                String substring = command.split(" ")[1];
                String substitute = command.split(" ")[2];
                String newPassword = input.toString();
                if (newPassword.contains(substring)){
                    newPassword = newPassword.replace(substring, substitute);
                    input = new StringBuilder(newPassword);
                    System.out.println(input);
                } else {
                    System.out.println("Nothing to replace!");
                }
            }
            command = scanner.nextLine();
        }
        System.out.printf("Your password is: %s", input);
    }
}

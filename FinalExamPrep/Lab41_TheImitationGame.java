package FinalExamPrep;

import java.util.Scanner;

public class Lab41_TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String encryptedMessage = scanner.nextLine();
        String  command = scanner.nextLine();
        StringBuilder sb = new StringBuilder(encryptedMessage);
        while (!command.equals("Decode")){
            String [] commandParts = command.split("\\|");
            String commandName = commandParts[0];

            if (commandName.equals("Move")){
                int numberOfLetters = Integer.parseInt(commandParts[1]);
                String substring = sb.substring(0, numberOfLetters);
                sb.delete(0,numberOfLetters);
                sb.append(substring);
            } else if (commandName.equals("Insert")) {
                int index = Integer.parseInt(commandParts[1]);
                String textToInsert = commandParts[2];
                sb.insert(index, textToInsert);
            } else if (commandName.equals("ChangeAll")) {
                String substring = commandParts[1];
                String replacement = commandParts[2];
                String text = sb.toString();
                text = text.replace(substring, replacement);
                sb = new StringBuilder(text);
            }
            command = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s%n", sb);

    }
}

package FinalExamPrep;

import java.util.Scanner;

public class Lab21_ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String activationKey = scanner.nextLine();
        String command = scanner.nextLine();
        while(!command.equals("Generate")){
            String[] commandParts = command.split(">>>");
            String commandName = commandParts[0];
            if (commandName.equals("Contains")){
                String substring = commandParts[1];
                if (activationKey.contains(substring)) {
                    System.out.println(activationKey +" contains "+ substring);
                }else {
                    System.out.println("Substring not found!");
                }
            } else if (commandName.equals("Flip")) {
                String type = commandParts[1];
                int startIndex = Integer.parseInt(commandParts[2]);
                int endIndex = Integer.parseInt(commandParts[3]);
                String textForReplace = activationKey.substring(startIndex, endIndex);
                String replacement = "";
                if (type.equals("Upper")){
                    replacement = textForReplace.toUpperCase();
                } else if (type.equals("Lower")) {
                    replacement = textForReplace.toLowerCase();
                }

                activationKey = activationKey.replace(textForReplace, replacement);
                System.out.println(activationKey);

            } else if (commandName.equals("Slice")) {
                int startIndex = Integer.parseInt(commandParts[1]);
                int endIndex = Integer.parseInt(commandParts[2]);
                String textForDelete = activationKey.substring(startIndex, endIndex);
                activationKey = activationKey.replace(textForDelete, "");
                System.out.println(activationKey);

                //начин 2: StringBuilder
                    /*StringBuilder sb = new StringBuilder(activationKey);
                    sb.delete(startPosition, endPosition);
                    //sb.toString() -> държим новата версия на activationKey с изтритите букви
                    activationKey = sb.toString();
                    System.out.println(activationKey);*/
            }
            command= scanner.nextLine();
        }

        System.out.println("Your activation key is: "+ activationKey);

    }
}

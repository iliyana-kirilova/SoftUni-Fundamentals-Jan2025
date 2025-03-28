package FinalExamPrep;

import java.util.Scanner;

public class Lab61_SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder(text);
        while (!input.equals("Reveal" )){
            String [] commandParts = input.split(":\\|:");
            String command = commandParts[0];
            switch (command) {
                case "InsertSpace" -> {
                    int index = Integer.parseInt(commandParts[1]);
                    sb.insert(index, " ");
                    System.out.println(sb);
                }
                case "Reverse" -> {
                    String substring = commandParts[1];

                    if (!sb.toString().contains(substring)) {
                        System.out.println("error");
                        input = scanner.nextLine();
                        continue;
                    }

                    int startIndex = sb.indexOf(substring);
                    int endIndex = startIndex + substring.length();
                    sb.delete(startIndex, endIndex);
                    sb.append(new StringBuilder(substring).reverse());

                    System.out.println(sb);
                }
                case "ChangeAll" -> {
                    String substring = commandParts[1];
                    String textToReplace = commandParts[2];

                    String updatedText = sb.toString().replace(substring, textToReplace);
                    sb.setLength(0);
                    sb.append(updatedText);

                    System.out.println(sb);
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", sb);
    }
}

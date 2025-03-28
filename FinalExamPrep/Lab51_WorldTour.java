package FinalExamPrep;

import java.util.Scanner;

public class Lab51_WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Travel")) {
            String[] commandParts = input.split(":");
            String command = commandParts[0];

            switch (command) {
                case "Add Stop" -> {
                    int index = Integer.parseInt(commandParts[1]);
                    String tourStop = commandParts[2];

                    if (index >= 0 && index <= sb.length()) {
                        sb.insert(index, tourStop);
                    }
                    System.out.println(sb);
                }
                case "Remove Stop" -> {
                    int startIndex = Integer.parseInt(commandParts[1]);
                    int endIndex = Integer.parseInt(commandParts[2]);

                    if (startIndex >= 0 && endIndex >= startIndex && endIndex < sb.length()) {
                        sb.delete(startIndex, endIndex + 1);
                    }
                    System.out.println(sb);
                }
                case "Switch" -> {
                    String oldString = commandParts[1];
                    String newString = commandParts[2];

                    if (sb.toString().contains(oldString)) {
                        String updatedText = sb.toString().replace(oldString, newString);
                        sb.setLength(0);
                        sb.append(updatedText);
                    }
                    System.out.println(sb);
                }
            }

            input = scanner.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s", sb);
    }
}

package FinalExamPrep;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab43_ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Piece> pieces = new LinkedHashMap<>();

        for (int i = 1; i <=n ; i++) {
            String [] input = scanner.nextLine().split("\\|");
            String piece = input[0];
            String composer = input[1];
            String key = input[2];

            pieces.put(piece, new Piece(composer, key));
        }

        String command = scanner.nextLine();
        while (!command.equals("Stop")){
            String [] commandParts = command.split("\\|");
            String commandName = commandParts[0];
            String piece = commandParts[1];
            switch (commandName){
                case "Add"->{
                    String composer = commandParts[2];
                    String key = commandParts[3];
                    if (pieces.containsKey(piece)) {
                        System.out.println(piece + " is already in the collection!");
                    } else {
                        pieces.put(piece, new Piece(composer, key));
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    }
                }
                case "Remove" ->{
                    if (pieces.containsKey(piece)){
                        pieces.remove(piece);
                        System.out.println("Successfully removed " + piece + "!");
                    }else {
                        System.out.println("Invalid operation! " + piece + " does not exist in the collection.");
                    }
                }
                case "ChangeKey" ->{
                    String newKey = commandParts[2];
                    if (pieces.containsKey(piece)){
                        pieces.get(piece).setKey(newKey);
                        System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                    } else {
                        System.out.println("Invalid operation! " + piece + " does not exist in the collection.");
                    }
                }
            }

            command = scanner.nextLine();
        }

        pieces.forEach((pieceName, pieceInfo) ->
                System.out.printf("%s -> Composer: %s, Key: %s%n", pieceName, pieceInfo.getComposer(), pieceInfo.getKey()));
    }
}

class Piece{
    private String composer;
    private String key;

    public Piece(String composer, String key) {
        this.composer = composer;
        this.key = key;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
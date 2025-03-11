package Week9_TextProcessing;

import java.util.Scanner;

public class Ex3_ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] path = scanner.nextLine().split("\\\\");

        String[] elements = path[path.length -1].split("\\.");
        String fileName = elements[0];
        String extensionName = elements[1];
        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + extensionName);

    }
}

package Week7_objectsAndClasses.Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] data = scanner.nextLine().split(", ");
        int n = Integer.parseInt(scanner.nextLine());

        String title = data[0];
        String content = data[1];
        String author = data[2];
        Articles articles = new Articles(title, content, author);
        for (int i = 1; i <=n ; i++) {
            String[] input = scanner.nextLine().split(": ");
            String command = input[0];
            String toSet = input[1];
            switch (command) {
                case "Edit" -> articles.setContent(toSet);
                case "ChangeAuthor" -> articles.setAuthor(toSet);
                case "Rename" -> articles.setTitle(toSet);
            }
        }
        System.out.printf("%s - %s: %s", articles.getTitle(), articles.getContent(), articles.getAuthor());
    }
}

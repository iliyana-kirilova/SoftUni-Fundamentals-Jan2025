package FinalExamPrep;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab62_MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String regex = "([@#])(?<firstWord>[A-Za-z]{3,})\\1{2}(?<secondWord>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        Map<String, String> wordsList = new TreeMap<>();
        int countPairs = 0;
        while (matcher.find()) {
            String firstWord = matcher.group("firstWord");
            String secondWord = matcher.group("secondWord");
            countPairs++;

            StringBuilder sb = new StringBuilder(firstWord);
            sb.reverse();

            if (secondWord.equals(sb.toString())) {
                wordsList.put(firstWord, secondWord);
            }
        }

        if (countPairs > 0) {
            System.out.printf("%d word pairs found!%n", countPairs);
        } else {
            System.out.println("No word pairs found!");
        }

        if (wordsList.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", wordsList.entrySet()
                    .stream()
                    .map(entry -> entry.getKey() + " <=> " + entry.getValue())
                    .toArray(String[]::new)));
        }

    }
}

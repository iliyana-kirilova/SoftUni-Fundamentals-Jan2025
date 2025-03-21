package FinalExamPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab32_EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(::|\\*\\*)([A-Z][a-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List <String> emoji = new ArrayList<>();

        while (matcher.find()){
            emoji.add(matcher.group());
        }

        long coolThreshold = 1;
        for (char symbol : input.toCharArray()) {
            if (Character.isDigit(symbol)) {
                coolThreshold*= Character.getNumericValue(symbol);
            }
        }

        List<String> coolEmoji = new ArrayList<>();
        for (String currentEmoji : emoji) {
            int sumEmoji = 0;
            for (char symbol : currentEmoji.toCharArray()) {
                if (Character.isAlphabetic(symbol)){
                    sumEmoji+=symbol;
                }
            }
            if (sumEmoji>coolThreshold){
                coolEmoji.add(currentEmoji);
            }
        }
        System.out.printf("Cool threshold: %d%n", coolThreshold);
        System.out.println(emoji.size() + " emojis found in the text. The cool ones are:");
        for (String entry : coolEmoji) {
            System.out.println(entry);
        }
    }
}

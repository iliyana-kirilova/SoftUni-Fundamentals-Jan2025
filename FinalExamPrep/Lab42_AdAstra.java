package FinalExamPrep;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab42_AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String regex = "(#|\\|)(?<itemName>[A-Za-z ]+)\\1" +
                "(?<expirationDate>\\d{2}/\\d{2}/\\d{2})\\1" +
                "(?<calories>\\d{1,5})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> foodItems = new ArrayList<>();
        int totalCalories = 0;

        while (matcher.find()) {
            String itemName = matcher.group("itemName").trim();
            String expirationDate = matcher.group("expirationDate");
            int calories = Integer.parseInt(matcher.group("calories"));

            totalCalories += calories;

            foodItems.add(String.format("Item: %s, Best before: %s, Nutrition: %d",
                    itemName, expirationDate, calories));
        }

        int daysLasted = totalCalories / 2000;

        System.out.printf("You have food to last you for: %d days!%n", daysLasted);
        for (String foodItem : foodItems) {
            System.out.println(foodItem);
        }
    }
}

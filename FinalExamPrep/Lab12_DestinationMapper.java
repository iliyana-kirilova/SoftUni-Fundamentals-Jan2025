package FinalExamPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab12_DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "([=|/])(?<destination>[A-Z][a-zA-Z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List <String> destination = new ArrayList<>();
        int pointsSummary = 0;

        while (matcher.find()) {
            String validDestination = matcher.group("destination");
            destination.add(validDestination);
            pointsSummary += validDestination.length();
        }

        System.out.println("Destinations: " + String.join(", ", destination));
        System.out.println("Travel Points: " + pointsSummary);
    }
}

package Week8_AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex1_countCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split(" ");

        Map<Character, Integer> allCharacters = new LinkedHashMap<>();
        for (int position = 0; position < input.length; position++) {
            String currentInput = input[position];
            for (int i = 0; i < currentInput.length(); i++) {
                char currentChar = currentInput.charAt(i);
                if (!allCharacters.containsKey(currentChar)){
                    allCharacters.put(currentChar,1);
                } else {
                    int currentCount = allCharacters.get(currentChar);
                    allCharacters.put(currentChar, currentCount+1);
                }
            }
        }

        allCharacters.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> "+ entry.getValue()));
    }
}

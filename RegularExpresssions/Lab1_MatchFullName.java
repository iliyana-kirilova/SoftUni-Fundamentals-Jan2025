package Week10_RegularExpresssions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab1_MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "\\b[A-Z][a-z]+ [A-Z][a-z]+\\b";

        Pattern pattern = Pattern.compile(regex); // създавам шаблон, като използвам регекс
        Matcher matcher = pattern.matcher(text);// да откривам съвпадения по шаблона, който съм създал

        while (matcher.find()){//дава true or false, ако намери следващо попадение
            System.out.print(matcher.group() + " ");
        }
    }
}

package Week10_RegularExpresssions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex4_NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] demonNames = scanner.nextLine()
                .replace(" ", "")
                .split(",");

        for (String demonName : demonNames) {
            int health = getHealth(demonName);
            double damage = getDamage(demonName);

            //модификация на damage спрямо името на демона
            for (char symbol : demonName.toCharArray()) {
                if (symbol == '*') {
                    damage *= 2;
                } else if (symbol == '/') {
                    damage /= 2;
                }
            }

            System.out.printf("%s - %d health, %.2f damage%n", demonName, health, damage);
        }

    }

    private static double getDamage(String demonName) {
        double damage = 0;
        Pattern pattern = Pattern.compile("\\-?[0-9]+\\.?[0-9]*");
        Matcher matcher = pattern.matcher(demonName);
        while (matcher.find()){
            damage+= Double.parseDouble(matcher.group());
        }

        return damage;
    }

    private static int getHealth(String demonName) {
        int health = 0;
        for (char symbol : demonName.toCharArray()) {
            if (symbol !='+' && symbol!='-'&& symbol!='*' && symbol != '.'
                    && symbol!='/' && !Character.isDigit(symbol)){
                health+= (int) symbol;
            }
        }
        return health;
    }
}

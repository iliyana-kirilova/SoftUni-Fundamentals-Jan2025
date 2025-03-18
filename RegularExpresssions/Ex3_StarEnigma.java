package Week10_RegularExpresssions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex3_StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        //създавам регекс за валидност на разшифрованото съобщение;
        String regex = "@(?<planet>[A-Za-z]+)[^@\\-!:>]*:(?<population>\\d+)[^@\\-!:>]*!" +
                "(?<typeAttack>[AD])![^@\\-!:>]*->(?<soldierCount>\\d+)[^@\\-!:>]*";
        Pattern pattern = Pattern.compile(regex);

        //създавам списъци, където ще добавям планетите
        List <String> attackersPlanets = new ArrayList<>();
        List <String> destroyedPlanets = new ArrayList<>();

        for (int i = 1; i <=n ; i++) {
            String encryptedMessage = scanner.nextLine();
            //разшифровам съобщението:
            String decryptedMessage = getDecryptedMessage(encryptedMessage);
            Matcher matcher = pattern.matcher(decryptedMessage);
            if (matcher.find()){
                String planetName = matcher.group("planet");
                String typeAttack = matcher.group("typeAttack");
                if (typeAttack.equals("A")){
                    attackersPlanets.add(planetName);
                }if (typeAttack.equals("D")){
                    destroyedPlanets.add(planetName);
                }
            }
        }
        Collections.sort(attackersPlanets);
        System.out.println("Attacked planets: "+ attackersPlanets.size());
        attackersPlanets.forEach(planet -> System.out.println("-> "+planet));

        Collections.sort(destroyedPlanets);
        System.out.println("Destroyed planets: "+ destroyedPlanets.size());
        destroyedPlanets.forEach(planet -> System.out.println("-> "+ planet));

    }

    private static String getDecryptedMessage(String encryptedMessage) {
        StringBuilder decrypted = new StringBuilder();
        int countLetters = getCountLetters(encryptedMessage);
        for (char symbol : encryptedMessage.toCharArray()) {
            // намаляваме всеки аски символ с ключа
            decrypted.append((char) (symbol - countLetters));
        }
        return decrypted.toString();
    }

    private static int getCountLetters(String encryptedMessage) {
        //намирам броя на бъквите, който ми е ключа за разшифроване на съобщението
        int count = 0;
        for (char symbol : encryptedMessage.toLowerCase().toCharArray()) {
            if(symbol =='s' || symbol =='t'|| symbol =='a'|| symbol =='r'){
                count++;
            }
        }
        return count;
    }
}

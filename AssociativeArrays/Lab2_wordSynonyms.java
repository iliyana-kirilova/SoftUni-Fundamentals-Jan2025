package Week8_AssociativeArrays;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.*;

public class Lab2_wordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wordCount = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> wordSynonymMap = new LinkedHashMap<>();
        for (int i = 1; i <=wordCount ; i++) {
            String word = scanner.nextLine();
            String synonym= scanner.nextLine();
            //Ако думата я няма, я добавяме в празен списък.
            //Ако я има, няма да се добави в списъка.
            wordSynonymMap.putIfAbsent(word, new ArrayList<>());

            wordSynonymMap.get(word).add(synonym);
        }
        for (Map.Entry<String, List<String>> entry: wordSynonymMap.entrySet()){
            System.out.println(entry.getKey()+ " - "+ String.join(", ", entry.getValue()));
        }
    }
}

package Week8_AssociativeArrays;

import java.util.*;

public class Ex9_forceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> teams = new LinkedHashMap<>();
        // ключът е името на отбора, списъкът е пълен с имена
        String input = scanner.nextLine();
        while (!input.equals("Lumpawaroo")) {

            if (input.contains("|")) {
                //Light | Peter
                // | е специален символ, затова поставяме \\,  за да използваме | като символ
                String teamName = input.split(" \\| ")[0];
                String playerName = input.split(" \\| ")[1];
                //проверявам дали има такъв отбор и създавам нов с празен списък от игрчи, ако няма
                if (!teams.containsKey(teamName)) {
                    teams.put(teamName, new ArrayList<>());
                }

                //проверявам дали такъв играч, вече фигурира в друг отбор
                boolean isThisPlayerPartOfAnotherTeam = false;
                //teams.values().for -> връща списък с всички валюта от мапа - дава ми всички листове заедно
                for (List<String> players : teams.values()) {
                    if (players.contains(playerName)) {
                        isThisPlayerPartOfAnotherTeam = true;
                        break;
                    }
                }

                //ако не е част към друг отбор, ще го прибавим към този
                if (!isThisPlayerPartOfAnotherTeam) {
                    teams.get(teamName).add(playerName);
                }

            } else if (input.contains("->")) {
                //Ivan Ivanov -> Lighter
                String playerName = input.split(" -> ")[0];
                String teamName = input.split(" -> ")[1];

                //обхождам всички отбори и премахвам играча от текущия му отбор
                //teams.values().for -> връща списък с всички валюта от мапа - дава ми всички листове заедно
                for (List<String> players : teams.values()) {
                    // тази операция премахва елемент, само ако той съществъва - връща boolean променлива
                    players.remove(playerName);
                }

                //ако нямаме такъв отбор, създаваме нов отбор с празен списък и след това добавяме играча
                if (teams.containsKey(teamName)) {
                    teams.get(teamName).add(playerName);
                } else {
                    teams.put(teamName, new ArrayList<>());
                    teams.get(teamName).add(playerName);
                }
                System.out.printf("%s joins the %s side!%n", playerName, teamName);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : teams.entrySet()) {
            String teamName = entry.getKey();
            List<String> players = entry.getValue();

            //принтираме само, когато имаме играчи в отбора
            if (!players.isEmpty()) {
                System.out.printf("Side: %s, Members: %d%n", teamName, players.size());
                players.forEach(player -> System.out.printf("! %s%n", player));
            }
        }
    }
}

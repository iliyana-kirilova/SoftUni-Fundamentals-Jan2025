package FinalExamPrep;

import java.util.*;

public class Lab33_PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> plants = new LinkedHashMap<>();
        Map<String, List<Double>> plantsRating = new LinkedHashMap<>();
        for (int i = 1; i <=n ; i++) {
            String input = scanner.nextLine();
            String plant = input.split("<->")[0];
            int rarity = Integer.parseInt(input.split("<->")[1]);
            plants.put(plant, rarity);

            plantsRating.putIfAbsent(plant, new ArrayList<>());
        }

        String command = scanner.nextLine();
        while (!command.equals("Exhibition")){
            String [] commandParts = command.split(": ");
            String commandName = commandParts[0];
            String plant = commandParts[1].split(" - ")[0];

            if (!plantsRating.containsKey(plant)){
                System.out.println("error");
                command = scanner.nextLine();
                continue;
            }
            if (commandName.equals("Rate")){
                double rating = Double.parseDouble(commandParts[1].split(" - ")[1]);
                plantsRating.get(plant).add(rating);
            } else if (commandName.equals("Update")) {
                int newRarity = Integer.parseInt(commandParts[1].split(" - ")[1]);
                plants.put(plant, newRarity);
            } else if (commandName.equals("Reset")) {
                plantsRating.get(plant).clear();
            }

            command = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        plants.entrySet().forEach(entry ->{
            String plantName = entry.getKey();
            int rarity = entry.getValue();
            double avgRating = plantsRating.get(plantName)
                                .stream().mapToDouble(rating-> rating).average().orElse(0.0);
                //мапвам към double  променлива и намирам средната стойност, но ако нямам такава стойност връщам 0

            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", plantName, rarity, avgRating);
        });

    }
}

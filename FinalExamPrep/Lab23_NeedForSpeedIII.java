package FinalExamPrep;

import java.util.*;

public class Lab23_NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Integer>> carsMap = new LinkedHashMap<>();
        int countCars = Integer.parseInt(scanner.nextLine());
        for (int car = 1; car <= countCars; car++) {
            String [] data = scanner.nextLine().split("\\|");

            String carModel = data[0]; //модел на колата
            int mileage = Integer.parseInt(data[1]); //изминати км = пробег
            int fuel = Integer.parseInt(data[2]); //налично гориво

            carsMap.putIfAbsent(carModel, new ArrayList<>());
            carsMap.get(carModel).add(0, mileage);
            carsMap.get(carModel).add(1, fuel);
        }

        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String [] commandParts = command.split(" : ");
            String commandName = commandParts[0];
            String carModel = commandParts[1];

            switch (commandName) {
                case "Drive" -> {
                    int distance = Integer.parseInt(commandParts[2]);
                    int consumedFuel = Integer.parseInt(commandParts[3]);

                    int currentFuel = carsMap.get(carModel).get(1); //текущото гориво в колата
                    int currentKm = carsMap.get(carModel).get(0); //текущ пробег на колата
                    if (currentFuel >= consumedFuel) {
                        //заминаваме и пристигаме
                        carsMap.get(carModel).set(0, currentKm + distance);
                        carsMap.get(carModel).set(1, currentFuel - consumedFuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", carModel, distance, consumedFuel);
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }

                    if (carsMap.get(carModel).get(0) >= 100000) {
                        //колата е стара -> премахваме
                        carsMap.remove(carModel);
                        System.out.printf("Time to sell the %s!%n", carModel);
                    }
                }
                case "Refuel" -> {
                    int fuelToRefill = Integer.parseInt(commandParts[2]); //колко литра зареждаме
                    int currentFuel = carsMap.get(carModel).get(1); //текущото гориво в колата

                    if (currentFuel + fuelToRefill <= 75) {
                        carsMap.get(carModel).set(1, currentFuel + fuelToRefill);
                        System.out.printf("%s refueled with %d liters%n", carModel, fuelToRefill);
                    } else {
                        carsMap.get(carModel).set(1, 75);
                        System.out.printf("%s refueled with %d liters%n", carModel, 75 - currentFuel);
                    }
                }
                case "Revert" -> {
                    int kmRevert = Integer.parseInt(commandParts[2]); //км, които трябва да върнем
                    int currentKm = carsMap.get(carModel).get(0);//текущи км на колата

                    int kmAfterRevert = currentKm - kmRevert;
                    if (kmAfterRevert < 10000) {
                        carsMap.get(carModel).set(0, 10000);
                    } else {
                        carsMap.get(carModel).set(0, kmAfterRevert);
                        System.out.printf("%s mileage decreased by %d kilometers%n", carModel, kmRevert);
                    }
                }
            }
            command = scanner.nextLine();
        }

        //"{car} -> Mileage: {mileage} kms, Fuel in the tank: {fuel} lt."
        //entry
        //key: модел на колата
        //value: {км, гориво}
        carsMap.entrySet().forEach(entry -> {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                    entry.getKey(),
                    entry.getValue().get(0),
                    entry.getValue().get(1));
        });
    }
}

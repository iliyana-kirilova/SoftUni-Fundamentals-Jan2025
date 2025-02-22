package Week7_objectsAndClasses.VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <Vehicle> vehicles = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")){
            String type = input.split(" ")[0];
            String model = input.split(" ")[1];
            String color = input.split(" ")[2];
            int horsepower = Integer.parseInt(input.split(" ")[3]);

            if (type.equals("car")) {
                type = "Car";
            } else {
                type = "Truck";
            }

            Vehicle vehicle = new Vehicle(type, model,color, horsepower);
            vehicles.add(vehicle);

            input = scanner.nextLine();
        }
        String model = scanner.nextLine();
        while (!model.equals("Close the Catalogue")) {
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getModel().equals(model)) {
                    System.out.println("Type: " + vehicle.getType());
                    System.out.println("Model: " + vehicle.getModel());
                    System.out.println("Color: " + vehicle.getColor());
                    System.out.println("Horsepower: " + vehicle.getHorsepower());
                }
            }
            model = scanner.nextLine();
        }
        double carsAvgHorsePower = getAvgHorsePower(vehicles, "Car");
        double trucksAvgHorsePower = getAvgHorsePower(vehicles, "Truck");

        System.out.printf("Cars have average horsepower of: %.2f.\n", carsAvgHorsePower);
        System.out.printf("Trucks have average horsepower of: %.2f.", trucksAvgHorsePower);
    }

    private static double getAvgHorsePower(List<Vehicle> vehicles, String type) {
        int count = 0;
        double sum = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType().equals(type)) {
                count++;
                sum += vehicle.getHorsepower();
            }
        }

        if (count == 0 || sum == 0) {
            return 0;
        }
        return sum / count;
    }
}

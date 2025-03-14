package Week10_RegularExpresssions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex1_Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>[0-9]+[.]?[0-9]*)!(?<quantity>[0-9]+)";
        //изписване на дробно или цяко число на цената!!!
        Pattern pattern = Pattern.compile(regex);
        double totalPrice = 0;

        System.out.println("Bought furniture:");
        while (!input.equals("Purchase")){
            Matcher matcher = pattern.matcher(input);
            // matcher - съвкупност от всички текстове, които отговарят на шаблона

            if (matcher.find()){
                String furniture = matcher.group("furniture");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                System.out.println(furniture);
               double pricePerFurniture=price*quantity;
               totalPrice+=pricePerFurniture;

            }

            input = scanner.nextLine();
        }
        System.out.printf("Total money spend: %.2f",totalPrice );
    }
}

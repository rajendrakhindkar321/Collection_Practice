package Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapDemo {

    public static void main(String[] args) {
        boolean continueInput = true;
        Map<String, String> map = new HashMap<>();

        while(continueInput) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Customer Name: ");
            String custName = sc.nextLine();
            System.out.println("Enter Customer ID: ");
            String custId = sc.nextLine();

            if (map.containsKey(custId)) {
                System.out.println("Customer ID already exists. Please enter a unique ID.");
                continue; // Skip adding the new customer
            }

            map.put(custId, custName);

            System.out.println("Do you want to add another customer? (Y/N): ");
            String choice = sc.nextLine().toUpperCase();
            continueInput = choice.equals("Y");
        }

        System.out.println("Customer List");
//        for(Map.Entry m:map.entrySet()){
//            System.out.println("Customer Name: " + m.getKey() + " Customer Id: " + m.getValue());
//
//        }
        map.forEach((custID, custName)-> {
            System.out.println("Customer Name:" + custID + " Customer Name: " + custName);
        });


    }
}

package Collection;

import java.util.*;

public class CustomerFoodItems {
    public static void main(String[] args) {
        Map<String, List<String>> customerItemsMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        boolean continueInput = true;

        while (continueInput) {
            System.out.println("Enter customer name:");
            String customerName = scanner.nextLine();

            System.out.println("Enter food items for " + customerName + " (separated by commas):");
            String foodItemsInput = scanner.nextLine();
            List<String> foodItems = Arrays.asList(foodItemsInput.split("\\s*,\\s*"));

            customerItemsMap.put(customerName, foodItems);

            System.out.println("Do you want to add another customer? (Y/N)");
            String choice = scanner.nextLine().toUpperCase();
            continueInput = choice.equals("Y");
        }

        // Displaying customers and their associated food items
//        for (Map.Entry<String, List<String>> entry : customerItemsMap.entrySet()) {
//            String customerName = entry.getKey();
//            List<String> items = entry.getValue();
//
//            System.out.println("Customer: " + customerName);
//            System.out.println("Food items: " + items);
//        }
        customerItemsMap.forEach((key, value) -> {
            System.out.println("Customer: " + key);
            System.out.println("Food items: " + value);
        });
    }
}

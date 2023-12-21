package Collection;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FoodOrderDemo {
    private Map<String, List<String>> customerFoodMap = new HashMap<>();

    public static void main(String[] args) {

        boolean  continueInput = true;
        Scanner sc = new Scanner(System.in);
        FoodOrderDemo f = new FoodOrderDemo();

        while(continueInput) {
            System.out.println("Enter the Customer Name:");
            String custName = sc.nextLine();

            System.out.println("Select the Pizzas:");
            String foodInput = sc.nextLine();
            List<String> foodItems = Arrays.asList(foodInput.split("\\s*,\\s*"));

            f.storeFoodItems(custName, foodItems);


            System.out.println("Do you want to continue [Y/N]: ");
            String choice = sc.nextLine().toUpperCase();
            continueInput = choice.equals("Y");


        }

        f.display();
        System.out.println("Enter the Customer Name to Update Items:");
        String updateName = sc.nextLine();
        System.out.println("Select the Pizza: ");
        String foodInput = sc.nextLine();
        List<String> newfoodItems = Arrays.asList(foodInput.split("\\s*,\\s*"));

        f.updateFoodItems(updateName, newfoodItems );
        f.display();
    }

    private void display() {
        AtomicInteger finalOrderNo = new AtomicInteger(1);
        customerFoodMap.forEach((key, value) -> {
            System.out.println("Order No: " + finalOrderNo.getAndIncrement());
            System.out.println("Customer Name: " + key);
            System.out.println("Items: " + value);
        });
    }

    private void updateFoodItems(String custName, List<String> newfoodItems){
        if(customerFoodMap.containsKey(custName)){
            customerFoodMap.put(custName, newfoodItems);
        }
    }

    private void storeFoodItems(String custName, List<String> foodItems){
        customerFoodMap.put(custName, foodItems);
    }
}

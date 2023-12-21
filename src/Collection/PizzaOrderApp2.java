package Collection;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class PizzaOrderApp2 {

    Map<String, List<String>> maps = new HashMap<>();
    public static void main(String[] args) {

        PizzaOrderApp2 pz = new PizzaOrderApp2();
        Scanner sc = new Scanner(System.in);

        String customerName;
        List<String> selectPizza;
        boolean continueInput = true;

        while(continueInput){

            System.out.println("Choose an operation:");
            System.out.println("0. Place Order");
            System.out.println("1. Get All The Orders");
            System.out.println("2. Change The Items");
            System.out.println("3. Cancel Order");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");

            int input = sc.nextInt();
            sc.nextLine();

            switch (input){

                case 0:  System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    pz.takeOrder(sc);
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    break;

                case 1:  System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    pz.display();
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    break;
                case 2:
                    pz.updateEmployee(sc);
                    break;
                case 3:
                    pz.deleteEmployee(sc);
                    break;
                case 4:
                    continueInput = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }


        }
    }

    private void takeOrder(Scanner sc) {
        System.out.println("Enter the Customer Name: ");
        String customerName = sc.nextLine();

        System.out.println("Enter the Pizzas: ");
        String Input = sc.nextLine();
        List<String> selectPizza = Arrays.asList(Input.split("\\s*,\\s*"));

//        System.out.println("Enter the Pizza Quantity: ");
//        String quantity = sc.nextLine();

        store(customerName, selectPizza);
    }

    private void deleteEmployee(Scanner sc) {
        System.out.println("Enter the Customer Name: ");
        String custName = sc.nextLine();
        if(maps.containsKey(custName)){
            maps.remove(custName);
            System.out.println("Order for the Customer " + custName + " has cancelled successfully.");

        }
        else {
            System.out.println("Order for the Customer " + custName + " not found.");
        }
    }

    private void updateEmployee(Scanner sc) {

            System.out.println("Enter the Customer Name to update order: ");
            String Name = sc.nextLine();

            if(maps.containsKey(Name)){
                System.out.println("Enter the Pizzas: ");
                String newItems = sc.nextLine();
                List<String> newPizzaItems = Arrays.asList(newItems.split("\\s*,\\s*"));
                maps.put(Name, newPizzaItems);
            }
            else{
                System.out.println("Customer " + Name + " not found.");

        }
    }

    private void display() {
        AtomicInteger orderNum = new AtomicInteger(1);
        if(!maps.isEmpty()) {
            maps.forEach((key, value) -> {
                System.out.println("Order No:" + orderNum.getAndIncrement());
                System.out.println("Customer Name: " + key);
                System.out.println("Items: " + value);
            });
        }
        else{
                System.out.println("There is not any order found. Please Place an order.");
            }
    }

    private void store(String customerName, List<String> selectPizza) {

        maps.put(customerName, selectPizza);
    }
}

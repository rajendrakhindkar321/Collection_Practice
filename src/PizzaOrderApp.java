import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PizzaOrderApp {

    public static void main(String[] args) {

        String custName;
        String selectPizza;
        int orderNo = 1;
        String quantity;

        boolean continueInput = true;
        Scanner sc = new Scanner(System.in);


        while(continueInput) {

            System.out.println("Enter the Customer Name: ");
            custName = sc.nextLine();
            System.out.println("Select the Pizza: ");
            selectPizza = sc.nextLine();
            System.out.println("Select the Qunatiy: ");
            quantity = sc.nextLine();

            Map<String, String> orderDetails = placeOrder(selectPizza, quantity);
            displayOrder(orderNo, custName, orderDetails);
            orderNo++;

        }

        System.out.println("Do you want to continue[Y/N] : ");
        String choice = sc.nextLine().toUpperCase();
        continueInput = choice.equals("Y");





    }

    public static Map<String, String> placeOrder(String selectPizza, String quantity){

        Map<String, String> map = new HashMap<>();
        map.put(selectPizza, quantity);
//        map.forEach((key, value) -> {
//            System.out.println("Items:" + key + " Quantity: " + value);
//        });

        return map;

    }

    public static void displayOrder(int orderNo, String custName, Map <String, String> orderDetails){

        System.out.println("Order No: " + orderNo);
        System.out.println("Customer Name: " + custName);
        System.out.println("Order Details:");

        orderDetails.forEach((key, value) -> {
            System.out.println("Items: " + key);
            System.out.println("Quantity: "+ value);
        });
        System.out.println("---------------------------------------------------------------------------");
    }
}

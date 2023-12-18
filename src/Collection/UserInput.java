package Collection;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Map<String, Integer>> userOrders = new HashMap<>();
        int orderNo = 1;

        boolean continueOrdering = true;
        while (continueOrdering) {
            System.out.println("Enter The User Name ('submit' to finish):");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("submit")) {
                continueOrdering = false;
                break;
            }

            Map<String, Integer> names = new HashMap<>();

            while (true) {
                System.out.println("Enter the name of Pizza (enter 'done' to finish): ");
                String str = sc.nextLine();

                if (str.equalsIgnoreCase("done")) {
                    break;
                }

                System.out.println("Enter the Quantity of Pizza: ");
                int n = Integer.parseInt(sc.nextLine());

                names.put(str, n);
            }

            userOrders.put(input, names);
        }

        System.out.println("Order details:");
        for (Map.Entry<String, Map<String, Integer>> userEntry : userOrders.entrySet()) {
            System.out.println("UserId: " + userEntry.getKey());
            System.out.println("-------------------------------------------------");
            for (Map.Entry<String, Integer> orderEntry : userEntry.getValue().entrySet()) {
                System.out.println("Order No: " + orderNo);
                System.out.println("-------------------------------------------------");
                LocalDateTime localDateTime = LocalDateTime.now();
                System.out.println(localDateTime);
                System.out.println("-------------------------------------------------");
                System.out.println("Customer Name : " + userEntry.getKey());
                System.out.println("-------------------------------------------------");
                System.out.println("Pizza Name: " + orderEntry.getKey());
                System.out.println("Quantity of each Pizza : " + orderEntry.getValue());
                System.out.println("-------------------------------------------------");
                orderNo++;
            }
        }

        sc.close();
    }
}

package Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployDetails {

    private Map<Integer, String> map;

    public EmployDetails(){
        map = new HashMap<>();
    }
    public static void main(String[] args) {

        EmployDetails em = new EmployDetails();
        Scanner sc = new Scanner(System.in);
        boolean continueInput = true;

        while(continueInput){

            System.out.println("Choose an operation:");
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    em.createEmployee(sc);
                    break;
                case 2:
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    em.display();
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    break;
                case 3:
                    em.updateEmployee(sc);
                    break;
                case 4:
                    em.deleteEmployee(sc);
                    break;
                case 5:
                    continueInput = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
            }
        }

    private void deleteEmployee(Scanner sc) {
        System.out.println("Enter Employee ID to delete: ");
        Integer deleteID = sc.nextInt();
        if (map.containsKey(deleteID)) {
            map.remove(deleteID);
            System.out.println("Employee with ID " + deleteID + " deleted successfully.");
        } else {
            System.out.println("Employee with ID " + deleteID + " not found.");
        }
    }

    private void updateEmployee(Scanner sc) {
        System.out.println("Enter Employee ID to Update: ");
        Integer updateID = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the New Name:");
        String newName = sc.nextLine();
        if (map.containsKey(updateID)) {
            map.put(updateID,newName);
            System.out.println("Employee with ID " + updateID + " updated successfully.");
        } else {
            System.out.println("Employee with ID " + updateID + " not found.");
        }
    }

    private void display() {

        map.forEach((studentID,studentName) -> {
            System.out.println("Student ID :" + studentID);
            System.out.println("Student Name is: " + studentName);
        });
    }

    private void createEmployee(Scanner sc) {
        System.out.println("Enter the Employee ID: ");
        Integer studentID = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Employee Name: ");
        String studentName = sc.nextLine();
        store1(studentID,studentName);
        System.out.println("Employee added successfully");
    }

    public void store1(Integer studentID, String studentName){
        map.put(studentID, studentName);
}
}

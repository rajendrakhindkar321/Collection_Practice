package Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapExample {

    private Map<String, String> map = new HashMap<>();
    public static void main(String[] args) {

        String StudentID;
        String StudentName;
        boolean continueInput = true;

        Scanner sc = new Scanner(System.in);
        HashMapExample h = new HashMapExample();

        while (continueInput){

            System.out.println("Enter is Student ID: ");
            StudentID = sc.nextLine();
            System.out.println("Enter is Student Name: ");
            StudentName = sc.nextLine();

            h.Store(StudentID, StudentName);

            System.out.println("Do you want to continue[Y/N]: ");
            String choice = sc.nextLine().toUpperCase();
            continueInput = choice.equals("Y");

        }
        System.out.println("Students List: ");
        System.out.println("---------------------Show All records------------------------------");
        h.display();
        System.out.println("---------------------------------------------------");


        System.out.println("Enter Student ID to delete: ");
        String deleteID = sc.nextLine();
        h.delete(deleteID);
        System.out.println("--------------------List After deleting the record-------------------------------");
        h.display();
        System.out.println("---------------------------------------------------");


        System.out.println("Enter the Student ID to update: ");
        String updateID = sc.nextLine();
        System.out.println("Enter the new Student Name: ");
        String newName = sc.nextLine();
        h.updateStudentrecord(updateID, newName);
        System.out.println("---------------------Updated List------------------------------");
        h.display();
        System.out.println("---------------------------------------------------");

        System.out.println("Enter the Student ID to fetch record: ");
        String getID = sc.nextLine();
        System.out.println("---------------------Get Employee by ID ------------------------------");
        h.getStudentrecord(getID);
        System.out.println("---------------------------------------------------");




    }

    private void getStudentrecord(String getID) {

        if(map.containsKey(getID)){
            System.out.println("Student details for ID " + getID + ":");
            System.out.println("Employee ID: " + getID + ", Employee Name: " + map.get(getID));
        } else {
            System.out.println("Employee with ID " + getID + " not found.");
        }
    }

    private void updateStudentrecord(String updateID, String newName) {
        if(map.containsKey(updateID)){
            map.put(updateID, newName);
            System.out.println("Employee with ID " + updateID + " updated successfully.");
        } else {
            System.out.println("Employee with ID " + newName + " not found.");
        }

    }

    public void Store(String StudentID, String StudentName){
        map.put(StudentID, StudentName);
    }

    public void display(){
        map.forEach((key, value) -> {
            System.out.println("Student ID is: " + key);
            System.out.println("Student Name is: " + value);

        });
    }

    public void delete(String StudentID){
        if (map.containsKey(StudentID)) {
            map.remove(StudentID);
            System.out.println("Student with ID: " + StudentID + " deleted successfully");
        }
        else {
            System.out.println("Student with ID: " + StudentID + " not found");
        }

    }
}


package Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentDetails {

    Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {

        String studentID;
        String studentName;
        boolean continueInput = true;

        StudentDetails h = new StudentDetails();
        Scanner sc = new Scanner(System.in);

        while(continueInput){
            System.out.println("Enter the Student ID: ");
            studentID = sc.nextLine();
            System.out.println("Enter the Student Name:");
            studentName = sc.nextLine();

            h.store(studentID, studentName);

            System.out.println("Do you want to continue [Y/N]?");
            String choice = sc.nextLine().toUpperCase();
            continueInput = choice.equals("Y");
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        h.display();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


        System.out.println("To update the record enter the Student ID:");
        String updateID = sc.nextLine();
        System.out.println("Enter the new name:");
        String newName = sc.nextLine();
        h.updateStudentDetais(updateID, newName);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        h.display();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


        System.out.println("To delete the record enter the Student ID:");
        String deleteID = sc.nextLine();
        h.deleteStudentDetails(deleteID);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        h.display();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


        System.out.println("To fetch the record enter the Student ID:");
        String getID = sc.nextLine();
        h.fetchStudentDetais(getID);
    }

    private void createStudentDetais(String updateID, String newName) {
        if(map.containsKey(updateID)){
            map.put(updateID, newName);
        }
        else {
            System.out.println("Student ID " + updateID + " not found");
        }
    }

    private void fetchStudentDetais(String getID) {
        if(map.containsKey(getID)){
            System.out.println("Student details for ID " + getID + ":");
            System.out.println("Student ID: " + getID);
            System.out.println("Student Name: " + map.get(getID));
        }
        else {
            System.out.println("Student ID " + getID + " not found");
        }
    }

    private void deleteStudentDetails(String deleteID) {
        if(map.containsKey(deleteID)){
            map.remove(deleteID);
        }
        else {
            System.out.println("Student ID " + deleteID + " not found");
        }
    }

    private void updateStudentDetais(String updateID, String newName) {
        if(map.containsKey(updateID)){
            map.put(updateID, newName);
        }
        else {
            System.out.println("Student ID " + updateID + " not found");
        }
    }

    private void display() {

        map.forEach((studentID, studentName) -> {
            System.out.println("Student ID: " + studentID);
            System.out.println("Student Name: " + studentName);
        });
    }

    private void store(String studentID, String studentName) {
        map.put(studentID,studentName);
    }
}

package src;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Student extends Database {

    static Scanner scan = new Scanner(System.in);

    public static void studentMenu() throws InterruptedException {
        String vote = "";
        do {
            System.out.println(
                    "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                            "================== STUDENT MENU =================\n" +
                            "\t   1- Print Student List\n" +
                            "\t 2- Finding a Student by Surname\n" +
                            "\t 3- Finding Students with Class and Branch\n" +
                            "\t 4- Adding Students by Entering Their Information\n" +
                            "\t 5- Deleting Registration with ID Number \t\n" +
                            "\t A- MAIN MENU\n" +
                            "\t Q- EXIT");
            vote = scan.nextLine().toLowerCase();
            switch (vote) {
                case "1":
                    printStudentList();
                    break;
                case "2":
                    findStudentBySurname();
                    break;
                case "3":
                    findStudentByClass();
                    break;
                case "4":
                    addStudent();
                    break;
                case "5":
                    deletedWithTcId();
                    break;
                case "a":
                    Helper.mainMenu();
                    break;
                case "q":
                    Helper.exitProject();
                    break;
                default:
                    System.out.println("Please enter a valid preference");
            }


        } while (!vote.equalsIgnoreCase("q"));
        Helper.exitProject();

    }

    private static void deletedWithTcId() throws InterruptedException {
        System.out.println("Enter the student ID number to be deleted.");
        String deletedStudent = scan.nextLine();

        String deletedValue = studentsMap.get(deletedStudent);
        String resultValue = studentsMap.remove(deletedStudent);

        System.out.print(deletedStudent + " Deleting...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }


        try {
            boolean result = resultValue.equals(deletedValue);
        } catch (Exception e) {
            System.out.println("No student was found with the TR ID number you requested.");
        }

    }

    private static void addStudent() {
        System.out.println("Tc no");
        String tcNo = scan.nextLine();
        System.out.println("Name");
        String name = scan.nextLine();
        System.out.println("Surname");
        String surname = scan.nextLine();
        System.out.println("B.Year");
        String birthYear = scan.nextLine();
        System.out.println("School Id");
        String schoolNo = scan.nextLine();
        System.out.println("Class");
        String studentClass = scan.nextLine();
        System.out.println("Branch");
        String branch = scan.nextLine();

        String key = tcNo;
        String value = name + ", " + surname + ", " + birthYear + ", " + schoolNo + ", " +
                studentClass + ", " + branch;
        studentsMap.put(key, value);
    }

    private static void findStudentByClass() throws InterruptedException {
        Set<Map.Entry<String, String>> myEntrySet = studentsMap.entrySet();

        System.out.println("Write the student class you want");
        String desiredClass = scan.nextLine();
        System.out.println("Write the student branch you want");
        String desiredBranch = scan.nextLine();

        System.out.print(desiredClass + "," + desiredBranch + " Scanning...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "================= STUDENT LIST ===============\n" +
                        "TR Number: Name, Surname, D Year, School Number, Class, Branch");

        for (Map.Entry<String, String> each : myEntrySet)
        {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValueArr = eachValue.split(", ");
            if (desiredClass.equalsIgnoreCase(eachValueArr[4]) && desiredBranch.equalsIgnoreCase(eachValueArr[5]))
                System.out.println(eachKey + " : " + eachValue + " | ");
        }
    }


    private static void findStudentBySurname() throws InterruptedException {
        Set<Map.Entry<String, String>> myEntrySet = studentsMap.entrySet();

        System.out.println("Write the student surname you want");
        String desiredSurname = scan.nextLine();

        System.out.print(desiredSurname + " searching..");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "================= STUDENT LIST ===============\n" +
                        "TR Number: Name, Surname, D Year, School Number, Class, Branch");


        for (Map.Entry<String, String> each : myEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValueArr = eachValue.split(", ");

            if (desiredSurname.equalsIgnoreCase(eachValueArr[1])) {
                System.out.println(eachKey + "  : " + eachValue);
            }
        }
    }

    private static void printStudentList() throws InterruptedException {

        Set<Map.Entry<String, String>> myEntrySet = studentsMap.entrySet();

        System.out.print("Registered Students are printing...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "================ STUDENT LIST ================\n" +
                            "Tc ID    :   NAME , SURNAME , YEAR , SCHOOL ID , Class , Branch");

        for (Map.Entry<String, String> each : myEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            System.out.println(eachKey + " : " + eachValue + " | ");
        }
    }
}

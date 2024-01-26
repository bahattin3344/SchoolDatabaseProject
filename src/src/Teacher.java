package src;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Teacher extends Database {
    static Scanner scan = new Scanner(System.in);

    public static void teacherMenu() throws InterruptedException {
        String vote = "";
        do {

            System.out.println(
                    "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                            "================= TEACHER MENU =================\n" +
                            "\n" +
                            "\t  1- Print Teachers List\t\n" +
                            "\t 2- Finding a Teacher by Surname\n" +
                            "\t 3- Finding a Teacher from a Branch\n" +
                            "\t 4- Adding a Teacher by Entering Their Information\n" +
                            "\t 5- Deleting Registration with ID Number \t\n" +
                            "\t A- MAİN MENU\n" +
                            "\t Q- EXIT\n");
            vote = scan.nextLine();

            switch (vote) {

                case "1":
                    printTeacherList();
                    break;
                case "2":
                    findTeacherBysurname();
                    break;
                case "3":
                    branchTeacherFinding();
                    break;
                case "4":
                    addTeacher();
                    break;
                case "5":
                    deleteWithTcId();
                    break;
                case "a":
                case "A":
                    Helper.mainMenu();
                    break;
                case "q":
                case "Q":
                    break;
                default:
                    System.out.println("Please make valid choices:");
            }

        } while (!vote.equalsIgnoreCase("q"));
        Helper.exitProject();
    }

    public static void deleteWithTcId() throws InterruptedException {
        System.out.println("Enter the teacher ID number to be deleted.");
        String deletingTeacher = scan.nextLine();

        String deletedValue = teachersMap.get(deletingTeacher);
        String resultValue = teachersMap.remove(deletingTeacher);

        System.out.print(deletingTeacher + " Deleting...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        try {
            boolean result = resultValue.equals(deletedValue);
        } catch (Exception e) {
            System.out.println("No teacher could be found with the TR ID number you requested.");
        }
    }

    public static void addTeacher() {
        System.out.println("TC ID");
        String tcID = scan.nextLine();
        System.out.println("name");
        String name = scan.nextLine();
        System.out.println("surname");
        String surname = scan.nextLine();
        System.out.println("Year");
        String year = scan.nextLine();
        System.out.println("Branch");
        String branch = scan.nextLine();

        String addValue = name + ", " + surname + ", " + year + ", " + branch;
        teachersMap.put(tcID, addValue);
    }

    public static void branchTeacherFinding() throws InterruptedException {
        System.out.println("Enter the Branch of the Teacher You Are Looking for:");
        String desiredBranch = scan.nextLine();

        System.out.print(desiredBranch + " Listing Teachers...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        Set<Map.Entry<String, String>> teacherEntrySet = teachersMap.entrySet();
        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "============Branch Teacher Finding ============\n" +
                        "TC ID : Name , Surname , Year , Branc");


        for (Map.Entry<String, String> each : teacherEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] eachValuarr = eachValue.split(", ");
            if (desiredBranch.equalsIgnoreCase(eachValuarr[3])) {
                System.out.println(eachKey + " : " + eachValue + " | ");
            }
        }
    }

    public static void findTeacherBysurname() throws InterruptedException {
        System.out.println("Enter the surname of the Teacher you are looking for:");
        String desiredSurname = scan.nextLine();

        Set<Map.Entry<String, String>> teacherEntrySet = teachersMap.entrySet();

        System.out.print(desiredSurname + " Searching...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "=========== FİND THE TEACHER BY SURNAME ==========\n" +
                        "TR ID : NAME , SURNAME , YEAR , BRANCH");


        for (Map.Entry<String, String> each : teacherEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] eachValuarr = eachValue.split(", ");
            if (desiredSurname.equalsIgnoreCase(eachValuarr[1])) {
                System.out.println(eachKey + " : " + eachValue + " | ");
            }
        }
    }

    public static void printTeacherList() throws InterruptedException {

        Set<Map.Entry<String, String>> teacherEntrySet = teachersMap.entrySet();

        System.out.print("Teacher List is printing...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "=============== TEACHER LIST ================\n" +
                        "TcNo : Name , Surname , Year , Branch");


        for (Map.Entry<String, String> each : teacherEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            System.out.println(eachKey + " : " + eachValue + " | ");
        }
    }


}

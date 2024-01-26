package src;

import java.util.Scanner;

public class Helper {
    static Scanner scan = new Scanner(System.in);

    public static void mainMenu() throws InterruptedException {

        String vote="";
        do{
        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "=================== MAİN MENU ====================\n" +
                        "\n" +
                        "\t 1- View School Information\n" +
                        "\t 2- Teacher Menu\n" +
                        "\t 3- Student Menu\t\t \n" +
                        "\t Q- EXIT\n");
        System.out.print("Please make your choice from the menu:");

        vote=scan.nextLine().toLowerCase();

        switch (vote){
            case "1" :
                Helper.printSchoolInformation();
                break;
            case "2" :
                Teacher.teacherMenu();
               break;
            case "3" :
                Student.studentMenu();
               break;
            case "q" :
                break;
            default  :
                System.out.print("Please enter a valid preference:");
        }


        }while(!vote.equalsIgnoreCase("q"));


        Helper.exitProject();
    }

    public static void printSchoolInformation() throws InterruptedException {

        System.out.print("School information is being printed...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        System.out.println("\n" +
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "\t\t School : " + School.schoolName +
                "\n\t\t Address : " + School.address +
                "\n\t\t Phone : " + School.phone);

    }

    public static void exitProject() {
        System.out.println("You quit your school project");
        System.exit(0);
    }
}

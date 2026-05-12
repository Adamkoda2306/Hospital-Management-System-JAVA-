package com.adamkoda.hospitalmanagement;

import java.util.Scanner;
import com.adamkoda.hospitalmanagement.Utils.GeneralUtils;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainMenu menu = new MainMenu(scanner);

        System.out.println("WELCOME TO HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("**********************************************************");
        System.out.println("MAIN MENU: ");
        System.out.println("1. Patient's DashBoard");
        System.out.println("2. Doctor's Dashboard");
        System.out.println("3. Appointment Dashboard");
        System.out.println("4. Exit the Program");
        System.out.println("**********************************************************");
        System.out.print("\nEnter Dashboard No: ");
        int menuSelection = scanner.nextInt();
        while (true) {
            switch (menuSelection) {
                case 1: {
                    GeneralUtils.clearConsole();
                    menu.PatientDashBoard();
                    menuSelection = 999;
                    break;
                }
                case 2: {
                    GeneralUtils.clearConsole();
                    menu.DoctorDashboard();
                    menuSelection = 999;
                    break;
                } 
                case 3: {
                    GeneralUtils.clearConsole();
                    menu.AppointmentDashboard();
                    menuSelection = 999;
                    break;
                }
                case 4: {
                    return;
                }
                case 999: {
                    GeneralUtils.clearConsole();
                    System.out.println("**********************************************************");
                    System.out.println("MAIN MENU: ");
                    System.out.println("1. Patient's DashBoard");
                    System.out.println("2. Doctor's Dashboard");
                    System.out.println("3. Appointment Dashboard");
                    System.out.println("4. Exit the Program");
                    System.out.println("**********************************************************");
                    System.out.print("\nEnter Dashboard No: ");
                    menuSelection = scanner.nextInt();
                    break;
                }
                default: {
                    GeneralUtils.clearConsole();
                    System.out.println("ERROR: Entered Wrong Dashboard!!!\n\n");
                    System.out.println("**********************************************************");
                    System.out.println("MAIN MENU: ");
                    System.out.println("1. Patient's DashBoard");
                    System.out.println("2. Doctor's Dashboard");
                    System.out.println("3. Appointment Dashboard");
                    System.out.println("4. Exit the Program");
                    System.out.println("**********************************************************");
                    System.out.print("\nEnter Dashboard No Again: ");
                    menuSelection = scanner.nextInt();
                }
            }
        }
    }
}

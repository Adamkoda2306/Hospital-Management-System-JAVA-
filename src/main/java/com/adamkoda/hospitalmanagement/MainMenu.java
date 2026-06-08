package com.adamkoda.hospitalmanagement;

import java.util.Scanner;

import com.adamkoda.hospitalmanagement.Services.Appointments;
import com.adamkoda.hospitalmanagement.Services.Doctors;
import com.adamkoda.hospitalmanagement.Services.Patients;
import com.adamkoda.hospitalmanagement.Utils.GeneralUtils;

public class MainMenu {
    private Scanner scanner;

    public MainMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void PatientDashBoard() {
        Patients patients = new Patients(scanner);
        System.out.println("**********************************************************");
        System.out.println("PATIENT'S  DASHBOARD : ");
        System.out.println("1. Add Patient");
        System.out.println("2. Check the Patient");
        System.out.println("3. List the Patients");
        System.out.println("4. Back to MainMenu");
        System.out.println("**********************************************************");
        System.out.print("\nEnter Operation No: ");
        int operationSelection = scanner.nextInt();
        while (true) {
            switch (operationSelection) {
                case 1: {
                    GeneralUtils.clearConsole();
                    patients.addPatients();
                    operationSelection = 999;
                    break;
                }
                case 2: {
                    GeneralUtils.clearConsole();
                    patients.checkPatient();
                    operationSelection = 999;
                    break;
                }
                case 3: {
                    GeneralUtils.clearConsole();
                    patients.listPatients();
                    operationSelection = 999;
                    break;
                }
                case 4: {
                    GeneralUtils.clearConsole();
                    return;
                }
                case 999: {
                    GeneralUtils.clearConsole();
                    System.out.println("**********************************************************");
                    System.out.println("PATIENT'S  DASHBOARD : ");
                    System.out.println("1. Add Patient");
                    System.out.println("2. Check the Patient");
                    System.out.println("3. List the Patients");
                    System.out.println("4. Back to MainMenu");
                    System.out.println("**********************************************************");
                    System.out.print("\nEnter Operation No: ");
                    operationSelection = scanner.nextInt();
                    break;
                }
                default: {
                    GeneralUtils.clearConsole();
                    System.out.println("ERROR: Entered Wrong Operation!!!\n\n");
                    System.out.println("**********************************************************");
                    System.out.println("PATIENT'S  DASHBOARD : ");
                    System.out.println("1. Add Patient");
                    System.out.println("2. Check the Patient");
                    System.out.println("3. List the Patients");
                    System.out.println("4. Back to MainMenu");
                    System.out.println("**********************************************************");
                    System.out.print("\nEnter Operation No Again: ");
                    operationSelection = scanner.nextInt();
                }
            }
        }
    }

    public void DoctorDashboard() {
        Doctors doctors = new Doctors(scanner);
        System.out.println("**********************************************************");
        System.out.println("DOCTOR'S  DASHBOARD : ");
        System.out.println("1. Add Doctor");
        System.out.println("2. Check Doctor");
        System.out.println("3. Check Doctor Availability");
        System.out.println("4. List Doctor");
        System.out.println("5. Back to MainMenu");
        System.out.println("**********************************************************");
        System.out.print("\nEnter Operation No: ");
        int operationSelection = scanner.nextInt();
        while (true) {
            switch (operationSelection) {
                case 1: {
                    GeneralUtils.clearConsole();
                    doctors.addDoctor();
                    operationSelection = 999;
                    break;
                }
                case 2: {
                    GeneralUtils.clearConsole();
                    doctors.checkDoctor();
                    operationSelection = 999;
                    break;
                }
                case 3: {
                    GeneralUtils.clearConsole();
                    doctors.checkDoctorAvailability();
                    operationSelection = 999;
                    break;
                }
                case 4: {
                    GeneralUtils.clearConsole();
                    doctors.listDoctors();
                    operationSelection = 999;
                    break;
                }
                case 5: {
                    GeneralUtils.clearConsole();
                    return;
                }
                case 999: {
                    GeneralUtils.clearConsole();
                    System.out.println("**********************************************************");
                    System.out.println("DOCTOR'S  DASHBOARD : ");
                    System.out.println("1. Add Doctor");
                    System.out.println("2. Check Doctor");
                    System.out.println("3. Check Doctor Availability");
                    System.out.println("4. List Doctor");
                    System.out.println("5. Back to MainMenu");
                    System.out.println("**********************************************************");
                    System.out.print("\nEnter Operation No: ");
                    operationSelection = scanner.nextInt();
                    break;
                }
                default: {
                    GeneralUtils.clearConsole();
                    System.out.println("ERROR: Entered Wrong Operation!!!\n\n");
                    System.out.println("**********************************************************");
                    System.out.println("DOCTOR'S  DASHBOARD : ");
                    System.out.println("1. Add Doctor");
                    System.out.println("2. Check Doctor");
                    System.out.println("3. Check Doctor Availability");
                    System.out.println("4. List Doctor");
                    System.out.println("5. Back to MainMenu");
                    System.out.println("**********************************************************");
                    System.out.print("\nEnter Operation No Again: ");
                    operationSelection = scanner.nextInt();
                }
            }
        }
    }

    public void AppointmentDashboard() {
        Appointments appointment = new Appointments(scanner);
        System.out.println("**********************************************************");
        System.out.println("APPOINTMENT'S  DASHBOARD : ");
        System.out.println("1. Add Appointment");
        System.out.println("2. Check Appointment");
        System.out.println("3. Change Appointment Date");
        System.out.println("4. List Appointment");
        System.out.println("5. Complete Appointment");
        System.out.println("6. Back to MainMenu");
        System.out.println("**********************************************************");
        System.out.print("\nEnter Operation No: ");
        int operationSelection = scanner.nextInt();
        while (true) {
            switch (operationSelection) {
                case 1: {
                    GeneralUtils.clearConsole();
                    appointment.addAppointment();
                    operationSelection = 999;
                    break;
                }
                case 2: {
                    GeneralUtils.clearConsole();
                    appointment.checkAppointment();
                    operationSelection = 999;
                    break;
                }
                case 3: {
                    GeneralUtils.clearConsole();
                    appointment.postpondAppointment();
                    operationSelection = 999;
                    break;
                }
                case 4: {
                    GeneralUtils.clearConsole();
                    appointment.listAppointments();
                    operationSelection = 999;
                    break;
                }
                case 5: {
                    GeneralUtils.clearConsole();
                    appointment.completeAppointment();
                    operationSelection = 999;
                    break;
                }
                case 6: {
                    GeneralUtils.clearConsole();
                    return;
                }
                case 999: {
                    GeneralUtils.clearConsole();
                    System.out.println("**********************************************************");
                    System.out.println("APPOINTMENT'S  DASHBOARD : ");
                    System.out.println("1. Add Appointment");
                    System.out.println("2. Check Appointment");
                    System.out.println("3. Change Appointment Date");
                    System.out.println("4. List Appointment");
                    System.out.println("5. Complete Appointment");
                    System.out.println("6. Back to MainMenu");
                    System.out.println("**********************************************************");
                    System.out.print("\nEnter Operation No: ");
                    operationSelection = scanner.nextInt();
                    break;
                }
                default: {
                    GeneralUtils.clearConsole();
                    System.out.println("ERROR: Entered Wrong Operation!!!\n\n");
                    System.out.println("**********************************************************");
                    System.out.println("APPOINTMENT'S  DASHBOARD : ");
                    System.out.println("1. Add Appointment");
                    System.out.println("2. Check Appointment");
                    System.out.println("3. Change Appointment Date");
                    System.out.println("4. List Appointment");
                    System.out.println("5. Complete Appointment");
                    System.out.println("6. Back to MainMenu");
                    System.out.println("**********************************************************");
                    System.out.print("\nEnter Operation No Again: ");
                    operationSelection = scanner.nextInt();
                }
            }
        }
    }
}

package com.adamkoda.hospitalmanagement.Services;

import java.util.List;
import java.util.Scanner;

import com.adamkoda.hospitalmanagement.DatabaseOperations.DoctorDAO;
import com.adamkoda.hospitalmanagement.Models.DoctorModel;
import com.adamkoda.hospitalmanagement.Utils.GeneralUtils;

public class Doctors {
   private Scanner scanner;
   private DoctorDAO databaseOperations;

   public Doctors(Scanner scanner) {
    this.scanner = scanner;
    databaseOperations = new DoctorDAO();
   }    

   private void displayDoctorDetails(DoctorModel data, boolean multiple) {
    System.out.println("*****************************************************");
    System.out.println("Doctor's Id: " + data.getId());
    System.out.println("Doctor's Name: " + data.getName());
    System.out.println("Speciality: " + data.getSpeciality());
    System.out.println("                                                      ----------------------------");
    System.out.println("                                                      |   "+ (data.getIsAvailable() ? "    Available" : "Not Available") + "  |");
    System.out.println("                                                      ----------------------------");
    System.out.println("----------------------------");
    System.out.println("|   "+ (data.getIsResgined() ? "    Resigned" : "Not Resigned") + "  |");
    System.out.println("----------------------------");
    if (!multiple) {
        System.out.println("Patient's List: ");
        for (String patient: (data.getPatientsList()).keySet()) {
            System.out.println("Patient Id: " + patient);
            System.out.println("Patient's Name: " + (data.getPatientsList()).get(patient)+"\n");
        }
        GeneralUtils.pause();
    }
   }

   private void displayDoctorAvailability(DoctorModel data) {
    System.out.println("*****************************************************");
    System.out.println("Doctor's Id: " + data.getId());
    System.out.println("Doctor's Name: " + data.getName());
    System.out.println("Speciality: " + data.getSpeciality());
    System.out.println("                                                      ----------------------------");
    System.out.println("                                                      |   "+ (data.getIsAvailable() ? "    Available" : "Not Available") + "  |");
    System.out.println("                                                      ----------------------------");
    GeneralUtils.pause();
   }

   public void addDoctor() {
    System.out.println("ADDING NEW DOCTOR");
    System.out.println("*****************************************************\n");
    System.out.print("Enter Doctor's Name: ");
    String name = scanner.next();
    System.out.print("Enter Doctor's Speciality: ");
    String speciality = scanner.next();
    DoctorModel data = new DoctorModel(name, speciality);
    databaseOperations.addDoctor(data);
    GeneralUtils.clearConsole();
    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
    System.out.println("|           Successfully Added the Doctor!!            |");
    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
    GeneralUtils.pause();
   }

   public void checkDoctor() {
    System.out.print("Enter the Doctor's Id: ");
    String id = scanner.next();
    GeneralUtils.clearConsole();
    DoctorModel doctorData = databaseOperations.getDoctorDetails(id);
    displayDoctorDetails(doctorData, false);
   }

   public void checkDoctorAvailability() {
    System.out.print("Enter the Doctor's Id: ");
    String id = scanner.next();
    GeneralUtils.clearConsole();
    DoctorModel doctorData = databaseOperations.getDoctorDetails(id);
    displayDoctorAvailability(doctorData);
   }

   public void listDoctors() {
    GeneralUtils.clearConsole();
    List<DoctorModel> Data = databaseOperations.getAllDoctorDetails();
    System.out.println("=====================================================");
    System.out.println("Doctor's List : ");
    System.out.println("=====================================================");
    for (DoctorModel data: Data) {
        displayDoctorDetails(data, true);
    }
    GeneralUtils.pause();
   }
}

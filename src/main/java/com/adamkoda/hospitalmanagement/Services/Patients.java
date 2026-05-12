package com.adamkoda.hospitalmanagement.Services;

import java.util.List;
import java.util.Scanner;

import com.adamkoda.hospitalmanagement.DatabaseOperations.PatientsDAO;
import com.adamkoda.hospitalmanagement.Models.PatientModel;
import com.adamkoda.hospitalmanagement.Utils.GeneralUtils;

public class Patients {
   private Scanner scanner;
   private PatientsDAO databaseOperations;

   public Patients(Scanner scanner) {
    this.scanner = scanner;
    databaseOperations = new PatientsDAO();
   }

   private void displayPatientDetails(PatientModel data, boolean multiple) {
    System.out.println("*****************************************************");
    System.out.println("Patient's Id: " + data.getId());
    System.out.println("Patient's Name: " + data.getName());
    if (!multiple) {
        System.out.println("Previous Checkups: ");
        for (String date : data.getPreviousCheckups()) {
            System.out.println(date);
        }
        GeneralUtils.pause();
    }
   }

   public void addPatients() {
    System.out.println("ADDING NEW PATIENT");
    System.out.println("*****************************************************\n");
    scanner.nextLine();
    System.out.print("Enter Patient's Name: ");
    String name = scanner.nextLine();
    System.out.print("Enter Doctor's Id: ");
    String docId = scanner.nextLine();
    PatientModel data = new PatientModel(name, docId);
    databaseOperations.addPatient(data);
    GeneralUtils.clearConsole();
    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
    System.out.println("|           Successfully Added the Patient!!           |");
    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
    GeneralUtils.pause();
   }

   public void checkPatient() {
    System.out.print("Enter the Patient's Id: ");
    String id = scanner.next();
    GeneralUtils.clearConsole();
    PatientModel patientData = databaseOperations.getPatientDetails(id);
    displayPatientDetails(patientData, false);
   }

   public void listPatients() {
    GeneralUtils.clearConsole();
    List<PatientModel> patientData = databaseOperations.getAllPatientDetails();
    System.out.println("=====================================================");
    System.out.println("Patient's List : ");
    System.out.println("=====================================================");
    for (PatientModel data: patientData) {
        displayPatientDetails(data, true);
    }
    GeneralUtils.pause();
   }
}

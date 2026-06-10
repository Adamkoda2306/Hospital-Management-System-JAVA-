package com.adamkoda.hospitalmanagement.Services;
import com.adamkoda.hospitalmanagement.DatabaseOperations.AppointmentsDAO;
import com.adamkoda.hospitalmanagement.DatabaseOperations.DoctorDAO;
import com.adamkoda.hospitalmanagement.DatabaseOperations.PatientsDAO;
import com.adamkoda.hospitalmanagement.Models.AppointmentModel;
import com.adamkoda.hospitalmanagement.Models.DoctorModel;
import com.adamkoda.hospitalmanagement.Models.PatientModel;
import com.adamkoda.hospitalmanagement.Utils.GeneralUtils;

import java.util.List;
import java.util.Scanner;

public class Appointments {
   private Scanner scanner;
   private AppointmentsDAO databaseOperations;
   private DoctorDAO doctor;
   private PatientsDAO patient;

   public Appointments(Scanner scanner) {
    this.scanner = scanner;
    databaseOperations = new AppointmentsDAO();
    doctor = new DoctorDAO();
    patient =  new PatientsDAO();
   }

   private void displayAppointmentDetails(AppointmentModel data) {
    DoctorModel doctorData = doctor.getDoctorDetails(data.getDoctorId());
    PatientModel patientData = patient.getPatientDetails(data.getPatientId());
    System.out.println("*****************************************************");
    System.out.println("Appointment's Id: " + data.getId());
    System.out.println("Doctor's Name: " + doctorData.getName());
    System.out.println("Patient's Name: " + patientData.getName());
    System.out.println("Appointment Date: " + data.getAppointmentDate());
    String availability = doctorData.getIsAvailable() ? "  Available  " : "Not Available";
    String consulted = data.getIsConsulted() ? "  Done  " : "Not Done";
    System.out.println("-----------------     ------------");
    System.out.println("| " + availability + " |     | " + consulted + " |");
    System.out.println("-----------------     ------------");
   }

   public void addAppointment() {
    System.out.println("ADDING NEW APPOINMENT");
    System.out.println("*****************************************************\n");
    scanner.nextLine();
    System.out.print("Enter Doctor's Id: ");
    String doctorId = scanner.nextLine();
    System.out.print("Enter Patient's Id: ");
    String patientId = scanner.nextLine();
    System.out.print("Enter Appointment Date: ");
    String date = scanner.nextLine();
    AppointmentModel data = new AppointmentModel(patientId, doctorId, date);
    databaseOperations.addAppointment(data);
    GeneralUtils.clearConsole();
    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
    System.out.println("|        Successfully Added the Appointment!!         |");
    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
    GeneralUtils.pause();
   }

   public void checkAppointment() {
    System.out.print("Enter the Appointment's Id: ");
    String id = scanner.next();
    GeneralUtils.clearConsole();
    AppointmentModel data = databaseOperations.getAppointmentDetails(id);
    displayAppointmentDetails(data);
    GeneralUtils.pause();
   }

   public void listAppointments() {
    GeneralUtils.clearConsole();
    List<AppointmentModel> Data = databaseOperations.getAllAppointmentDetails();
    System.out.println("=====================================================");
    System.out.println("Appointment's List : ");
    System.out.println("=====================================================");
    for (AppointmentModel data: Data) {
        displayAppointmentDetails(data);
    }
    GeneralUtils.pause();
   }

   public void completeAppointment() {
    System.out.print("Enter the Appointment's Id: ");
    String id = scanner.next();
    GeneralUtils.clearConsole();
    AppointmentModel data = databaseOperations.getAppointmentDetails(id);
    data.setIsConsulted();
    databaseOperations.updateAppointment(data);
    displayAppointmentDetails(data);
    GeneralUtils.pause();
   }

   public void postpondAppointment() {
    System.out.print("Enter the Appointment's Id: ");
    String id = scanner.next();
    System.out.print("Enter the changed Appointment's Date: ");
    String date = scanner.next();
    GeneralUtils.clearConsole();
    AppointmentModel data = databaseOperations.getAppointmentDetails(id);
    data.setAppointmentDate(date);
    databaseOperations.updateAppointment(data);
    displayAppointmentDetails(data);
    GeneralUtils.pause();
   }

}

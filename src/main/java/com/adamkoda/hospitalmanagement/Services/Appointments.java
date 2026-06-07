package com.adamkoda.hospitalmanagement.Services;

import java.util.Scanner;

import com.adamkoda.hospitalmanagement.DatabaseOperations.AppointmentsDAO;
import com.adamkoda.hospitalmanagement.DatabaseOperations.DoctorDAO;
import com.adamkoda.hospitalmanagement.DatabaseOperations.PatientsDAO;
import com.adamkoda.hospitalmanagement.Models.AppointmentModel;
import com.adamkoda.hospitalmanagement.Models.DoctorModel;
import com.adamkoda.hospitalmanagement.Models.PatientModel;
import com.adamkoda.hospitalmanagement.Utils.GeneralUtils;

public class Appointments {
    /*
        1) Book Appointments
        2) check Appointments
        3) Update Appointments
    */
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

   private void displayAppointmentDetails(AppointmentModel data, boolean multiple) {
    DoctorModel doctorData = doctor.getDoctorDetails(data.getDoctorId());
    PatientModel patientData = patient.getPatientDetails(data.getPatientId());
    System.out.println("*****************************************************");
    System.out.println("Appointment's Id: " + data.getId());
    System.out.println("Doctor's Name: " + doctorData.getName());
    System.out.println("Patient's Name: " + patientData.getName());
    System.out.println("Appointment Date: " + data.getAppointmentDate());
    String availability = doctorData.getIsAvailable() ? "  Available  " : "Not Available";
    String consulted = data.getIsConsulted() ? "  DONE  " : "NOT DONE";
    System.out.println("-----------------     ------------------");
    System.out.println("| " + availability + " |     | " + consulted + " |");
    System.out.println("-----------------     ------------------");
    GeneralUtils.pause();
   }

}

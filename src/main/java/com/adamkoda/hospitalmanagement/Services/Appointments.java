package com.adamkoda.hospitalmanagement.Services;

import java.util.Scanner;

import com.adamkoda.hospitalmanagement.DatabaseOperations.AppointmentsDAO;

public class Appointments {
    /*
        1) Book Appointments
        2) check Appointments
        3) Update Appointments
    */
   private Scanner scanner;
   private AppointmentsDAO databaseOperations;

   public Appointments(Scanner scanner) {
    this.scanner = scanner;
    databaseOperations = new AppointmentsDAO();
   }
}

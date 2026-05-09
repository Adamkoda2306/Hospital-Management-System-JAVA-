package com.adamkoda.hospitalmanagement.Models;

import com.adamkoda.hospitalmanagement.Utils.DatabaseUtils;
import java.util.HashMap;

public class DoctorModel {
    private String id;
    private String name;
    private String speciality;
    private Boolean isAvailable;
    private HashMap<String, String> patientsList;
    private Boolean isResigned;

    public DoctorModel (String Name, String Speciality) {
        this.id = DatabaseUtils.generateId("DOC");
        this.name = Name;
        this.speciality = Speciality;
        this.isAvailable = true;
        this.isResigned = false;
        this.patientsList = new HashMap<>();
    }

    public DoctorModel (String id, String Name, String Speciality, Boolean isAvailable, Boolean isResigned, HashMap<String, String> patientsList) {
        this.id = id;
        this.name = Name;
        this.speciality = Speciality;
        this.isAvailable = isAvailable;
        this.isResigned = isResigned;
        this.patientsList = patientsList;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public Boolean getIsResgined() {
        return isResigned;
    }

    public HashMap<String, String> getPatientsList() {
        return patientsList;
    }

    // Setters
    public void setName(String Name) {
        this.name = Name;
    }

    public void setSpeciality(String Speciality) {
        this.speciality = Speciality;
    }

    public void setIsAvailable(Boolean available) {
        this.isAvailable = available;
    }

    public void setIsResigned(Boolean resign) {
        this.isResigned = resign;
    }

    public void setPatients(String patientId, String patientName) {
        this.patientsList.put(patientId, patientName);
    }

}

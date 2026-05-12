package com.adamkoda.hospitalmanagement.Models;

import java.util.ArrayList;
import java.util.List;

import com.adamkoda.hospitalmanagement.Utils.DatabaseUtils;

public class PatientModel {
    private String id;
    private String name;
    private String doctorId;
    private List<String> previousCheckups;

    public PatientModel(String name, String doctorId) {
        this.id = DatabaseUtils.generateId("PAT");
        this.name = name;
        this.doctorId = doctorId;
        this.previousCheckups = new ArrayList<>();
    }

    public PatientModel(String id, String name, String doctorId, List<String> previousCheckups) {
        this.id = id;
        this.name = name;
        this.doctorId = doctorId;
        this.previousCheckups = previousCheckups;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public String getDoctorId() {
        return doctorId;
    }

    public List<String> getPreviousCheckups() {
        return previousCheckups;
    }

    // Setters
    public void setName(String Name) {
        this.name = Name;
    }

    public void setDoctorId(String Id) {
        this.doctorId = Id;
    }

    public void setPreviousCheckupDate(String previous) {
        this.previousCheckups.add(previous);
    }
}

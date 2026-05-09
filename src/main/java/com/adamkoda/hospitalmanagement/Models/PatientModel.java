package com.adamkoda.hospitalmanagement.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.adamkoda.hospitalmanagement.Utils.DatabaseUtils;

public class PatientModel {
    private String id;
    private String name;
    private String doctorId;
    private List<Date> previousCheckups;

    public PatientModel(String name, String doctorId) {
        this.id = DatabaseUtils.generateId("PAT");
        this.name = name;
        this.doctorId = doctorId;
        this.previousCheckups = new ArrayList<>();
    }

    public PatientModel(String id, String name, String doctorId, List<Date> previousCheckups) {
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
    
    public String getdoctorId() {
        return doctorId;
    }

    public List<Date> getPreviousCheckups() {
        return previousCheckups;
    }

    // Setters
    public void setName(String Name) {
        this.name = Name;
    }

    public void setDoctorId(String Id) {
        this.doctorId = Id;
    }

    public void setPreviousCheckupDate(Date previous) {
        this.previousCheckups.add(previous);
    }
}

package com.adamkoda.hospitalmanagement.Models;

import com.adamkoda.hospitalmanagement.Utils.DatabaseUtils;
import java.util.Date;

public class AppointmentModel {
    private String id;
    private String patientId;
    private String doctorId;
    private Boolean isConsulted;
    private Date appointmentDate;


    public AppointmentModel(String patientId, String doctorId, Date appointmenDate) {
        this.id = DatabaseUtils.generateId("APT");
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.isConsulted = false;
        this.appointmentDate = appointmenDate;
    }

    public AppointmentModel(String id, String patientId, String doctorId, Boolean isConsulted, Date appointmenDate) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.isConsulted = isConsulted;
        this.appointmentDate = appointmenDate;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public Boolean getIsConsulted() {
        return isConsulted;
    }

    // Setters
    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setIsConsulted() {
        this.isConsulted = true;
    }
}
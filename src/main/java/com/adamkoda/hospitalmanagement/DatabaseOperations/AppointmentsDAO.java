package com.adamkoda.hospitalmanagement.DatabaseOperations;

import com.adamkoda.hospitalmanagement.Configurations.MongoConfig;
import com.adamkoda.hospitalmanagement.Models.AppointmentModel;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.*;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

public class AppointmentsDAO {
    MongoDatabase db = MongoConfig.getDatabase();
    MongoCollection<Document> collection =
            db.getCollection("appointment");

    public void addAppointment(AppointmentModel data) {

        Document doc = new Document("id", data.getId())
                .append("patientId", data.getPatientId())
                .append("doctorId", data.getDoctorId())
                .append("isConsulted", data.getIsConsulted())
                .append("appointmentDate", data.getAppointmentDate());

        collection.insertOne(doc);

        System.out.println("Inserted");
    }

    public void updateAppointment(AppointmentModel data) {
        collection.updateOne(
                eq("id", data.getId()),
                combine(
                        set("patientId", data.getPatientId()),
                        set("doctorId", data.getDoctorId()),
                        set("isConsulted", data.getIsConsulted()),
                        set("appointmentDate", data.getAppointmentDate())
                )
        );
    }

    public AppointmentModel getAppointmentDetails(String Id) {
        Document doc = collection.find(eq("id", Id)).first();
        if (doc == null) {
            return null;
        }
        AppointmentModel data = new AppointmentModel(doc.getString("id"), doc.getString("patientId"), doc.getString("doctorId"), doc.getBoolean("isConsulted"), doc.getString("appointmentDate"));
        return data;
    }

    public List<AppointmentModel> getAllAppointmentDetails() {
        List<AppointmentModel> appointments = new ArrayList<>();
        for (Document doc: collection.find(eq("isConsulted", false))) {
            AppointmentModel data = new AppointmentModel(doc.getString("id"), doc.getString("patientId"), doc.getString("doctorId"), doc.getBoolean("isConsulted"), doc.getString("appointmentDate"));
            appointments.add(data);
        }
        return appointments;
    }
}
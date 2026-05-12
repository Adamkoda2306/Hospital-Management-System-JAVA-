package com.adamkoda.hospitalmanagement.DatabaseOperations;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import com.adamkoda.hospitalmanagement.Configurations.MongoConfig;
import com.adamkoda.hospitalmanagement.Models.PatientModel;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.*;

public class PatientsDAO {
    MongoDatabase db = MongoConfig.getDatabase();
    MongoCollection<Document> collection = db.getCollection("patient");

    public void addPatient(PatientModel data) {
        Document doc = new Document("id", data.getId())
                 .append("name", data.getName())
                 .append("doctorId", data.getDoctorId())
                 .append("previousCheckups", data.getPreviousCheckups());
        collection.insertOne(doc);
        System.out.println("Patient Inserted");
    }

    public void updatePatient(PatientModel data) {
        collection.updateOne(
            eq("id", data.getId()),
            combine(
                set("name", data.getName()),
                set("doctorId", data.getDoctorId()),
                set("previousCheckups", data.getPreviousCheckups())
            )
        );
        System.out.println("Patient Updated");
    }

    public PatientModel getPatientDetails(String id) {
        Document doc = collection.find(eq("id", id)).first();
        if (doc == null) {
            return null;
        }
        List<String> previousCheckups = doc.getList("previousCheckups", String.class);
        PatientModel data = new PatientModel(doc.getString("id"), doc.getString("name"), doc.getString("doctorId"), previousCheckups);
        return data;
    }

    public List<PatientModel> getAllPatientDetails() {
        List<PatientModel> patients = new ArrayList<>();
        for (Document doc: collection.find()) {
            List<String> previousCheckups = doc.getList("previousCheckups", String.class);
            PatientModel data = new PatientModel(doc.getString("id"), doc.getString("name"), doc.getString("doctorId"), previousCheckups);
            patients.add(data);
        }
        return patients;
    }
}

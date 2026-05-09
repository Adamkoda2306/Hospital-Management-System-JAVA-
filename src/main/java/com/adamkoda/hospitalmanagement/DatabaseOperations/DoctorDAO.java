package com.adamkoda.hospitalmanagement.DatabaseOperations;

import org.bson.Document;

import com.adamkoda.hospitalmanagement.Configurations.MongoConfig;
import com.adamkoda.hospitalmanagement.Models.DoctorModel;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DoctorDAO {
    MongoDatabase db = MongoConfig.getDatabase();
    MongoCollection<Document> collection = db.getCollection("doctor");
    
    public void addDoctor(DoctorModel data) {
        Document doc = new Document("id", data.getId())
                 .append("name", data.getName())
                 .append("speciality", data.getSpeciality())
                 .append("isAvailable", data.getIsAvailable())
                 .append("isResigned", data.getIsResgined())
                 .append("patientsList", data.getPatientsList());
        collection.insertOne(doc);
        System.out.println("Doctor Inserted");
    }

    public void updateDoctor(DoctorModel data) {
        collection.updateOne(
            eq("id", data.getId()),
            combine(
                set("name", data.getName()),
                set("speciality", data.getSpeciality()),
                set("isAvailable", data.getIsAvailable()),
                set("isResigned", data.getIsResgined()),
                set("patientList", data.getPatientsList())
            )
        );
        System.out.println("Doctor Updated");
    }

    public DoctorModel getDoctorDetails(String id) {
        Document doc = collection.find(eq("id", id)).first();
        if (doc == null) {
            return null;
        }
        HashMap<String, String> patients = new HashMap<>();
        Document patientsDoc = (Document) doc.get("patientsList");
        if (patientsDoc != null) {
            for (String key: patientsDoc.keySet()) {
                patients.put(key, patientsDoc.getString(key));
            }
        }
        DoctorModel data = new DoctorModel(doc.getString("id"), doc.getString("name"), doc.getString("speciality"), doc.getBoolean("isAvailable"), doc.getBoolean("isResigned"), patients);
        return data;
    }

    public List<DoctorModel> getAllDoctorDetails() {
        List<DoctorModel> doctors = new ArrayList<>();
        for (Document doc: collection.find(eq("isResigned", false))) {
            DoctorModel data = getDoctorDetails(doc.getString("id"));
            doctors.add(data);
        }
        return doctors;
    }
}

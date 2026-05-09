package com.adamkoda.hospitalmanagement.Configurations;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConfig {

    private static final String URI = System.getenv("MONGO_URI");

    private static MongoClient mongoClient =
            MongoClients.create(URI);

    public static MongoDatabase getDatabase() {
        return mongoClient.getDatabase("hospitalManagementDB");
    }
}

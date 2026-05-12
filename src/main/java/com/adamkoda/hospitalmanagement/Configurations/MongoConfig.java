package com.adamkoda.hospitalmanagement.Configurations;

import java.util.concurrent.TimeUnit;

import org.bson.Document;

import com.mongodb.ConnectionString;
import com.mongodb.MongoException;
import com.mongodb.MongoTimeoutException;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import io.github.cdimascio.dotenv.Dotenv;

public class MongoConfig {

    private static final Dotenv dotenv = Dotenv.configure()
                    .ignoreIfMissing()
                    .load();

    private static final String URI = dotenv.get("MONGO_URI");

    private static MongoClient mongoClient;

    static {

        try {

            MongoClientSettings settings = MongoClientSettings.builder()
                            .applyConnectionString(new ConnectionString(URI))
                            // timeout settings
                            .applyToSocketSettings(builder ->
                                    builder.connectTimeout(10,TimeUnit.SECONDS))
                            .applyToClusterSettings(builder ->
                                    builder.serverSelectionTimeout(10,TimeUnit.SECONDS))
                            .build();
            mongoClient = MongoClients.create(settings);

            // TEST CONNECTION
            MongoDatabase db =
                    mongoClient.getDatabase("admin");
            db.runCommand(new Document("ping", 1));
            System.out.println("MongoDB Atlas Connected Successfully");
        } catch (MongoTimeoutException e) {
            System.out.println("ERROR: MongoDB connection timeout");
            System.out.println("Check internet / Atlas whitelist");
            e.printStackTrace();
            System.exit(1);
        } catch (MongoException e) {
            System.out.println("MongoDB Error: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static MongoDatabase getDatabase() {
        return mongoClient.getDatabase("hospitalManagementDB");
    }
}
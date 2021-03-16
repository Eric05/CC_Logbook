package dataBases.mongoDb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.io.File;

public class MongoConnector {

    public static MongoDatabase connect(String database) {
        MongoClient mongo = null;

        try {
            mongo = MongoClients.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mongo.getDatabase(database);
    }

    public static MongoDatabase connect(String database, String port) {
        MongoClient mongo = null;
        String conString = "mongodb://" + port;
            try {
            mongo = MongoClients.create(conString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mongo.getDatabase(database);
    }

}

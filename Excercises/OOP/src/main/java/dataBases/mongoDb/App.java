package dataBases.mongoDb;

import org.bson.Document;


public class App {
    public static void main(String[] args) {
        //"mongodb://localhost:27017"
        var database = MongoConnector.connect("MongoDb");
        var collection = database.getCollection("customers");
        System.out.println("con okay");
        var docs = collection.find();

        Document document = new Document();
        document.put("name", "Shubham");

        //document.put("company", "Baeldung");
        collection.insertOne(document);

        document.put("nr", "1234");
        collection.insertOne(document);
        try (var cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                var current = cursor.next();
                System.out.println(current);
            }
        }

    }


}

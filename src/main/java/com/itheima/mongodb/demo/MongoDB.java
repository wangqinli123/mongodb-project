package com.itheima.mongodb.demo;


import com.google.common.collect.Lists;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.List;

public class MongoDB {

    private static MongoCollection<Document> collection;

    /**
     *
     * @param databaseName
     * @param collectionName
     * @param hostName
     * @param port
     */
    public static void connect(String databaseName, String collectionName,String hostName, int port){

        MongoClient client = new MongoClient(hostName, port);
        MongoDatabase database = client.getDatabase(databaseName);
        collection = database.getCollection(collectionName);
    }

    /**
     * 插入一个文档
     * @param document
     */
    public static void insertOne(Document document){
        collection.insertOne(document);
    }

    /**
     * insert list
     * @param list
     */
    public static void insertAll(List<Document> list){
        collection.insertMany(list);
    }

    /**
     * find first
     * @return
     */
    public static Document findFirst(){
        Document first = collection.find().first();
        return first;
    }

    public static List<Document> findFilter(Bson filter){
        List<Document> results = Lists.newArrayList();
        FindIterable<Document> documents = collection.find().filter(filter);
        MongoCursor<Document> cursor = documents.iterator();
        while (cursor.hasNext()){
            results.add(cursor.next());
        }
        return results;
    }

    public static List<Document> findAll(){
        List<Document> results = Lists.newArrayList();
        FindIterable<Document> documents = collection.find();
        MongoCursor<Document> cursor = documents.iterator();
        while (cursor.hasNext()){
            results.add(cursor.next());
        }
        return results;
    }

    public static UpdateResult updateOne(Bson filter,Bson update){
        return collection.updateOne(filter, update);
    }

    public static UpdateResult updateMany(Bson filter,Bson update){
        return collection.updateMany(filter, update);
    }

    public static UpdateResult replaceOne(Bson filter,Document document){
        return collection.replaceOne(filter, document);
    }

    public static DeleteResult deleteOne(Bson filter){
        return collection.deleteOne(filter);
    }
}

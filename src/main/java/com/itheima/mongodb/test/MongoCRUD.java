package com.itheima.mongodb.test;

import com.mongodb.*;

public class MongoCRUD {

    public static void main(String[] args) {

        Mongo mongo = new Mongo("192.168.1.108", 27017);

        DB db = mongo.getDB("testdb");
        DBCollection collection = db.getCollection("member");

        BasicDBObject dbObject = new BasicDBObject();
        dbObject.put("name","tom");
        dbObject.put("age",18);
        dbObject.put("addr","hunan changsha");

        collection.insert(dbObject);
        DBCursor cursor = collection.find();

        for (DBObject object:cursor) {
            System.out.println(object);
        }
    }
}

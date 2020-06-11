package com.itheima.mongodb.morphia;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;

public class MorphiaTest {

    public static void main(String[] args) {

        final Morphia morphia = new Morphia();
        MongoClient mongoClient = new MongoClient("192.168.1.108",27017);
        Datastore db = morphia.createDatastore(mongoClient, "testdb");

        Member member = new Member();
        member.setName("tom");
        member.setAge(22);
        member.setAddr("gansu Baiyin");

        Key<Member> key = db.save(member);
        System.out.println(key.getId());

    }
}

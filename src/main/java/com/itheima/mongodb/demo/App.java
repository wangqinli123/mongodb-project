package com.itheima.mongodb.demo;

import com.google.common.collect.Lists;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *
 */
public class App {

    @Before
    public void before(){
        MongoDB.connect("testdb","test","10.185.3.41",27017);
    }

    @Ignore
    public void insertTest(){

        Document document = new Document();

        document.append("name","java");
        document.append("type","java");
        document.append("count",1);
        document.append("versions", Arrays.asList("v1.6", "v1.7", "v1.8"));
        document.append("info",new Document("X",400).append("Y",400));

        MongoDB.insertOne(document);
    }


    @Ignore
    public void insertAll(){

        Document document = new Document();
        document.append("name","python");
        document.append("type","python");
        document.append("count",10);
        document.append("versions", Arrays.asList("v1.6", "v1.7", "v1.8"));
        document.append("info",new Document("X",500).append("Y",600));


        Document document2 = new Document();
        document.append("name","go");
        document.append("type","go");
        document.append("count",11);
        document.append("versions", Arrays.asList("v1.6", "v1.7", "v1.8"));
        document.append("info",new Document("X",600).append("Y",700));

        Document document3 = new Document();
        document.append("name","web");
        document.append("type","web");
        document.append("count",10);
        document.append("versions", Arrays.asList("v1.6", "v1.7", "v1.8"));
        document.append("info",new Document("X",800).append("Y",800));

        ArrayList<Document> documents = Lists.newArrayList();

        documents.add(document);
        documents.add(document2);
        documents.add(document3);
        MongoDB.insertAll(documents);
    }


    @Ignore
    public void findFistTest(){
        Document document = MongoDB.findFirst();
        System.out.println(document);
    }

    @Ignore
    public void findFilterTest(){
        Bson bson = Filters.eq("name", "web");
        Bson bson2 = Filters.eq("name", "java");
        Bson bsons = Filters.or(bson, bson2);
        List<Document> documents = MongoDB.findFilter(bsons);
        System.out.println(documents);
    }

    @Ignore
    public void findAllTest(){
        List<Document> documents = MongoDB.findAll();
        System.out.println(documents);
    }

    @Ignore
    public void updateOne(){

        Document filter = new Document();
        filter.append("name", "web");

        //注意update文档里要包含"$set"字段
        Document update = new Document();
        update.append("$set", new Document("type", "js"));

        UpdateResult updateResult = MongoDB.updateOne(filter, update);
        System.out.println(updateResult);
    }

    @Ignore
    public void updateMany(){

        Bson filter = Filters.or(Filters.eq("name", "web"), Filters.eq("name", "java"));

        //注意update文档里要包含"$set"字段
        Document update = new Document();
        update.append("$set", new Document("type", "procedure"));

        UpdateResult updateResult = MongoDB.updateMany(filter, update);
        System.out.println(updateResult);

    }

    @Ignore
    public void replaceTest(){
        Bson filter = Filters.eq("name", "web");

        Document update = new Document();
        update.append("type","web");
        UpdateResult updateResult = MongoDB.replaceOne(filter, update);
        System.out.println(updateResult);
    }

    @Test
    public void deleteOneTest(){
        Bson filter = Filters.eq("type", "web");
        DeleteResult deleteResult = MongoDB.deleteOne(filter);
        System.out.println(deleteResult);
    }
}

package com.itheima.mongo.pojo;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "t_member")
public class Member implements Serializable {

    @Id
    private ObjectId id;
    private String nickname;
    private String username;
    private String password;
    private int sex;
    private int age;
    private String addr;

    public Member() {
    }

    public Member(String username, String password, int sex, int age, String addr) {
        this.nickname = username;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.addr = addr;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}

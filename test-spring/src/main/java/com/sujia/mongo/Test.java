package com.sujia.mongo;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        MongoDatabase mongo = MongoDBUtil.getConnect("sujia");

        GroupMsg groupMsg = new GroupMsg();
        groupMsg.setGroupId("333");
        groupMsg.setGroupName("test3");
        List<String> managers = new ArrayList<>();
        managers.add("5");
        groupMsg.setManagers(managers);
        List<String> members = new ArrayList<>();
        members.add("1");
        members.add("2");
        members.add("3");
        members.add("5");
        members.add("6");
        groupMsg.setMembersId(members);
        groupMsg.setStatus((short) 2);
        GroupService service = new GroupService();


//        service.createGroup(groupMsg);

        service.deleteGroup("test3");


    }
}

package com.sujia.mongo;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class GroupService {


    private MongoTemplate mongoTemplate = MongoDBUtil.getTemplate();

    //插入,创建一条记录
    public void createGroup(GroupMsg group){
        mongoTemplate.insert(group);
    }
    public void updateGroup(String groupName){
    }

    public void insertMember(String member){

    }

    public void insertMembers(String[] members){

    }

    public void insertManager(String memberId){

    }

    //删除
    public void deleteGroup(String groupName){
        Query query=new Query(Criteria.where("groupName").is(groupName));
        mongoTemplate.remove(query,GroupMsg.class,"group").getDeletedCount();
    }

    public void searchGroup(String groupName){

    }

    public void printAllGroup(){

    }

}

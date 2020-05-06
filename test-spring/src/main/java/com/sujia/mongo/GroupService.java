package com.sujia.mongo;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class GroupService {


    private MongoTemplate mongoTemplate = MongoDBUtil.getTemplate();

    //插入,创建一条记录
    public void createGroup(GroupMsg group){
        mongoTemplate.insert(group);
    }

    //添加新成员
    public void insertMember(String groupId,String member){
        Query query=new Query();
        query.addCriteria(Criteria.where("groupId").is(groupId));
        Update update = new Update();
        update.addToSet("membersId", member);
        mongoTemplate.upsert(query, update, GroupMsg.class);
    }

    //添加新成员
    public void insertMembers(String groupId,String[] members){
        Query query=new Query();
        query.addCriteria(Criteria.where("groupId").is(groupId));
        Update update = new Update();
        for(String s : members){
            update.addToSet("membersId", s);
            mongoTemplate.upsert(query, update, GroupMsg.class);
        }
    }

    //创建管理员
    public void insertManager(String groupId,String memberId){
        Query query=new Query();
        query.addCriteria(Criteria.where("groupId").is(groupId));
        Update update = new Update();
        update.addToSet("managers", memberId);
        mongoTemplate.upsert(query, update, GroupMsg.class);
    }
    //删除管理员
    public void delManager(String groupId,String memberId){
        Query query = Query.query(Criteria.where("groupId").is(groupId));
        Update update = new Update();
        update.pull("managers",memberId);
        mongoTemplate.updateFirst(query, update, GroupMsg.class);
    }

    //删除群组
    public void deleteGroup(String groupId){
        Query query=new Query(Criteria.where("groupId").is(groupId));
        mongoTemplate.remove(query,GroupMsg.class,"group").getDeletedCount();
    }

    //查询组
    public GroupMsg searchGroup(String groupId){
        Query query = new Query(Criteria.where("groupId").is(groupId));
        return mongoTemplate.findOne(query, GroupMsg.class);
    }

    //查询组
    public GroupMsg searchGroupByName(String groupName){
        Query query = new Query(Criteria.where("groupName").is(groupName));
        return mongoTemplate.findOne(query, GroupMsg.class);
    }

}

package com.sujia.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MongoDBUtil {

    private static MongoDBUtil mongoDBUtil = new MongoDBUtil();
    private static MongoClient client ;

    private MongoDBUtil(){
//        client = new MongoClient(
//                "localhost",27017);
    }

    public static synchronized MongoDatabase getConnect(String db){
        return client.getDatabase(db);
    }

    public static void close(){
        client.close();
    }

    public static MongoTemplate getTemplate(){
        String host ="47.93.225.242";
        int port = 27017;
        String username = "admin";
        String password = "admin";
        String defaultDataBaseName = "admin";

        //address
        ServerAddress address = new ServerAddress(host, port);

        //client
        MongoCredential mongoCredential = MongoCredential.createCredential(username, defaultDataBaseName, password.toCharArray());
        List<MongoCredential> mongoCredentials = new ArrayList<>();
        mongoCredentials.add(mongoCredential);
        client = new MongoClient(address,mongoCredentials);

        //factory
        SimpleMongoDbFactory factory = new SimpleMongoDbFactory(client, defaultDataBaseName);

        //template
        MongoTemplate template = new MongoTemplate(factory);

        return template;
    }


//    public static MongoDatabase getConnect2(String dbName){
//        List<ServerAddress> adds = new ArrayList<>();
//        //ServerAddress()两个参数分别为 服务器地址 和 端口
//        ServerAddress serverAddress = new ServerAddress("localhost", 27017);
//        adds.add(serverAddress);
//
//        List<MongoCredential> credentials = new ArrayList<>();
//        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
//        MongoCredential mongoCredential = MongoCredential.createScramSha1Credential("username", "databaseName", "password".toCharArray());
//        credentials.add(mongoCredential);
//
//        //通过连接认证获取MongoDB连接
//        MongoClient mongoClient = new MongoClient(adds, credentials);
//
//        //连接到数据库
//        MongoDatabase mongoDatabase = mongoClient.getDatabase(dbName);
//
//        //返回连接数据库对象
//        return mongoDatabase;
//    }

}

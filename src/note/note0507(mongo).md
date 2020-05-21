### MongoDB 
MongoDB is a general purpose, document-based, distributed database built for modern application developers and for the cloud era. No database makes you more productive.

在服务器安装后，./mongo db启动，首先创建用户
```
db.createUser(
  {
    user: "admin",
    pwd: "admin",
    roles: [ { role: "userAdminAnyDatabase", db: "admin"} ]
  }
)
```
#### 使用db的时候用身份验证
* use admin
* db.auth("admin","admin")
* show users
* 可以根据需要创建其他用户
* 可以看这里https://www.jianshu.com/p/62736bff7e2e
#### Mongo Shell操作数据库增删改查
* 首先，要先有一个集合db.createCollection(name, options)
* 插入 db.myCollection.insertOne( { x: 1 } );
* 查找集合
  1. db.getCollection("3 test").find()
  2. db.getCollection("3-test").find()
  3. db.getCollection("stats").find()

The mongo shell prompt has a limit of 4095 codepoints for each line. If you enter a line with more than 4095 codepoints, the shell will truncate it.

For more documentation of basic MongoDB operations in the mongo shell, see:

官方文档还是很明白的
#### Getting Started Guide
* https://docs.mongodb.com/manual/tutorial/getting-started/
* Insert
```
db.inventory.insertMany([
   { item: "journal", qty: 25, status: "A", size: { h: 14, w: 21, uom: "cm" }, tags: [ "blank", "red" ] },
   { item: "notebook", qty: 50, status: "A", size: { h: 8.5, w: 11, uom: "in" }, tags: [ "red", "blank" ] },
   { item: "paper", qty: 10, status: "D", size: { h: 8.5, w: 11, uom: "in" }, tags: [ "red", "blank", "plain" ] },
   { item: "planner", qty: 0, status: "D", size: { h: 22.85, w: 30, uom: "cm" }, tags: [ "blank", "red" ] },
   { item: "postcard", qty: 45, status: "A", size: { h: 10, w: 15.25, uom: "cm" }, tags: [ "blue" ] }
]);
// MongoDB adds an _id field with an ObjectId value if the field is not present in the document
```
* Select  **db.collection.find()**
```
To select the documents from a collection, 
you can use the db.collection.find() method. 
To select all documents in the collection, 
pass an empty document as the query filter document to the method.
也就是带上{} == select *
db.inventory.find({})

To format the results, append the .pretty() to the find operation:
db.inventory.find({}).pretty()
```
* Match 匹配查找
```
In the shell, copy and paste the following to return documents where status field equals "D":
db.inventory.find( { status: "D" } );

内嵌文档匹配查找：
In the shell, copy and paste the following to return document 
where the uom field, nested inside the size document, equals "in":
db.inventory.find( { "size.uom": "in" } )
```
* Specify 

To specify fields to return, pass a projection document to the db.collection.find(<query document>, <projection document>) method. In the projection document, specify:
```
db.inventory.find( { }, { item: 1, status: 1 } );
```

官网getting-started有一个web shell可以测
#### Insert Documents
* https://docs.mongodb.com/manual/tutorial/insert-documents/
#### Query Documents
* https://docs.mongodb.com/manual/tutorial/query-documents/
#### Update Documents
* https://docs.mongodb.com/manual/tutorial/update-documents/
* db.collection.updateOne(<filter>, <update>, <options>)
* db.collection.updateMany(<filter>, <update>, <options>)
* db.collection.replaceOne(<filter>, <update>, <options>)
#### Delete Documents
* https://docs.mongodb.com/manual/tutorial/remove-documents/
#### mongo Shell Methods
* https://docs.mongodb.com/manual/reference/method/

**Mongo的官方文档写的属实清晰，有点英语基础的就不要看博客了，乱**

###MongoTemplate

主要记一下在java中的应用

* 首先 添加依赖

        <!--mongoDB驱动-->
        <dependency>
            <groupId>org.mongodb</groupId>
            <artifactId>mongo-java-driver</artifactId>
            <version>3.5.0</version>
        </dependency>
        <!--Spring整合mongoDB-->
        <dependency>
            <groupId>org.springframework.data</groupId>
            <artifactId>spring-data-mongodb</artifactId>
            <version>2.1.0.RELEASE</version>
        </dependency>
* 连接
        
        //无权限本地连接
        MongoClient client = new MongoClient("localhost",27017); 
        
        //用户验证登录，返回MongoTemplate 这跟JDBCTemplate类似
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
                MongoClient client = new MongoClient(address,mongoCredentials);
                //factory
                SimpleMongoDbFactory factory = new SimpleMongoDbFactory(client, defaultDataBaseName);
                //template
                MongoTemplate template = new MongoTemplate(factory);
                return template;
            }
         如果想注入Spring，就去掉static在上面加入@Bean，其中，端口号，ip，用户名密码等可以配在配置文件中
         在dao层使用时
         private MongoTemplate mongoTemplate = MongoDBUtil.getTemplate();
         或  @Autowired
             private MongoTemplate mongoTemplate
             
         如果SpringBoot项目更容易了，只用配个配置文件。。。
         
* 对应Document
        
        在你想与Collection对应的实体类上加入@Document("对应的名字")
        在操作增删改查自动就整合了，这与mybatis对应实体类的方式类似
        
* CRUD 

            //插入,创建一条记录
            public void createGroup(GroupMsg group){
                mongoTemplate.insert(group);
            }
            
            //删除
            public void deleteGroup(String groupName){
                Query query=new Query(Criteria.where("groupName").is(groupName));
                mongoTemplate.remove(query,GroupMsg.class,"group").getDeletedCount();
            }
            
           
###总结
总的来说 redis/memcache 是基于内存的，讲究的是性能，多用作缓存层，比如说存放session。而 mongodb 是面向文档的，存储的是类似JSON的非结构化数据，查询起来非常方便，开发效率高，比较类似传统SQL关系型数据库。

**优势**
* 操作简便：mongodb支持丰富的数据表达，索引，最类似关系型数据库，支持的查询语言非常丰富
* 内存空间大小和数据量大小：mongoDB适合大数据量的存储，依赖操作系统VM做内存管理，吃内存也比较厉害，服务不要和别的服务在一起
* 可用性（单点问题）
    1. redis依赖客户端来实现分布式读写；主从复制时，每次从节点重新连接主节点都要依赖整个快照,无增量复制，因性能和效率问题，
    2. mongoDB支持master-slave,replicaset（内部采用paxos选举算法，自动故障恢复）,auto sharding机制，对客户端屏蔽了故障转移和切分机制。
* 可靠性(持久化)
    1. redis支持（快照、AOF）：依赖快照进行持久化，aof增强了可靠性的同时，对性能有所影响
    2. MongoDB从1.8版本开始采用binlog方式支持持久化的可靠性
* 数据一致性(事务支持)
    1. redis事务支持比较弱，只能保证事务中的每个操作连续执行
    2. mongoDB不支持事务
* 应用场景
    1. redis：数据量较小的更性能操作和运算上
    2. MongoDB:主要解决海量数据的访问效率问题
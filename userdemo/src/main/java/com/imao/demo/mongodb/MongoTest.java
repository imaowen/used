package com.imao.demo.mongodb;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class MongoTest {
	private static MongoDatabase mongoDatabase = null;
	
	public static void main(String[] args) {
		String dbName = "test";
		String collName = "user";
		
		getMongoClient(dbName);
		
		MongoCollection<Document> collection = getCollection(collName);
		 
//		insert(collection);
		 
		collIterable(collection);
		
		del(collection);
		System.out.println();
		collIterable(collection);
	}
	/**
	 * 连接数据库
	 * @param dbName
	 * @return
	 */
	public static void getMongoClient(String dbName){
		 // 连接到 mongodb 服务
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        // 连接到数据库
        mongoDatabase = mongoClient.getDatabase(dbName); 
        System.out.println("Connect to "+mongoDatabase.getName()+" successfully");
        
	}
	/**
	 * 获取集合
	 * @param collName
	 * @return
	 */
	public static MongoCollection<Document> getCollection(String collName){
		 MongoCollection<Document> collection = mongoDatabase.getCollection(collName);
		 System.out.println("集合user有"+collection.count()+"条数据");
		return collection;
	}
	/**
	 * 插入文档
	 * @param collection
	 */
	public static void insert(MongoCollection<Document> collection){
		Document doc = new Document();
		doc.put("name", 11);
		collection.insertOne(doc);
	}
	/**
	 * 检索所有文档
	 * @param collection
	 */
	public static void collIterable(MongoCollection<Document> collection){
		 /** 
         * 1. 获取迭代器FindIterable<Document> 
         * 2. 获取游标MongoCursor<Document> 
         * 3. 通过游标遍历检索出的文档集合 
         * */  
		FindIterable<Document> findIterable = collection.find();
		MongoCursor<Document> mongoCursor = findIterable.iterator();
		while(mongoCursor.hasNext()){
			Document doc = mongoCursor.next();
			System.out.println(doc);
		}
		mongoCursor.close();
	}
	/**
	 * 更新文档
	 * @param collection
	 */
	public static void update(MongoCollection<Document> collection){
		//局部更新
		UpdateResult result = collection.updateMany(Filters.eq("name", "ming"), new Document("$set",new Document("name",12))); 
		System.out.println("更新条数："+result.getModifiedCount());
	}
	/**
	 * 删除文档
	 * @param collection
	 */
	public static void del(MongoCollection<Document> collection){
		DeleteResult result = collection.deleteMany(Filters.eq("name",5));
		System.out.println("删除条数："+result.getDeletedCount());
	}
	
}

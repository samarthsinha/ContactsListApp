package com.springapp.helper;

import java.io.ObjectInputStream.GetField;
import java.util.List;

import org.bson.NewBSONDecoder;
import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.DBObject;
import com.springapp.config.SpringMongoConfig;
import com.springapp.firstapp.model.Contact;

public class MongoHelper {
	private static ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	private static MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	
	public static void save(Object o){
		mongoOperation.save(o);
	}
	public static <E> List<E> fetchAll(E modelClassObject){
		List<E> listObjects = (List<E>) mongoOperation.findAll(modelClassObject.getClass());
		return listObjects;
	}
	public static <E> void delete(String id,E e){
		mongoOperation.remove(e);
		//mongoOperation.remove(query.addCriteria(Criteria.where("firstname").is("asd")),e.getClass());
	}
	public static <E> E findById(String id,E e){
		E x = (E) mongoOperation.findById(id, e.getClass());
		return x;
	}
}

package com.adcuratio.scrapping.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.adcuratio.scrapping.config.MongoDbClientConfig;
import com.adcuratio.scrapping.entity.DataEntry;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDbService {

	public void DocumentInsertIfExist(DataEntry dataEntry) {
		System.out.println("Start: DocumentInsertIfExist()");

		MongoDbClientConfig mongoDbClientConfig1 = new MongoDbClientConfig();

		MongoDatabase database = mongoDbClientConfig1.getMongoCollection();

		MongoCollection<Document> collection1 = database.getCollection("Data(Relation1)");

		MongoCollection<Document> collection2 = database.getCollection("MetaData(Relation2)");

		System.out.println("Collection sampleCollection selected successfully");

		int i = 0;
		int n = 0;
		boolean update = false;
		for (String url : dataEntry.getUrlArrayList()) {
			BasicDBObject query = new BasicDBObject();
			query.put("url", url);
			MongoCursor<Document> cursor = collection1.find(query).iterator();
			if (!cursor.hasNext()) {
				Document document1 = new Document("url", url).append("title", dataEntry.getTitleArrayList().get(i));

				Document document2 = new Document("url", url).append("title", dataEntry.getTitleArrayList().get(i))
						.append("content_writer", dataEntry.getUserArrayList().get(i))
						.append("lastModified", dataEntry.getTimeArrayList().get(i))
						.append("points", dataEntry.getPointsArrayList().get(i));

				collection1.insertOne(document1);
				collection2.insertOne(document2);
				update = true;
				n++;
				System.out.println("Document with url sucessfully inserted:" + url);
			}
			i++;
		}
		viewCollectionData(collection1, collection2);

		if (!update) {
			System.out.println("\nNo new documents found to update");
		} else
			System.out.println("\nHurray !! "+n+" new Data entered into collections !!");

		System.out.println("End: DocumentInsertIfExist()");

	}

	private void viewCollectionData(MongoCollection<Document> collection1, MongoCollection<Document> collection2) {
		System.out.println("Collection Data(Relation1) & MetaData(Relation2)  sucessfully updated\n");

		List<Document> documents1 = (List<Document>) collection1.find().into(new ArrayList<Document>());
		List<Document> documents2 = (List<Document>) collection2.find().into(new ArrayList<Document>());

		System.out.println("\n\nAll Data(Relation1) collection Data with url,title:\n");
		for (Document document : documents1) {
			System.out.println(document);
		}
		System.out.println(
				"\n\nAll MetaData(Relation2) collection Data with url,title,content_writer,lastModified,points:\n");

		for (Document document : documents2) {
			System.out.println(document);
		}
	}
}

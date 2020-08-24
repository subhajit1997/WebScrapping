package com.adcuratio.scrapping.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoDbClientConfig {
	public MongoDatabase getMongoCollection() {
		String username = "subhajitbiswas";
		String publicPassword = "subhajitbiswas";
		String databaseName = "WebScrappingAssignment";

		MongoClientURI uri = new MongoClientURI("mongodb+srv://" + username + ":" + publicPassword
				+ "@cluster0.fryov.mongodb.net/" + databaseName + "?retryWrites=true&w=majority");

		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase(databaseName);
		return database;

	}
}

package com.adcuratio.scrapping.service;

import java.util.ArrayList;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.adcuratio.scrapping.config.WebScrappingConfig;
import com.adcuratio.scrapping.entity.DataEntry;

public class WebScrappingService {

	public void webScrapConverter() {

		WebScrappingConfig webScrapping = new WebScrappingConfig();
		DataEntry dataEntry = new DataEntry();
		MongoDbService mongoDbService = new MongoDbService();

		ArrayList<String> url = new ArrayList<>();
		ArrayList<String> title = new ArrayList<>();
		ArrayList<String> points = new ArrayList<>();
		ArrayList<String> time = new ArrayList<>();
		ArrayList<String> user = new ArrayList<>();

		Document doc = webScrapping.GetWebScrapeData();

		Elements subtextBody = doc.select("td.subtext");

		Elements body = doc.select("tr.athing");
		Elements titleBody = body.select("td.title");
		for (Element e : subtextBody) {
			points.add(e.select("span.score").text());
			time.add(e.select("span.age").text());
			user.add(e.select("a.hnuser").text());

		}

		for (Element e : titleBody.select("a.storylink")) {
			url.add(e.attr("href"));
			title.add(e.text());

		}

		// Enter data to test
		// url.add("test");
		// title.add("test");
		// points.add("test");
		// time.add("test");
		// user.add("test");

		dataEntry.setUrlArrayList(url);
		dataEntry.setTitleArrayList(title);
		dataEntry.setPointsArrayList(points);
		dataEntry.setTimeArrayList(time);
		dataEntry.setUserArrayList(user);

		mongoDbService.DocumentInsertIfExist(dataEntry);

	}

}

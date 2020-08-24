package com.adcuratio.scrapping.config;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebScrappingConfig {
	public Document GetWebScrapeData()
	{
		Document doc = null;
		try {
			doc = Jsoup.connect("https://news.ycombinator.com/").timeout(6000).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}
}

package com.adcuratio.scrapping.entity;

import java.util.ArrayList;

public class DataEntry {
	private ArrayList<String> urlArrayList = new ArrayList<>();
	private ArrayList<String> titleArrayList = new ArrayList<>();
	private ArrayList<String> pointsArrayList = new ArrayList<>();
	private ArrayList<String> timeArrayList = new ArrayList<>();
	private ArrayList<String> userArrayList = new ArrayList<>();

	public ArrayList<String> getUrlArrayList() {
		return urlArrayList;
	}

	public void setUrlArrayList(ArrayList<String> urlArrayList) {
		this.urlArrayList = urlArrayList;
	}

	public ArrayList<String> getTitleArrayList() {
		return titleArrayList;
	}

	public void setTitleArrayList(ArrayList<String> titleArrayList) {
		this.titleArrayList = titleArrayList;
	}

	public ArrayList<String> getPointsArrayList() {
		return pointsArrayList;
	}

	public void setPointsArrayList(ArrayList<String> pointsArrayList) {
		this.pointsArrayList = pointsArrayList;
	}

	public ArrayList<String> getTimeArrayList() {
		return timeArrayList;
	}

	public void setTimeArrayList(ArrayList<String> timeArrayList) {
		this.timeArrayList = timeArrayList;
	}

	public ArrayList<String> getUserArrayList() {
		return userArrayList;
	}

	public void setUserArrayList(ArrayList<String> userArrayList) {
		this.userArrayList = userArrayList;
	}

}

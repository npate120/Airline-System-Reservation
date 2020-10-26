package com.airlinereservation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigProperties {

	@Value("${placeName}")
	private String place;
	
	@Value("${url}")
	private String url;
	
	@Value("${x-rapidapi-host}")
	private String rapidApiHost;
	
	@Value("${x-rapidapi-key}")
	private String rapidApiKey;

	public String getRapidApiHost() {
		return rapidApiHost;
	}

	public void setRapidApiHost(String rapidApiHost) {
		this.rapidApiHost = rapidApiHost;
	}

	public String getRapidApiKey() {
		return rapidApiKey;
	}

	public void setRapidApiKey(String rapidApiKey) {
		this.rapidApiKey = rapidApiKey;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}

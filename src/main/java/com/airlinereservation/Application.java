package com.airlinereservation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@SpringBootApplication
@ComponentScan("com.airlinereservation.ConfigProperties")
public class Application {
	
	@Bean
	ConfigProperties myConfig() {
        return new ConfigProperties();
    }

	public static void main(String args[]) throws IOException, JSONException {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		ConfigProperties myConfig = ctx.getBean(ConfigProperties.class);
		 OkHttpClient client = new OkHttpClient();

		 Request request = new Request.Builder()
		 	.url(myConfig.getUrl())
		 	.get()
		 	.addHeader("x-rapidapi-host", myConfig.getRapidApiHost())
		 	.addHeader("x-rapidapi-key", myConfig.getRapidApiKey())
		 	.build();

		 Response response = client.newCall(request).execute();
		
		 response.isSuccessful();
		
		String jsonData = response.body().string();
	    JSONObject Jobject = new JSONObject(jsonData);
	    JSONArray Jarray = Jobject.getJSONArray("Places");
	    List<Place> placelist = new ArrayList<>();
	    for (int i = 0; i < Jarray.length(); i++) {
	        JSONObject object     = Jarray.getJSONObject(i);
	        Place place = new Place();
	        place.setPlaceId(object.getString("PlaceId"));
	        place.setPlaceName(object.getString("PlaceName"));
	        place.setCountryId(object.getString("CountryId"));
	        place.setRegionId(object.getString("RegionId"));
	        place.setCityId(object.getString("CityId"));
	        place.setCountryName(object.getString("CountryName"));
	        placelist.add(place);
	        System.out.println(place.toString());
	    }
	    Example example = new Example();
	    example.setPlaces(placelist);  
	    
	    
	 }
	 

}

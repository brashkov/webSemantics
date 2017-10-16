package org.borko.spring.edu.utils;

import java.io.IOException;
import java.net.URL;

import javax.ws.rs.HEAD;

import org.borko.spring.edu.NamesDB;
import org.borko.spring.edu.dao.PersonDAO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataBaseService {

	private static int FNameRow ;
	private static int LNameRow ;
	
	private static NamesDB dbStorage;
	
	@Autowired
	public DataBaseService (NamesDB storage){
		dbStorage = storage;
	}
	

	public static  void webScrap(String URL) {
		
	      try {
	         Document doc = Jsoup.connect(URL).get();
	         Elements tableElements = doc.select("table");

	         Elements tableHeaderEles = tableElements.select("tr th");
	         for (int i = 0; i < tableHeaderEles.size(); i++) {
	        	 String header = tableHeaderEles.get(i).text();
	        	 if(header.equals("First name")){FNameRow = i;}
	        	 if(header.equals("Last name")){LNameRow = i;}
	         }

	         Elements tableRowElements = tableElements.select(":not(thead) tr");

	         for (int i = 0; i < tableRowElements.size(); i++) {
	            Element row = tableRowElements.get(i);
	            Elements rowItems = row.select("td");
	            String first_name=null;
            	String last_name=null;
	            for (int j = 0; j < rowItems.size(); j++) {
	            	String name = rowItems.get(j).text();
	            	if(j==FNameRow){first_name = name;}
	            	if(j==LNameRow){last_name=name;}
	            }
	            if(first_name !=null && last_name!=null){
	            	PersonDAO tmp = new PersonDAO(first_name, last_name);
	            	dbStorage.add(tmp);
	            }
	         }

	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }
}

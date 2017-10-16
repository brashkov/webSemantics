package org.borko.spring.edu.dao;

import org.borko.spring.edu.utils.WebUtils;

public class PersonDAO {
	
	private String URI= "";
	private String first_name = "";
	private String last_name = "";
	
	

	public PersonDAO(String first_name , String last_name){
		this.first_name=first_name;
		this.last_name= last_name;
		generateURI();
		
	}
	
	public PersonDAO(){
		
	}
	
	public String getURI() {
		return URI;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}
	
	private void generateURI(){
		URI=WebUtils.toURI(first_name, last_name);
	}

	@Override
	public String toString(){
		return (first_name+" "+last_name);
	}
}

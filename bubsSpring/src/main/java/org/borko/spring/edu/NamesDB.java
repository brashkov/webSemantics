package org.borko.spring.edu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.borko.spring.edu.dao.PersonDAO;
import org.springframework.stereotype.Component;

@Component
public class NamesDB {
	
	//Fame -> List<PersonDAO>
	private Map<String,List<PersonDAO>> PersonDB = new HashMap<String,List<PersonDAO>>();
	
	//Lname -> List<Fnames>
	private Map<String,List<String>> lastToFirst = new HashMap<String,List<String>>();
	
	//URI to PersonDAO
	private Map<String,PersonDAO> uriDB = new HashMap<String,PersonDAO>();
	
	//All names combinations
	private List<String> allNames = new ArrayList<String>();
	 
	
	public void add(PersonDAO person){
		String first_name = person.getFirst_name();
		String last_name = person.getLast_name();
		
		if(allNames.contains(first_name+" "+last_name)){return;}else{addName(person);}
	
		// //Last_name -> List<First_names>
		if(lastToFirst.containsKey(last_name)){
			List<String> tmp = lastToFirst.get(last_name);
				tmp.add(first_name);
				lastToFirst.replace(last_name, tmp);
		}else{
			List<String> tmp = new ArrayList<String>();
			tmp.add(first_name);
			lastToFirst.put(last_name, tmp);
		}
		
		//Fame -> List<PersonDAO>
		if(PersonDB.containsKey(first_name)){
			List<PersonDAO> tmp = PersonDB.get(first_name);
				tmp.add(person);
				PersonDB.replace(first_name, tmp);
		}else{
			List<PersonDAO> tmp = new ArrayList<PersonDAO>();
			tmp.add(person);
			PersonDB.put(first_name, tmp);
		}
		
	}
	
	public List<PersonDAO> getFirst(String first_name){
		if(PersonDB.containsKey(first_name)){
		List<PersonDAO> tmp = PersonDB.get(first_name);
		return tmp;
		}else{
			return new ArrayList<PersonDAO>();
		}
	}
	
	public List<PersonDAO> getLast(String last_name){
		if(lastToFirst.containsKey(last_name)){
			List<PersonDAO> tmp = new ArrayList<PersonDAO>();
			for(String f_name :lastToFirst.get(last_name)){
				for(PersonDAO person : PersonDB.get(f_name)){
				if(person.getLast_name().equals(last_name)){
					tmp.add(person);
				}
				}
			}
			return tmp;
		}else{
			return new ArrayList<PersonDAO>();
		}
	}
	
	public List<PersonDAO> getAll(){
		List<PersonDAO> tmp = new ArrayList<PersonDAO>();
		for(String key : PersonDB.keySet()){
			tmp.addAll(PersonDB.get(key));
		}
		return tmp;
	}

	private void addName(PersonDAO person){
		String first_name = person.getFirst_name();
		String last_name = person.getLast_name();
		
		allNames.add(first_name+" "+last_name);
		uriDB.put(person.getURI(), person);
		
	}
	
	public PersonDAO fromURI(String URI){
		if(uriDB.containsKey(URI)){
			return uriDB.get(URI);
		}else{
			return new PersonDAO();
		}
	}

}

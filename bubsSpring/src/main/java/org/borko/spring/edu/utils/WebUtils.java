/**
 * 
 */
package org.borko.spring.edu.utils;


import org.apache.commons.validator.routines.UrlValidator;
import static net.sourceforge.urin.Host.*;
import static net.sourceforge.urin.Path.*;
import static net.sourceforge.urin.scheme.http.Http.*;

import java.net.URL;


/**
 * @author borko
 *
 */
public class WebUtils {
	
	private static final String localURL = "http://localhost:8080/";
	
	/**
	 * @param url Checking if URL is valid 
	 * @return true if the URL is valid and false if the URL is not valid
	 */
	public  static boolean checkURL(String url){
		UrlValidator defaultValidator = new UrlValidator(UrlValidator.ALLOW_LOCAL_URLS); // default schemes with local ip's
		return defaultValidator.isValid(url);
	}
	
	
	/**
	 * @param f_name First name
	 * @param l_name Last name
	 * @return URI for the specific person.Type String !
	 */
	public static String toURI(String f_name,String l_name){
		String URI = localURL+"user/"+f_name+l_name;
		System.out.println(URI);
		return URI;
	}
	
	//Add comments
	public static String URLtoURI(String name){
		String URI = localURL+"user/"+name;
		return URI;
	}

}

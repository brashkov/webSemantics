package org.borko.spring.edu.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.borko.spring.edu.NamesDB;
import org.borko.spring.edu.dao.PersonDAO;
import org.borko.spring.edu.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class URIController {
	
	@Autowired
	private NamesDB dbStorage;

	// SHOW ALL
	 @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
	 public ModelAndView showAll(@PathVariable String name) {
		 String URI = WebUtils.URLtoURI(name);
		 PersonDAO user = dbStorage.fromURI(URI);
		 
		 return new ModelAndView("resultPage", "listUsers", user); 
	 }

}

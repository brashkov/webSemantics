package org.borko.spring.edu.controllers;

import org.springframework.stereotype.Controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.borko.spring.edu.NamesDB;
import org.borko.spring.edu.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {
	
	@Autowired
	private NamesDB dbStorage;

	// SHOW ALL
	 @RequestMapping(value = "/showAll", method = RequestMethod.GET)
		public ModelAndView showAll(HttpServletRequest request) {
		 List<PersonDAO> listSearch = dbStorage.getAll();
		 
		 if (listSearch.isEmpty()) {
				return new ModelAndView("searchPage", "errmsgA", "No records found !");
			}
		 return new ModelAndView("resultPage", "listUsers", listSearch);
		 
	 }

	 // RESULT FROM SEARCH (First Name)
	@RequestMapping(value = "/firstName", method = RequestMethod.POST)
	public ModelAndView firstName(HttpServletRequest request) {
		System.out.println("NAMESDB HLC : " + dbStorage);
		String search = request.getParameter("search");
		
		if (search.isEmpty()) {
			return new ModelAndView("searchPage", "errmsg1", "Empty search ??");
		}
		
		List<PersonDAO> listSearch = dbStorage.getFirst(search);
		System.err.println("For "+search+" ->"+listSearch.size());
		if (listSearch.isEmpty()) {
			return new ModelAndView("searchPage", "errmsg1", "No Results Found");
		}
		
		return new ModelAndView("resultPage", "listUsers", listSearch);
	}
	
	 // RESULT FROM SEARCH (Last Name)
	@RequestMapping(value = "/lastName", method = RequestMethod.POST)
	public ModelAndView lastName(HttpServletRequest request) {
		System.out.println("NAMESDB HLC : " + dbStorage);
		String search = request.getParameter("search");
		
		if (search.isEmpty()) {
			return new ModelAndView("searchPage", "errmsg2", "Empty search ??");
		}
		
		List<PersonDAO> listSearch = dbStorage.getLast(search);
		System.err.println("For "+search+" ->"+listSearch.size());
		if (listSearch.isEmpty()) {
			return new ModelAndView("searchPage", "errmsg2", "No Results Found");
		}
		
		return new ModelAndView("resultPage", "listUsers", listSearch);
	}

}

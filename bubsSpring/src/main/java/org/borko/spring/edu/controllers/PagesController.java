package org.borko.spring.edu.controllers;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.borko.spring.edu.utils.DataBaseService;
import org.borko.spring.edu.utils.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@Controller
public class PagesController {

	 @RequestMapping("/")
     public String home() {
         return "inputPages";
     }
	 
		//INFTO SCAPRING
		@RequestMapping(value = "/urlScrap", method = RequestMethod.POST)
		public ModelAndView urlSrapc(HttpServletRequest request) {
			
			String url = request.getParameter("url");
			System.out.println("Checking URL : "+ url);
			if(WebUtils.checkURL(url)){
				DataBaseService.webScrap(url);
			}else{
				return new ModelAndView("inputPages","errmsg","Invalid link");
			}
			
			return new  ModelAndView("searchPage");

		}
		 
	  /*------------- TEST URL'S ------------*/
	  @RequestMapping("/A")
	     public String AFileTest() {
	         return "A";
	     }
	  @RequestMapping("/B")
	     public String BFileTest() {
	         return "B";
	     }
	
}

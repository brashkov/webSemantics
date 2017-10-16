package org.borko.spring.edu.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.boot.web.servlet.error.ErrorController;

import org.springframework.http.HttpStatus;

@EnableWebMvc // I have a question for this annotaion
@ControllerAdvice
public class ExceptionHandlerController implements ErrorController {
	
	    public static final String DEFAULT_ERROR_VIEW = "error";

	    @ExceptionHandler(NoHandlerFoundException.class)
	    @ResponseStatus(value=HttpStatus.NOT_FOUND)
	    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) {
	            
	    	ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);

	        System.out.println("Hello Error");
	        
	        mav.addObject("datetime", new Date());
	        mav.addObject("exception", e);
	        mav.addObject("url", request.getRequestURL());
	        return mav;
	    }

		@Override
		public String getErrorPath() {
			
			return "/error";
		}
	}


package com.vish.ff;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.ff4j.FF4j;
import org.ff4j.core.Feature;
import org.ff4j.spring.autowire.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Handles requests for the application home page.
 */
@Controller
@Scope("prototype")
//@ContextConfiguration("classpath:root-context.xml")
public class HomeController {

	@Autowired
	private FF4j ff4j;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/enable", method = RequestMethod.GET)
	public String enable() {
		
		ff4j.enable("hello");	
		System.out.println("enabled");
		return "flip";	
	}
	
	@RequestMapping(value = "/disable", method = RequestMethod.GET)
	public String disable() {
		
		ff4j.disable("hello");	
		System.out.println("disabled");
		return "flip";	
	}
	
}

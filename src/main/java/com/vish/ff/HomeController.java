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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Handles requests for the application home page.
 */
@Controller
//@ContextConfiguration("classpath:root-context.xml")
public class HomeController {
	
	@Autowired
	private FeaturesBean fb;
	
	@FF4JFeature("hello")
    private boolean helloFeature;
	
	@FF4JFeature("hello1")
    private boolean hello1Feature;
	
	@Autowired
	private FF4j ff4j;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/flip", method = RequestMethod.GET)
	public String flip() {
		logger.info("flip");
				
		logger.info("ff4j", ff4j.check("hello"));
		
		System.out.println("check "+ ff4j.check("hello"));
		System.out.println("annotation exisits " + this.helloFeature);
		System.out.println("annotation1 exisits " + this.hello1Feature);
		
		return "flip";	
	}
	
}

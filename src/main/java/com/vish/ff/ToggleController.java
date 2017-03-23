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
//@Scope("prototype")
//@ContextConfiguration("classpath:root-context.xml")
public class ToggleController {
	
	@Autowired
	private FeaturesBean fb;
	

	
	@Autowired
	private FF4j ff4j;
	
	private static final Logger logger = LoggerFactory.getLogger(ToggleController.class);
	
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
		
		ff4j.disable("hello");

		
		return "home";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/flip", method = RequestMethod.GET)
	public String flip(@Qualifier("myFeatureBean") FeaturesBean fb1) {
		
		System.out.println("check "+ ff4j.check("hello"));
		System.out.println("annotation " + fb.helloFeature);
		System.out.println("annotation2 " + fb1.helloFeature);

				
		return "flip";	
	}
	
}
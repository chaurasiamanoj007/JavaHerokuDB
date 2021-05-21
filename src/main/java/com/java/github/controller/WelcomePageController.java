package com.java.github.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.github.dao.UserDao;
import com.java.github.model.User;

/****************************************************************************************
 * This controller is the main page of the Heroku Java UI 
 * This will be called everytime the Heroku Java webapp is loaded
 ****************************************************************************************/
@Controller
@RequestMapping("/")
public class WelcomePageController {
	public static String CURRENT_CLASS		 		= "WelcomePageController";
	
	@Autowired
	UserDao userDao;
	
	
	/**
	 * This method gets called when the main page of the Heroku  UI is called 
	 * @return  
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "text/html")
	public String welcome(Model model) {
		String CURRENT_METHOD = "welcome";		
		System.out.println(CURRENT_CLASS+" ::: "+CURRENT_METHOD+":: Inside method");
		
		List<User> userLst = userDao.fetchUserDetails();
		model.addAttribute("userLst", userLst);
		return "welcome";
	}
}
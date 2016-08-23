package com.boot.rnd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {

  @RequestMapping("/")
  @ResponseBody
  public ModelAndView  index() {
	  ModelMap model = new ModelMap();
	    return new ModelAndView(
	       new RedirectView("/index.html", true),model);  
   
  }

}

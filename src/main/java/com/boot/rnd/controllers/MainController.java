package com.boot.rnd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

  @RequestMapping("/")
  @ResponseBody
  public String index() {
    return "Handcrafted by " +
        "<a href='http://manojkyadav.com/en'>Manoj Kumar Yadav</a> :)";
  }

}

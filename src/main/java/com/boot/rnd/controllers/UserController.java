package com.boot.rnd.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.boot.rnd.common.User;
import com.boot.rnd.models.UserDao;

/**
 * @author : Manoj Yadav
 * Class UserController
 */
@Controller
public class UserController {

 // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  // Wire the UserDao used inside this controller.
  @Autowired
  private UserDao userDao;
  
  // ------------------------
  // PUBLIC METHODS
  // ------------------------

  /**
   * Create a new user with an auto-generated id and email and name as passed 
   * values.
   */
  @RequestMapping(value="/create")
  @ResponseBody
  public ModelAndView create(String email, String name) {
    try {
      User user = new User(email, name);
      userDao.create(user);
   
    //return "User succesfully created!";
    ModelMap model = new ModelMap();
    model.put(user.getName(), user);
    
    return new ModelAndView(
 	       new RedirectView("/index.html#/users", true),model);  
    }
    catch (Exception ex) {
      return null;
    }
  }
  
  /**
   * Delete the user with the passed id.
   */
  @RequestMapping(value="/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      User user = new User(id);
      userDao.delete(user);
    }
    catch (Exception ex) {
      return "Error deleting the user: " + ex.toString();
    }
    return "User succesfully deleted!";
  }
  
  /**
   * Retrieve the id for the user with the passed email address.
   */
  @RequestMapping(value="/get-by-email")
  @ResponseBody
  public String getByEmail(String email) {
    String userId;
    try {
      User user = userDao.getByEmail(email);
      userId = String.valueOf(user.getId());
    }
    catch (Exception ex) {
      return "User not found: " + ex.toString();
    }
    return "The user id is: " + userId;
  }
  
  /**
   * Retrieve the id for the user with the passed email address.
   */
  @RequestMapping(value="/getAllUser")
  @ResponseBody
  public ModelAndView getUserDetailsByEmail(String email) {
	  List<User> users =null;
    try {
       users = userDao.getAll();
       
       ModelMap model = new ModelMap();
       model.put("usersList", users);
       
       return new ModelAndView(
    	       new RedirectView("/index.html#/users", true),model); 
     
    }
    catch (Exception ex) {
    ex.printStackTrace();
      return null;
    }
    //return users;
  }
  
  
  /**
   * Update the email and the name for the user indentified by the passed id.
   */
  @RequestMapping(value="/update")
  @ResponseBody
  public String updateName(long id, String email, String name) {
    try {
      User user = userDao.getById(id);
      user.setEmail(email);
      user.setName(name);
      userDao.update(user);
    }
    catch (Exception ex) {
      return "Error updating the user: " + ex.toString();
    }
    return "User succesfully updated!";
  } 

 
  
} // class UserController
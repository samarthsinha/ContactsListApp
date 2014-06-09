package com.springapp.firstapp.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springapp.config.SpringMongoConfig;
import com.springapp.firstapp.model.Contact;
import com.springapp.helper.MongoHelper;

/**
 * Handles requests for the application home page.
 */
	
@Controller
@SessionAttributes
	public class HomeController {

	    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
	    public String addContact(@ModelAttribute("contact")
	                            Contact contact,Map<String,Object> model) {
	        if(contact.getFirstname().trim().equals("") ){
	        	return "redirect:/index";
	        }
	    	MongoHelper.save(contact);
	        return "redirect:showContact";
	    }
	     
	    @RequestMapping(value={"/","/index"},method = RequestMethod.GET)
	    public ModelAndView showContacts() {
	    	Map<String,Object> model = new HashMap<String, Object>();
	    	model.put("command",new Contact());
	    	model.put("pages", 'a');
	    	model.put("title", "Home");
	    	return new ModelAndView("home",model);
	    }
	    
	    @RequestMapping(value = "/showContact", method = RequestMethod.GET)
	    public ModelAndView showContact() {
	        Map<String, Object> model = new HashMap<String, Object>();
	        
	    	String title = "Contacts List";
	        model.put("title",title);
	        ArrayList<Contact> lists = (ArrayList<Contact>) MongoHelper.fetchAll(new Contact());
	        for(int i=0;i<lists.size();i++){
	        	System.out.println("List from mongo"+lists.get(i).getFirstname());
	        }
	        if(lists.size()==0){
	        	return new ModelAndView("redirect:/");
	        }
	        model.put("title", "Contact List");
	        model.put("lists", lists); 
	        return new ModelAndView("contacts", model);
	    }
	    @RequestMapping(value="/deleteContact",method=RequestMethod.GET)
	    public String delete(@RequestParam String id){
	    	MongoHelper.delete(id, (Contact)MongoHelper.findById(id, new Contact()));
	    	return "redirect:showContact";
	    }
	    @RequestMapping(value="/updateContact",method=RequestMethod.GET)
	    public ModelAndView updateContactPage(@RequestParam String id){
	    	Contact contact=(Contact)MongoHelper.findById(id, new Contact());
	    	Map<String, Object> model = new HashMap<String, Object>();
	    	model.put("contact",contact);
	    	model.put("pages", 'u');
	    	 model.put("title", "Update Contact");
	    	return new ModelAndView("update",model);
	    }
	    @RequestMapping(value="/update",method=RequestMethod.POST)
	    public String updateContact(@ModelAttribute("contact")
        Contact contact,Map<String,Object> model){
	    	MongoHelper.save(contact);
	    	return "redirect:showContact";
	    }
	   
	}
	


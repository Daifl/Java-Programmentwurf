package de.dhbwheidenheim.informatik.assfalg.personspring.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class PersonController {
	
	int temp = 0;
	
	//---------------------------
	@RequestMapping(value = "/receiveCall/{id}/", method = RequestMethod.GET)
	public @ResponseBody boolean receiveCall(@PathVariable("id") int id) {
		
		temp = id;
		return true;
	}
	
	
	@RequestMapping("/getCall")
	public int getCall() {
		return temp;
	}

	//-------------------------

	@RequestMapping("/")
	public String home() {
		System.out.println("Wir sind da!");
		return ("<html>Hallo Welt, hier ist Johannes<br>\n"); 
	}

}
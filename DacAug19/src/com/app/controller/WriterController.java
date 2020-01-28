package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IEditerDao;

@RestController // @Controller + @ResponseBody
@RequestMapping("/writer") // resource oriented
@CrossOrigin(allowedHeaders = "*")
public class WriterController 
{
	@Autowired
	private IEditerDao editordao;
	public WriterController() {
		System.out.println("inside writer controler");
	}
	
	
	
	
}

package com.penchala.yegu.kahootclone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

/*
	Date : 21/10/2020
	Author : Penchala Yegu


	LOGIN CONTROLLER
	
	This controller authenticates the user and password and lets you login
*/

@RestController
@RequestMapping("/login")
public class LoginController{
	
	@PostMapping
	public String authorizeLogin(String userName,String password){
		return "SUCCESS"; 
	}

//end of login controller
}

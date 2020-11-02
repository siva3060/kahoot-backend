
package com.penchala.yegu.kahootclone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

/*
	Date : 2/11/2020
	Author : Penchala Yegu

	This controller will generate a random unique game pin 
*/

@RestController
@RequestMapping("/gamepin")
public class GamePinController{

@GetController
public int generateRandomGamePin(){
	int GamePin;
	Random rd = new Random();
	GamePin = rd.nextInt(9999);
	return GamePin;	
}

}

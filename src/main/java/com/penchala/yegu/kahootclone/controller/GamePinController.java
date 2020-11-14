package com.penchala.yegu.kahootclone.controller;


import com.penchala.yegu.kahootclone.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/*
	Date : 2/11/2020
	Author : Penchala Yegu

	This controller will generate a random unique game pin 
*/

@RestController
@RequestMapping("/gamepin")
public class GamePinController{

	@Autowired
	GameService gameService;

//Generate a new Gamepin
	/*
	* 	1. What if somehow it has generated a Gamepin value that is already existed in the database
	* */
@GetMapping
public int generateRandomGamePin(){
	int GamePin;
	Random rd = new Random();
	GamePin = rd.nextInt(9999);
	gameService.createGame(GamePin);
	return GamePin;	
}

// Does a Game exist with the given Game Pin
@PostMapping("/{gamePin}")
public String  isGameExist(@PathVariable String gamePin){
	 int pin = Integer.parseInt(gamePin);
	 if(gameService.gameExist(pin)){
	 	return "A Game with this pin exist";
	 }
	 return "Game Doesn't exist";
}

}

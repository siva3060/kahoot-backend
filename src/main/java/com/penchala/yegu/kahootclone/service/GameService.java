package com.penchala.yegu.kahootclone.service;


import com.penchala.yegu.kahootclone.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
	Date : 3/11/2020
	Author : Penchala Yegu

	This controller will generate a random unique game pin 
*/


@Service
public class GameService{

	@Autowired
	GameRepository gameRepository;

	public void createGame(int gameId){
		gameRepository.save(gameId);
	}

	public Boolean gameExist(int gamePin){
		return gameRepository.findGame(gamePin);
	}
	//end of class GameService
	
}

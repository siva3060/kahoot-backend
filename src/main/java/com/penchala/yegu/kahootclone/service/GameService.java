package com.penchala.yegu.kahootclone.service;


import com.penchala.yegu.kahootclone.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class GameService{

	@Autowired
	GameRepository gameRepository;

	public void createGame(int gameId){
		gameRepository.save(gameId);
	}
	//end of class GameService
}

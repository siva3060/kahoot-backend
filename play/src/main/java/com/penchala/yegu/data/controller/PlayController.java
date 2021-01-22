package com.penchala.yegu.data.controller;

import com.penchala.yegu.data.model.Play.Play;
import com.penchala.yegu.data.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class PlayController{

    @Autowired
    PlayService playService;

    //Gets a single question for test purpose
    @GetMapping("/play")
    public Play getOnePlay(){
        return playService.getOnePlay();
    }

    // will get a set of 3 question and can intergreate wit
    // game user and other modules to complete the flow
    @GetMapping("/sample")
    public List<Play> getSamplePlay(){
        return playService.getSamplePlay();
    }


}

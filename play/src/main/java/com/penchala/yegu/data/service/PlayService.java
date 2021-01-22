package com.penchala.yegu.data.service;

import com.penchala.yegu.data.model.Play.Play;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PlayService {

    private String[] optionsA = {"Lion","Griaffe","Tiger","Chimp"};
    private String[] optionsB = {"Chennai","Mumbai","Hyderbad","New Delhi"};
    private String[] optionsC = {"Gandhi","Nehru","Vallabhi Patel","BR Rao"};


    public Play getOnePlay() {
       Play play = new Play("National Animal ?",optionsA,"Tiger");
      return play;
   }

    public List<Play> getSamplePlay() {

       List<Play> playList = new ArrayList<>();

       playList = Arrays.asList(
        new Play("Father Of Nation ?",optionsA,"Gahdhi"),
        new Play(" National Animal  ?",optionsC,"Tiger"),
        new Play(" Captial Of India  ?",optionsB,"New Delhi")
       );

       return playList;
    }
}

/*
* This service should read the question and answers from various data
* streams
* */
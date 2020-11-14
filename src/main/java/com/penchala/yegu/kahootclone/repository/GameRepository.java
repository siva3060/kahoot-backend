package com.penchala.yegu.kahootclone.repository;

import com.penchala.yegu.kahootclone.model.Game;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends CrudRepository<Game,Integer> {

    Optional<Game> findByGamePin(int gamePin);
}
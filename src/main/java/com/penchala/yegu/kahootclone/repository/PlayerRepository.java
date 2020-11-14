package com.penchala.yegu.kahootclone.repository;

import com.penchala.yegu.kahootclone.model.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Long> {

    List<Player> findByGamePin(int gamePin);
}

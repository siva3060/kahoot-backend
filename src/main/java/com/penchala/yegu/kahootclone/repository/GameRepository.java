package com.penchala.yegu.kahootclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface GameRepository extends JpaRepository<Integer,Integer> {

    @Query(value = "select * from Game where GamePin = gamePin",nativeQuery = true)
    Boolean findGame(int gamePin);
}
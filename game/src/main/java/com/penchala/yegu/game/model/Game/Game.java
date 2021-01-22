package com.penchala.yegu.game.model.Game;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
public class Game {
    @Id
    private Integer gamePin;
    private Integer userId;
    private Date    createdDate;
}

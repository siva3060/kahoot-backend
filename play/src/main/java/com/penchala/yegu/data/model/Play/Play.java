package com.penchala.yegu.data.model.Play;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Play {
    private String question;
    private String[] options = new String[4];
    private String answer;
}

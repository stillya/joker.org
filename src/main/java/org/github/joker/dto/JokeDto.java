package org.github.joker.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class JokeDto implements Serializable {
    String joke;
    Integer id;
}

package org.github.joker.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JokeDto implements Serializable {
    String joke;
    Integer id;
    @JsonIgnore
    Long votes;

    public JokeDto(Integer id, String joke, long votes) {
        this.id = id;
        this.joke = joke;
        this.votes = votes;
    }
}

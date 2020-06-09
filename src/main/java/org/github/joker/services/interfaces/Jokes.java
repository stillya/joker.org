package org.github.joker.services.interfaces;

import java.util.List;

import org.github.joker.dto.JokeDto;

public interface Jokes {

    JokeDto getJoke();
    void likeJoke(int jokeId);
    void dislikeJoke(int jokeId);
    List<JokeDto> getTopJokes();

}

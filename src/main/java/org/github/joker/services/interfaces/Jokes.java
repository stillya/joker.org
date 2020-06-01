package org.github.joker.services.interfaces;

import java.util.List;
import java.util.Map;

public interface Jokes {

    Map<String, Integer> getJoke();
    void likeJoke(Integer jokeId);
    void dislikeJoke(Integer jokeId);
    List<Map<String, Integer>> getTopJokes();

}

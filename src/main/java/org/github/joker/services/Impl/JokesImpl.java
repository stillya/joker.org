package org.github.joker.services.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.github.joker.dto.JokeDto;
import org.github.joker.services.interfaces.Jokes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokesImpl implements Jokes {

    @Value("${joker.url}")
    private String URL_JOKES_API;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Map<String, Integer> getJoke() {
        Stream<JokeDto> jokeStream = Stream.of(restTemplate.getForObject(URL_JOKES_API, JokeDto.class));
        Map<String, Integer> joke = jokeStream.collect(Collectors.toMap(p->p.getJoke(), t->t.getId()));
        return joke;
    }

    @Override
    public void likeJoke(Integer jokeId) {

    }

    @Override
    public void dislikeJoke(Integer jokeId) {

    }

    @Override
    public List<Map<String, Integer>> getTopJokes() {
        return null;
    }

}

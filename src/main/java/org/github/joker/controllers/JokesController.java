package org.github.joker.controllers;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.github.joker.services.interfaces.Jokes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/jokes")
@AllArgsConstructor
@Slf4j
public class JokesController {

    Jokes jokes;

    @GetMapping
    public Map<String, Integer> getJoke() {
        this.log.info("Get joke");
        return jokes.getJoke();
    }

    @GetMapping(path = "/like")
    public void likeJoke(Integer jokeId) {

    }

    @GetMapping(path = "/dislike")
    public void dislikeJoke(Integer jokeId) {

    }

    @GetMapping(path = "/top")
    public List<Map<String, Integer>> getTopJokes() {
        return null;
    }



}

package org.github.joker.controllers;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.github.joker.dto.JokeDto;
import org.github.joker.services.interfaces.Jokes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/jokes")
@RequiredArgsConstructor
@Slf4j
public class JokesController {

    private final Jokes jokes;

    @GetMapping
    public JokeDto getJoke() {
        this.log.info("Get joke");
        return this.jokes.getJoke();
    }

    @GetMapping(path = "/like")
    public void likeJoke(@RequestParam Integer jokeId) {
        this.log.info("Like joke");
        this.jokes.likeJoke(jokeId.intValue());
    }

    @GetMapping(path = "/dislike")
    public void dislikeJoke(@RequestParam Integer jokeId) {
        this.log.info("Dislike joke");
        this.jokes.dislikeJoke(jokeId.intValue());
    }

    @GetMapping(path = "/top")
    public List<JokeDto> getTopJokes() {
        this.log.info("Get top jokes");
        return this.jokes.getTopJokes();
    }

}

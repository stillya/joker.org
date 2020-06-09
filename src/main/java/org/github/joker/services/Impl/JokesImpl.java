package org.github.joker.services.Impl;

import java.util.List;

import org.github.joker.dto.JokeDto;
import org.github.joker.services.crud.JdbcJokeRepository;
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
    @Autowired
    JdbcJokeRepository jdbcJokeRepository;

    @Override
    public JokeDto getJoke() {
        JokeDto jokeDto = restTemplate.getForObject(URL_JOKES_API, JokeDto.class);
        return jokeDto;
    }

    @Override
    public void likeJoke(int jokeId) {
        if (jdbcJokeRepository.count(jokeId) == 0) {
            saveJoke(jokeId);
        }
        jdbcJokeRepository.incrementVote(jokeId);
    }

    @Override
    public void dislikeJoke(int jokeId) {
        if (jdbcJokeRepository.count(jokeId) == 0) {
            saveJoke(jokeId);
        }
        jdbcJokeRepository.decrementVote(jokeId);
    }

    @Override
    public List<JokeDto> getTopJokes() {
        return jdbcJokeRepository.findFirst(5);

    }

    private void saveJoke(int jokeId) {
        JokeDto jokeDto = restTemplate.getForObject(URL_JOKES_API + "&idRange=" + jokeId, JokeDto.class);
        jokeDto.setVotes((long) 0);
        jdbcJokeRepository.save(jokeDto);
    }

}

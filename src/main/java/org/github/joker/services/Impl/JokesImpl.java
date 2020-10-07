package org.github.joker.services.Impl;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.github.joker.dto.JokeDto;
import org.github.joker.services.crud.JdbcJokeRepository;
import org.github.joker.services.interfaces.Jokes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class JokesImpl implements Jokes {

    @Value("${joker.url}")
    private String URL_JOKES_API;

    private final RestTemplate restTemplate;
    private final JdbcJokeRepository jdbcJokeRepository;

    @Override
    public JokeDto getJoke() {
        JokeDto jokeDto = this.restTemplate.getForObject(URL_JOKES_API, JokeDto.class);
        return jokeDto;
    }

    @Override
    public void likeJoke(int jokeId) {
        if (this.jdbcJokeRepository.count(jokeId) == 0) {
            saveJoke(jokeId);
        }
        this.jdbcJokeRepository.incrementVote(jokeId);
    }

    @Override
    public void dislikeJoke(int jokeId) {
        if (this.jdbcJokeRepository.count(jokeId) == 0) {
            saveJoke(jokeId);
        }
        this.jdbcJokeRepository.decrementVote(jokeId);
    }

    @Override
    public List<JokeDto> getTopJokes() {
        return this.jdbcJokeRepository.findFirst(5);

    }

    private void saveJoke(int jokeId) {
        JokeDto jokeDto = this.restTemplate.getForObject(URL_JOKES_API + "&idRange=" + jokeId, JokeDto.class);
        jokeDto.setVotes((long) 0);
        this.jdbcJokeRepository.save(jokeDto);
    }

}

package org.github.joker.repositories;

import java.util.List;
import java.util.Optional;

import org.github.joker.dto.JokeDto;

public interface JokeRepository {
    int count(int id);
    List<JokeDto> findFirst(int num);
    void incrementVote(int id);
    void decrementVote(int id);
    void save(JokeDto jokeDto);
}

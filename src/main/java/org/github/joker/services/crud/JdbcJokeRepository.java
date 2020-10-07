package org.github.joker.services.crud;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.github.joker.dto.JokeDto;
import org.github.joker.repositories.JokeRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JdbcJokeRepository implements JokeRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int count(int id) {
        return this.jdbcTemplate.queryForObject("select count(*) from top_jokes where id = ?",
                new Object[]{id},
                Integer.class);
    }

    @Override
    public List<JokeDto> findFirst(int num) {
        return this.jdbcTemplate.query("select * from top_jokes order by votes ASC limit ?",
                new Object[]{num},
                (rs, rowNum) -> new JokeDto(rs.getInt("id"), rs.getString("joke"), rs.getLong("votes")));
    }

    @Override
    public void incrementVote(int id) {
        this.jdbcTemplate.update("update top_jokes set votes = votes + 1 where id = ?", id);
    }

    @Override
    public void decrementVote(int id) {
        this.jdbcTemplate.update("update top_jokes set votes = votes - 1 where id = ?", id);
    }

    @Override
    public void save(JokeDto jokeDto) {
        this.jdbcTemplate.update("insert into top_jokes(id, joke, votes) values(?,?,?)",
                jokeDto.getId(),
                jokeDto.getJoke(),
                jokeDto.getVotes());
    }
}


package kakao.kakaoapi.repository;

import kakao.kakaoapi.domain.Actor;
import kakao.kakaoapi.domain.Movie;

import java.util.List;

public interface movieRepository {

    void save(Movie movie);

    List<Movie> findAll(Movie movie);

    Movie findOne(Long id);


    List<Movie> findByActor(MovieSearch movieSearch);

}


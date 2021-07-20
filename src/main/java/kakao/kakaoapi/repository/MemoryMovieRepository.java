package kakao.kakaoapi.repository;

import kakao.kakaoapi.domain.Actor;
import kakao.kakaoapi.domain.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class MemoryMovieRepository implements movieRepository{



    @PersistenceContext
    private final EntityManager em;

    public MemoryMovieRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Movie movie) {

        em.persist(movie);

    }

    @Override
    public List<Movie> findAll(Movie movie) {
        return em.createQuery("select m from Movie m",Movie.class).getResultList();
    }

    @Override
    public Movie findOne(Long Id) {
        return em.find(Movie.class, Id);
    }


    @Override
    public List<Movie> findByActor(MovieSearch movieSearch) {
        return em.createQuery("select m from Movie m " +
                " join fetch m.movieActors ma" +
                " where ma.actor = :actor", Movie.class)
                .setParameter("actor", movieSearch.getActorName())
                .getResultList();
    }
}

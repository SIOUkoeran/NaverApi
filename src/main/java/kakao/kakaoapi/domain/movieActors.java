package kakao.kakaoapi.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "movie_actors")
public class movieActors {


    @Id @GeneratedValue
    @Column(name = "movie_actors")
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;


}

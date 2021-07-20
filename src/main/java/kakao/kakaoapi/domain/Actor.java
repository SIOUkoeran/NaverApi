package kakao.kakaoapi.domain;


import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue
    @Column(name = "actor_id")
    private Long id;


    @ManyToOne
    private Movie movie;


    @OneToMany(mappedBy = "actor")
    private List<movieActors> movieList = new ArrayList<>();

}

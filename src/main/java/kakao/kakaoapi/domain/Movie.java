package kakao.kakaoapi.domain;


import lombok.Getter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "movie")
public class Movie {


    @Id @GeneratedValue
    @Column(name = "movie_id")
    private Long id;

    @Column(name = "movie_title")
    private String title;

    private String link;
    private int Date;
    private String director;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<movieActors> movieActors = new ArrayList<>();

    private int Rate;




}

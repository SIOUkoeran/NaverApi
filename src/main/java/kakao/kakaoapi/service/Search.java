package kakao.kakaoapi.service;

import kakao.kakaoapi.domain.ResponseDAO;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface Search {
    Mono<ResponseDAO> findMovie(String keyword);


}

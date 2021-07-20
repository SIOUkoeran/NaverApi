package kakao.kakaoapi.service;


import kakao.kakaoapi.domain.ResponseDAO;


import org.springframework.http.HttpMethod;

import org.springframework.stereotype.Service;

import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;



@Service
public class SearchImpl implements Search {


    private final String ClientValue = "iobU59rryPaVcNgzZqTI";
    private final String ClientKey = "rHxPmqu2dG";
    private final String Url = "https://openapi.naver.com/v1/search/movie.json";

    @Override
    public Mono<ResponseDAO> findMovie(String keyword) {

        return WebClient.create(Url)
                .method(HttpMethod.GET)
                .uri("?query=" + keyword)
                .header("X-naver-client-id", ClientValue)
                .header("X-naver-client-secret", ClientKey)
                .retrieve()
                .bodyToMono(ResponseDAO.class);

    }
}

package kakao.kakaoapi.controller;


import kakao.kakaoapi.domain.ResponseDAO;
import kakao.kakaoapi.form.SearchForm;
import kakao.kakaoapi.service.Search;
import kakao.kakaoapi.service.SearchImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import reactor.core.publisher.Mono;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;


@Controller
public class NaverApiController {


    private final Search search;

    @Autowired
    public NaverApiController(Search search) {
        this.search = search;
    }

    @GetMapping("/")
    public String SearchForm(Model model) {
        model.addAttribute("searchForm", new SearchForm());

        return "main";
    }

    @PostMapping("/")
    @ResponseBody
    public Mono<ResponseDAO> Search(@ModelAttribute SearchForm searchForm) {


        return search.findMovie(searchForm.getTitle());



    }

    @GetMapping("/{title}")

    public Result Search(@PathVariable("title") String title) {
        return new Result(search.findMovie(title));


    }

    @Data
    @AllArgsConstructor
    static class Result<T>{


        private T data;
    }


}









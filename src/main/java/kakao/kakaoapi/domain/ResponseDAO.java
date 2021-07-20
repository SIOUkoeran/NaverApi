package kakao.kakaoapi.domain;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Data
@RequiredArgsConstructor
public class ResponseDAO  implements Serializable {

    private int display;
    private item[] items;

    @Data
    public static class item{
        String title;
        String actor;

        String link;
        int date;
        String director;
        int rate;
        }
}

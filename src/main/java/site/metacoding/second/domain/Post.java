package site.metacoding.second.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//model! db에서 들고 오는게 아니라 내가 강제로 만들어서 들고와보자 !

@Getter
@Setter
@AllArgsConstructor
public class Post {
    private int id;
    private String title;
    private String content;
}

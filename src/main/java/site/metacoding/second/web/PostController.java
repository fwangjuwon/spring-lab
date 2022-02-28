package site.metacoding.second.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    // 주세요는 구체적으로 뭘 달라고 해야함 - body 없다.
    // 프라이머리 키 1번 게시글 주세요 ?id=1
    // select * from post where id =?
    @GetMapping("/post/{id}") // {} 쓰면 {id} path variable 방식 //보통 프라이머리키로 요청한다.
    public String test1(@PathVariable int id) {
        return "<h1>주세요 </h1>" + id;
    }

    // 타이틀이 뭐인것을 찾아주세요 - 제목은 동일한게 있을 수 있으니 프라이머리키로 요청 안함: 쿼리스트링으로 받으면 된다.
    // select * from post where title = ?
    // http://localhost:8000/post?title=?
    @GetMapping("/post")
    public String serach(String title) { // 받고 싶은걸 매개변수로 넣어주면 된다. 쿼리스트링을 여기서 받음
        return " 주세요 title " + title;
    }

    // 줄게(crud 중 create - db에서는 insert) - 바디가 있다.
    // 타이틀이랑 주소를 주고 싶어
    // http://localhost:8000/post
    // body:title=제목1&content=내용1 //바디에 이렇게 정보가 담겨서 옴 -> 헤더에 바디의 데이터가 어떻게 생겻는지 알려줘야됨
    // header: Content-Type:application/x-www-form-urlencoded 라고 알려줘야 된다.
    // request.getParameter() 메소드가 스프링 기본 파싱 전략
    @PostMapping("/post") // http body의 user정보를 들고 가야한다.
    public String test2(String title, String content) {
        return "줄게요 타이틀" + title + "줄게요 내용" + content;
    }

    // 주소가 같은데 메소드가 달라서 다르게 인식할 수 있다.

    // 수정해 (crud 중 update - db에서는 update) - 바디가 있다
    // update post set title =?, content =? where id= ?
    // title, content두개 수정해 , 프라이머리키도 같이 보내야한다. (id)
    // id를 찾아서 수정할거야 where 조건에 들어가는 것은 (id) 주소에 붙여
    // API 문서를 만들어줘야헤
    @PutMapping("/post/{id}")
    public String test3(String title, String content, @PathVariable int id) {
        return "제목 수정해:  " + title + " 내용 수정해: " + content + " id: " + id;
    }

    // http://localhost:8000/post?title=제목1
    // DELETE FROM POST WHERE title=?

    // http://localhost:8000/post/1
    // delete from post where id = ?
    // 지워 (crud 중 delete - db에서는 delete) - 바디가 없다
    @DeleteMapping("/post/{id}")
    public String test4(@PathVariable int id) {
        return " 지워 id:" + id;
    }
}

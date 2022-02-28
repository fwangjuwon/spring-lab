package site.metacoding.second.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import site.metacoding.second.domain.Post;

//view 글쓰기 페이지, 글 목록 페이지, 글 상세보기 페이지
@Controller
public class PostController {

    @GetMapping("/post/writeForm")
    public String writeForm() {
        return "post/writeForm";
    }

    @GetMapping("/post/list")
    public String list(Model model) {

        Post post1 = new Post(1, "제목2", "내용2");
        Post post2 = new Post(2, "제목3", "내용3");
        Post post3 = new Post(3, "제목4", "내용4");
        Post post4 = new Post(4, "제목5", "내용5");
        Post post5 = new Post(5, "제목6", "내용6");
        List<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);
        posts.add(post5);

        model.addAttribute("posts", posts);

        return "post/list";
    }

    @GetMapping("/post/detail")
    public String detail(Model model) { // 매개변수에 model이 있으니까 내가 들고 있는 request를 여기 넣어준다. model = request
        // 알아서 request에 있는 것들을 뿌려준다.

        // 1. db에 연결해서 select 해와야한다.
        // 2. resultset 을 javaobject로 변경해야한다.
        Post post = new Post(1, "제목1", "내용1");

        // 3. 걔를 request에 담아야한다. -> vew에 담아올 수 있다.
        model.addAttribute("post", post);

        return "post/detail"; // 스프링은 기본적으로 리턴하는 것이 requestdispatcher로 forward해준다 -> request가 복제된다!
    }

}

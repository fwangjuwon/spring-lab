package site.metacoding.second.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondController {

    // 줘 (crud 중 read - db에서는 select)
    @GetMapping("/user") // user table의 모든걸 줘 !
    public String test1() {
        return "<h1>test1</h1>";
    }

    // 줄게(crud 중 create - db에서는 insert)
    @PostMapping("/user") // http body의 user정보를 들고 가야한다.
    public String test2() {
        return "<h1>test2</h1>";
    }

    // 주소가 같은데 메소드가 달라서 다르게 인식할 수 있다.

    // 수정해 (crud 중 update - db에서는 update)
    @PutMapping("/user")
    public String test3() {
        return "<h1>test3</h1>";
    }

    // 지워 (crud 중 delete - db에서는 delete)
    @DeleteMapping("/user")
    public String test4() {
        return "<h1>test4</h1>";
    }
}

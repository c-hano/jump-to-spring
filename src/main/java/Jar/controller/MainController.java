package Jar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@Controller 작성 시 MainController 클래스는 스프링부트의 컨트롤러가 된다.
public class MainController {

    @GetMapping("sbb")
    //index메서드의 @GetMapping 에너테이션은 요청된 URL과의 매핑을 담당하낟.
    //브라우저가 URL을 요청하면 스프링 부트는 요청 페이지와 매핑되는 메서드를 찾아 실행한다.
    public void index() {
        System.out.println("index");
    }
}

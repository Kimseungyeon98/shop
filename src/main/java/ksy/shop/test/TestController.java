package ksy.shop.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/test/registerForm")
    public String test(){

        return "test/testRegisterForm";
    }
    @GetMapping("/test/testList")
    public String test1(){

        return "test/testList";
    }
}

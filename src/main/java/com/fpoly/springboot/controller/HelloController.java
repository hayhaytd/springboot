package com.fpoly.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Xin chao sinh vien FPT Polytechnic!";
    }

    @GetMapping("/math/sum")
    public String tinhTong(
            @RequestParam(defaultValue = "0") int a,
            @RequestParam(defaultValue = "0") int b) {

        int tong = a + b;

        return "Ket qua = " + tong;
    }

    @GetMapping("/info")
    public String info() {
        return "Ho ten: Do Hoang Thien Dinh\n" +
                "MSSV: TS01689";
    }
    @GetMapping("/time")
    public String time() {
        return java.time.LocalDateTime.now().toString();
    }
}

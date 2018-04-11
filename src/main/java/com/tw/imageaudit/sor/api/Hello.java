package com.tw.imageaudit.sor.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hf_cherish
 * @date 4/11/18
 */
@RestController("/echo")
public class Hello {
    @GetMapping
    public ResponseEntity<String> echo() {
        return ResponseEntity.ok("hello world");
    }
}

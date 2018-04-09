package com.tw.imageaudit.sor.api;

import com.tw.imageaudit.sor.domain.Image;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/**
 * @author hf_cherish
 * @date 4/9/18
 */
@RestController("/images")
public class ImagesApi {
    @PostMapping
    public ResponseEntity saveImage(@RequestBody Image image) {
        return ResponseEntity.created(URI.create("")).build();
    }
}

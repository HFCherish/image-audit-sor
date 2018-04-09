package com.tw.imageaudit.sor.api;

import com.alibaba.fastjson.JSONObject;
import com.tw.imageaudit.sor.domain.Image;
import com.tw.imageaudit.sor.domain.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    ImageRepo imageRepo;

    @PostMapping
    public ResponseEntity saveImage(@RequestBody JSONObject image) {
        Image saved = imageRepo.save(Image.build(image));
        return ResponseEntity.created(URI.create("/images/" + saved.getId())).build();
    }
}

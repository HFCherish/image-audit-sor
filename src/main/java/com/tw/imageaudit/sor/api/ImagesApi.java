package com.tw.imageaudit.sor.api;

import com.alibaba.fastjson.JSONObject;
import com.tw.imageaudit.sor.domain.Approval;
import com.tw.imageaudit.sor.domain.ApprovalRepo;
import com.tw.imageaudit.sor.domain.Image;
import com.tw.imageaudit.sor.domain.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.net.URI;

/**
 * @author hf_cherish
 * @date 4/9/18
 */
@RestController
public class ImagesApi {
    @Autowired
    ImageRepo imageRepo;

    @Autowired
    ApprovalRepo approvalRepo;

    @PostMapping("/images")
    public ResponseEntity saveImage(@RequestBody JSONObject image) {
        Image saved = imageRepo.save(Image.build(image));
        return ResponseEntity.created(URI.create("/images/" + saved.getId())).build();
    }

    @PostMapping("/images/{imageId}/approval")
    public ResponseEntity approve(@PathVariable String imageId) {
        Image image = imageRepo.findById(imageId).orElseThrow(() -> new EntityNotFoundException());
        approvalRepo.save(new Approval(image));
        return ResponseEntity.created(URI.create("/images/" + imageId)).build();
    }

}

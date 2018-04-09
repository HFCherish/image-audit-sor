package com.tw.imageaudit.sor.domain;

import java.time.Instant;

/**
 * @author hf_cherish
 * @date 4/9/18
 */
public class ApprovedImage {
    private String imageId;
    private Instant createAt;

    public ApprovedImage(String imageId) {
        this.imageId = imageId;
        this.createAt = Instant.now();
    }
}

package com.tw.imageaudit.sor.domain;

import javax.persistence.*;
import java.time.Instant;

/**
 * @author hf_cherish
 * @date 4/9/18
 */
@Entity
@Table(name = "approvals")
public class Approval {
    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn
    private Image image;

    @Id
    @Column(name = "imageid")
    private String imageId;
    @Column(name = "create_at")
    private long createAt;

    private Approval() {
    }

    public Approval(Image image) {
        this.image = image;
        this.imageId = image.getId();
        this.createAt = Instant.now().toEpochMilli();
    }
}

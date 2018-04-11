package com.tw.imageaudit.sor.domain;

import com.alibaba.fastjson.JSONObject;
import com.tw.imageaudit.sor.domain.util.IdGenerator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author hf_cherish
 * @date 4/9/18
 */
@Entity
@Table(name = "images")
public class Image {
    @Id
    private String id;
    private String data;
    private String name;
    private String description;

    private Image(){}

    public Image(String data, String name) {
        this.data = data;
        this.name = name;
        this.id = IdGenerator.next();
    }

    public Image setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getId() {
        return id;
    }

    public static Image build(JSONObject image) {
        return new Image(image.getString("data"), image.getString("name"))
                .setDescription(image.getString("description"));
    }
}

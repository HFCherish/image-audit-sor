package com.tw.imageaudit.sor.domain;

import com.tw.imageaudit.sor.domain.util.IdGenerator;

/**
 * @author hf_cherish
 * @date 4/9/18
 */
public class Image {
    private String id;
    private String data;
    private String name;
    private String desc;

    private Image(){}

    public Image(String data, String name) {
        this.data = data;
        this.name = name;
        this.id = IdGenerator.next();
    }

    public Image setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getId() {
        return id;
    }
}

package com.tw.imageaudit.sor.api;

import com.tw.imageaudit.sor.ApiTest;
import com.tw.imageaudit.sor.domain.Image;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * @author hf_cherish
 * @date 4/9/18
 */
public class ImagesApiTest extends ApiTest{
    @Test
    public void should_201_save_image_right() {
        given()
                .contentType(ContentType.JSON)
                .body(new Image("imagedata", "imagename").setDesc("imagedesc"))

                .when()
                .post(imagesUrl())

                .then()
                .statusCode(201);
    }

    private String imagesUrl() {
        return "/images";
    }
}
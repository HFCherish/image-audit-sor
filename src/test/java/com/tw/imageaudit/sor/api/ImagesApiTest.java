package com.tw.imageaudit.sor.api;

import com.tw.imageaudit.sor.ApiTest;
import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.text.MatchesPattern.matchesPattern;

/**
 * @author hf_cherish
 * @date 4/9/18
 */
public class ImagesApiTest extends ApiTest{
    @Test
    public void should_201_save_image_right() {
        given()
                .contentType(ContentType.JSON)
                .body(new HashMap() {{
                    put("data", "imagedata");
                    put("name", "imagename");
                    put("desc", "imagedesc");
                }})

                .when()
                .post(imagesUrl())

                .then()
                .statusCode(201)
                .header("Location", matchesPattern("^/images/.*$"));
    }

    private String imagesUrl() {
        return "/images";
    }
}
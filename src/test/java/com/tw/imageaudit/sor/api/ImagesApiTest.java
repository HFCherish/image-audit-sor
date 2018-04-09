package com.tw.imageaudit.sor.api;

import com.tw.imageaudit.sor.ApiTest;
import com.tw.imageaudit.sor.domain.ImageRepo;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.text.MatchesPattern.matchesPattern;
import static org.junit.Assert.assertThat;

/**
 * @author hf_cherish
 * @date 4/9/18
 */
public class ImagesApiTest extends ApiTest {
    @Autowired
    ImageRepo imageRepo;

    @Test
    public void should_201_save_image_right() {
        String location = given()
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
                .header("Location", matchesPattern("^/images/.*$"))

                .extract()
                .header("Location")
                .toString();

        Matcher matcher = Pattern.compile("^/images/(.*)$").matcher(location);
        while (matcher.find()) {
            String id = matcher.group(1);
            assertThat(imageRepo.findById(id).isPresent(), is(true));
            imageRepo.deleteById(id);
        }

    }

    private String imagesUrl() {
        return "/images";
    }
}
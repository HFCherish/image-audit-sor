package com.tw.imageaudit.sor.api;

import com.tw.imageaudit.sor.ApiTest;
import com.tw.imageaudit.sor.domain.ImageRepo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
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
    public static final String LOCATION = "Location";
    @Autowired
    ImageRepo imageRepo;

    @Test
    public void should_201_save_image_right() {
        String location = createImage()
                .statusCode(201)
                .header(LOCATION, matchesPattern("^/images/.*$"))

                .extract()
                .header(LOCATION)
                .toString();

        String id = idFromLocation(location);
        assertThat(imageRepo.findById(id).isPresent(), is(true));
        imageRepo.deleteById(id);

    }

    private String idFromLocation(String location) {
        Matcher matcher = Pattern.compile("^/images/(.*)$").matcher(location);
        String id = "";
        while (matcher.find()) {
            id = matcher.group(1);
        }
        return id;
    }

    private ValidatableResponse createImage() {
        return given()
                .contentType(ContentType.JSON)
                .body(new HashMap() {{
                    put("data", "imagedata");
                    put("name", "imagename");
                    put("desc", "imagedesc");
                }})

                .when()
                .post(imagesUrl())

                .then();
    }

    @Test
    public void should_201_save_image_approval() {
        String location = createImage().extract().header(LOCATION).toString();
        String imageId = idFromLocation(location);

        given()
                .contentType(ContentType.JSON)

                .when()
                .post(imagesUrl() + "/" + imageId + "/approval")

                .then()
                .statusCode(201)
                .header(LOCATION, is(location));

        imageRepo.deleteById(imageId);
    }

    private String imagesUrl() {
        return "/images";
    }
}
package qaguru.restapi;

import org.junit.jupiter.api.Test;
import qaguru.restapi.lombok.User;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static qaguru.restapi.Specs.request;
import static qaguru.restapi.Specs.responseSpec;

public class RegressTests {

    @Test
    void checkUserWithSpec() {
         given()
                 .spec(request)
         .when()
                 .get("/unknown")
         .then()
                 .spec(responseSpec)
                 .log().body();

    }

    @Test
    void testUserWithLombok() {
        User data =  given()
                            .spec(request)
                            .when()
                            .get("/unknown")
                            .then()
                            .spec(responseSpec)
                            .log().body()
                            .extract().as(User.class);
        assertEquals(1, data.getData().get(0).getId());
    }

    @Test
    void testUserWithGroovy() {
        given()
                .spec(request)
                .when()
                .get("/unknown")
                .then()
                .spec(responseSpec)
                .body("data.findAll{it.name}.name.flatten()", hasItem("tigerlily"))
                .body("data.findAll{it.year}.year.flatten()", hasItem(2003))
                .body("data.findAll{it.pantone_value}.pantone_value.flatten()", hasItem("14-4811"));


    }
}

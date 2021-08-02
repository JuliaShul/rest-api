
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.core.Is.is;
import static io.restassured.RestAssured.*;

public class RestApiTest {

    @Test
    void checkFirstName() {
        get("https://reqres.in/api/users/2")
                .then()
                .body("data.first_name", is("Janet"));
    }

    @Test
    void checkPostName() {
        String response =
                given()
                        .contentType(JSON)
                        .body("{\"name\": \"morpheus\","+
                                "\"job\": \"leader\"}")
                        .when()
                        .post("https://reqres.in/api/users")
                        .then()
                        .statusCode(201)
                        .extract().path("name");
        System.out.println(response);
    }

    @Test
    void checkToken() {
        String response =
                given()
                        .contentType(JSON)
                        .body("{\"email\": \"123m@reqres.in\"," +
                                "\"password\": \"temp\"}")
                        .when()
                        .post("https://reqres.in/api/register")
                        .then()
                        .statusCode(400)
                        .extract().path("token");
        StringUtils.isNoneEmpty(response);
    }

    @Test
    void checkDeleteUser() {
        String response =
                given()
                        .contentType(JSON)
                        .body("{\"name\": \"morpheus\"," + "\"job\": \"leader\"}")
                        .when()
                        .post("https://reqres.in/api/users/2")
                        .then()
                        .statusCode(201)
                        .extract().path("id");

        delete("https://reqres.in/api/users/" + response)
                .then()
                .statusCode(204);
    }

    @Test
    void registerUnsuccessful() {
        given().contentType(JSON)
                .body("{\"email\": \"123@mail.ru\"}")
                .when().post("https://reqres.in/api/register")
                .then().statusCode(400)
                .body("error", is("Missing password"));
    }
}

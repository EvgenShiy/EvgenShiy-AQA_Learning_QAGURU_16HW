import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class CreatesUserTests extends TestBase {

    @Test
    void unsuccessfulRegistration400Test() {
        String authData = "{\"username\": \"Jane Air\", \"email\": \"Jane@Air.com\", \"password\": \"111\"}";

        given()
                .contentType("application/json")
                .body(authData)
                .log().uri()

                .when()
                .post("/register")

                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Note: Only defined users succeed registration"));
    }
}
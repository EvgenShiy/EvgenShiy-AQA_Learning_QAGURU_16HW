import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteUserTests extends TestBase {

    @Test
    void checkSuccessfulDeleteUserById() {
        given()
                .log().uri()

                .when()
                .delete("/users/{id}", 1)

                .then()
                .log().status()
                .log().body()
                .statusCode(204);
    }
}

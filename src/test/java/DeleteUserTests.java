import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteUserTests {

    @Test
    void checkSuccessfulDeleteUserById() {
        given()
                .log().uri()

                .when()
                .delete("https://reqres.in/api/users/{id}", 1)

                .then()
                .log().status()
                .log().body()
                .statusCode(204);
    }
}

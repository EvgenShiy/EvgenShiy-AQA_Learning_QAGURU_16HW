import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteUserTests extends TestBase {

    @Test
    @DisplayName("Проверка успешного удаления юзера по Id")
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

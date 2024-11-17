import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UpdatesUserTests extends  TestBase{
    @Test
    void checkUpdatedAtIsNotEmpty() {
        given()
                .log().uri()

        .when()
                .put("/users/{id}", 1)

        .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("updatedAt", notNullValue())  // Проверка, что поле updatedAt не null
                .body("updatedAt", not(emptyOrNullString()));  // Проверка, что поле updatedAt не пустая строка
    }
}

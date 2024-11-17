import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetUsersListTests extends TestBase {

    @Test
    @DisplayName("Проверка отображения 3х объектов на 1-ой странице")
    void checkSuccessListWith3UsersPer1StPage() {
        given()
                .queryParam("page", 1)
                .queryParam("per_page", 3)
                .log().uri()

        .when()
                .get("/users")

        .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("page", is(1))
                .body("per_page", is(3))
                .body("data", hasSize(3));
    }

    @Test
    @DisplayName("Проверка отображения одного объекта на 2-ой странице")
    void checkSuccessListWith1UsersPer2NdPage() {
        given()
                .queryParam("page", 2)
                .queryParam("per_page", 1)
        .when()

                .get("/users")
        .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("page", is(2))
                .body("per_page", is(1))
                .body("data", hasSize(1))
                .body("data[0].id", is(2));
    }

    @Test
    @DisplayName("Проверить, что возвращаемые поля о юзере не пустые")
    void checkFieldsAreNotEmpty() {
        given()
                .queryParam("page", 2)
                .queryParam("per_page", 1)
        .when()
                .get("/users")
        .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.id", everyItem(notNullValue()))  // Проверка, что все id не null
                .body("data.email", everyItem(not(emptyOrNullString())))  // Проверка, что все email не пустые
                .body("data.first_name", everyItem(not(emptyOrNullString())))  // Проверка, что все first_name не пустые
                .body("data.last_name", everyItem(not(emptyOrNullString())))  // Проверка, что все last_name не пустые
                .body("data.avatar", everyItem(not(emptyOrNullString()))); // Проверка, что все avatar не пустые
    }
}

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.*;

public class GetUsersListTests {

    @Test
    void checkSuccessListWith3UsersPer1StPage() {
        get("https://reqres.in/api/users?page=1&per_page=3")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("page", is(1))
                .body("per_page", is(3))
                .body("data", hasSize(3));
    }

    @Test
    void checkSuccessListWith1UsersPer2NdPage() {
        get("https://reqres.in/api/users?page=2&per_page=1")
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
    void checkFieldsAreNotEmpty() {
        get("https://reqres.in/api/users?page=2&per_page=1")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.id", everyItem(notNullValue()))  // Проверка, что все id не null
                .body("data.email", everyItem(not(emptyOrNullString())))  // Проверка, что все email не пустые
                .body("data.first_name", everyItem(not(emptyOrNullString())))  // Проверка, что все first_name не пустые
                .body("data.last_name", everyItem(not(emptyOrNullString())))  // Проверка, что все last_name не пустые
                .body("data.avatar", everyItem(not(emptyOrNullString())))  // Проверка, что все avatar не пустые
        ;
    }
}

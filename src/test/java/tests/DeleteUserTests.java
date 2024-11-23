package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.UserSpec.requestSpec;
import static specs.UserSpec.successDeleteUserByIdSpec;

public class DeleteUserTests extends TestBase {

    @Test
    @DisplayName("Проверка успешного удаления юзера по Id")
    void checkSuccessfulDeleteUserById() {
        step("Отправить DELETE запрос на удаление юзера по ID", ()->
        given(requestSpec)

                .when()
                .delete("/users/{id}", 1)

                .then()
                .spec(successDeleteUserByIdSpec));
    }
}

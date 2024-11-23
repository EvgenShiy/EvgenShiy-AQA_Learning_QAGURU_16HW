package tests;

import models.UpdateResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static specs.UserSpec.requestSpec;
import static specs.UserSpec.successUpdateUserByIdSpec;

public class UpdatesUserTests extends  TestBase{

    @Test
    @Tag("ReqResAPI")
    @DisplayName("Проверить, что после обновления юзера поле UpdatedAt не пустое")
    void checkUpdatedAtIsNotEmpty() {
        UpdateResponseModel response = step("Отправить PUT-запрос на обновление юзера по id", () ->
                given(requestSpec)
                        .when()
                        .put("/users/{id}", 1)

                        .then()
                        .spec(successUpdateUserByIdSpec)
                        .extract().as(UpdateResponseModel.class));

        step("Проверить, что возвращаемое поле updatedAt не пустое", () -> {
            assertNotNull(response.getUpdatedAt(), "Поле updatedAt не должно быть null");
            assertFalse(response.getUpdatedAt().isEmpty(), "Поле updatedAt не должно быть пустой строкой");

        });
    }
}

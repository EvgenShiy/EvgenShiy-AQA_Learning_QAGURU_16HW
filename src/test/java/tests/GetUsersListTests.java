package tests;

import models.UserInfoResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import static specs.UserSpec.getUserInfoPerPage200;
import static specs.UserSpec.requestSpec;

public class GetUsersListTests extends TestBase {

    @Test
    @DisplayName("Проверка отображения 3х юзеров на 1-ой странице")
    void checkSuccessListWith3UsersPer1StPage() {

        UserInfoResponseModel response = step("Отправить GET запрос на получение информации о 3-х юзерах на 3-ей странице", ()->
        given(requestSpec)
                .queryParam("page", 1)
                .queryParam("per_page", 3)
        .when()
                .get("/users")
        .then()
                .spec(getUserInfoPerPage200)
                .extract().as(UserInfoResponseModel.class));

        step("Проверить, что открылась нужная страница, что на странице есть инфо о нужном количестве юзеров, и что массив содержит нужное количество элементов", () -> {
                assertEquals(response.getPage(), 1);
                assertEquals(response.getPer_page(), 3);
                assertEquals(response.getData().size(), 3);
        });
    }

    @Test
    @DisplayName("Проверка отображения одного юзера на 2-ой странице")
    void checkSuccessListWith1UsersPer2NdPage() {

        UserInfoResponseModel response = step("Отправить GET запрос на получение информации об одном юзере на 2-ой странице", ()->
        given(requestSpec)
                .queryParam("page", 2)
                .queryParam("per_page", 1)
        .when()

                .get("/users")
        .then()
                .spec(getUserInfoPerPage200)
                .extract().as(UserInfoResponseModel.class));

        step("Проверить, что открылась нужная страница, что на странице есть инфо о нужном количестве юзеров, и Id юзера соответствует ожидаемому результату", () -> {
            assertEquals(response.getPage(), 2);
            assertEquals(response.getPer_page(), 1);
            assertEquals(response.getData().size(), 1);
            assertEquals(response.getData().get(0).getId(), 2);
        });
    }

    @Test
    @DisplayName("Проверить, что возвращаемые поля о юзере не пустые")
    void checkFieldsAreNotEmpty() {
        UserInfoResponseModel response = step("Отправить GET запрос на получение данных одного юзера на 2-ой странице", () ->
                given(requestSpec)
                        .queryParam("page", 2)
                        .queryParam("per_page", 1)
                        .when()
                        .get("/users")
                        .then()
                        .spec(getUserInfoPerPage200)
                        .extract().as(UserInfoResponseModel.class));

        step("Проверить, что все данные о юзере заполнены", () -> {
            assertNotNull(response.getData());
            response.getData().forEach(user -> {
                assertNotNull(user.getId());
                assertNotNull(user.getEmail());
                assertNotNull(user.getFirst_name());
                assertNotNull(user.getLast_name());
                assertNotNull(user.getAvatar());
            });
        });
    }
}
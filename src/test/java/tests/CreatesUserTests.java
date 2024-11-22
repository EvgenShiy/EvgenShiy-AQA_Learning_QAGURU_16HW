package tests;

import models.RegNewUserBodyModel;
import models.RegNewUserResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.CreatesUserSpec.*;

public class CreatesUserTests extends TestBase {

    @Test
    @DisplayName("Проверка неуспешной регистрации юзера")
    void unsuccessfulRegistration400Test() {
        RegNewUserBodyModel authData = new RegNewUserBodyModel();
        authData.setUsername("Jane Air");
        authData.setEmail("Jane@Air.com");
        authData.setPassword("111");

        RegNewUserResponseModel response = step("Сделать запрос", ()->
         given(unSuccessRegistrationRequestSpec)
                .body(authData)

                .when()
                .post("/register")

                .then()
                .spec(unSuccessRegistrationResponseSpec)
                .extract().as(RegNewUserResponseModel.class));

        step("Проверить ответ", ()->
        assertEquals("Note: Only defined users succeed registration", response.getError()));
    }
}
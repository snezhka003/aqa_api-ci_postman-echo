package ru.netology.api_ci.postman_echo;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoApiTest {
    @Test
    public void shouldGetResponseFromPostmanEchoWithCirillic() {
        String testValue = "тестовый текст";

        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body(testValue) // отправляемые данные (заголовки и query можно выставлять аналогично)
                .contentType("text/plain; charset=UTF-8")
                // Выполняемые действия
                .when()
                    .post("/post")
                // Проверки
                .then()
                    .statusCode(200)
                    .body("data", equalTo(testValue))
        ;
    }

    @Test
    public void shouldGetResponseFromPostmanEchoWithLatin() {
        String testValue = "text for test";

        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body(testValue) // отправляемые данные (заголовки и query можно выставлять аналогично)
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo(testValue))
        ;
    }
}

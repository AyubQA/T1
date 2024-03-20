package api;

import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static api.data.URLs.products;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetProductsTest {

    //Todo: Добавить тестов

    @Test
    @DisplayName("Get all products")
    public void getAllProductsTest() {
        given()
                .log().uri()
                .when()
                .get(products)
                .then()
                .log().status()
                .log().body()
                .statusCode(200);

        given()
                .log().uri()
                .when()
                .get(products)
                .then()
                .body("$", everyItem(allOf(
                        hasKey("category"),
                        hasKey("discount"),
                        hasKey("id"),
                        hasKey("name"),
                        hasKey("price")
                )));

        //Негативные проверки
        // Негативная проверка: проверка наличия несуществующего эндпоинта
        given()
                .log().uri()
                .when()
                .get(products + "99999")
                .then()
                .log().status()
                .statusCode(404);

        // Негативная проверка: проверка ответа на запрос с неправильным методом
        given()
                .log().uri()
                .when()
                .post(products)
                .then()
                .log().status()
                .statusCode(405);
    }
}
package api;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static api.data.URLs.RandomIdProducts;
import static api.data.URLs.products;
import static io.restassured.RestAssured.given;

public class DeleteInfoAboutProductTest {
    @Test
    @DisplayName("Delete information about specific product")
    public void deleteInfoAboutProductTest() {
        given()
                .log().uri()
                .log().body()
                .contentType(ContentType.JSON)
                .when()
                .delete(RandomIdProducts)  //Понимаю, что лучше подготовить тестовые данные, но эндпоинт не работает.
                .then()
                .log().status()
                .log().body()
                .statusCode(200);

        //Удаление информации с несуществующим id продукта
        given()
                .log().uri()
                .log().body()
                .contentType(ContentType.JSON)
                .when()
                .delete(products + "/999999")
                .then()
                .log().status()
                .log().body()
                .statusCode(404);

        //Удаление информации с некорректным id продукта
        given()
                .log().uri()
                .log().body()
                .contentType(ContentType.JSON)
                .when()
                .delete(products + "/abc")
                .then()
                .log().status()
                .log().body()
                .statusCode(400);

        //Удаление информации без id продукта
        given()
                .log().uri()
                .log().body()
                .contentType(ContentType.JSON)
                .when()
                .delete(products)
                .then()
                .log().status()
                .log().body()
                .statusCode(400);
    }
}

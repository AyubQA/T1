package api;

import api.data.RandomData;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static api.data.URLs.products;
import static io.restassured.RestAssured.given;

public class UpdateInfoAboutProductTest {
    @Test
    @DisplayName("Update information about specific product")
    public void updateInfoAboutProductTest() {
        given()
                .log().uri()
                .log().body()
                .body(RandomData.randomProduct)
                .contentType(ContentType.JSON)
                .when()
                .put(products + "/1")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);

        //Негативные проверки. Удаление с несуществующим id продукта
        given()
                .log().uri()
                .log().body()
                .body(RandomData.randomProduct)
                .contentType(ContentType.JSON)
                .when()
                .put(products + "/99999")
                .then()
                .log().status()
                .log().body()
                .statusCode(404);

        //Удаление с отрицательным id продукта
        given()
                .log().uri()
                .log().body()
                .contentType(ContentType.JSON)
                .when()
                .delete(products + "/-1")
                .then()
                .log().status()
                .log().body()
                .statusCode(500); //Возможен и статус 404, но проверить не могу.
    }

}

package api;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static api.data.URLs.RandomIdProducts;
import static api.data.URLs.products;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetInfoAboutProductTest {

    @Test
    @DisplayName("Get information about specific product")
    public void getInfoAboutProductTest() {
        given()
                .log().uri()
                .log().body()
                .contentType(ContentType.JSON)
                .when()
                .get(RandomIdProducts)
                .then()
                .log().status()
                .log().body()
                .statusCode(200);

        //Получение информации с Id продукта
        given()
                .log().uri()
                .log().body()
                .contentType(ContentType.JSON)
                .when()
                .get(RandomIdProducts)
                .then()
                .body("$", everyItem(allOf(
                        hasKey("category"),
                        hasKey("discount"),
                        hasKey("id"),
                        hasKey("name"),
                        hasKey("price")
                )));

        //Получение информации без Id продукта
        given()
                .log().uri()
                .log().body()
                .contentType(ContentType.JSON)
                .when()
                .get(products)
                .then()
                .log().status()
                .log().body()
                .statusCode(400);
    }

}

package api;

import api.data.RandomData;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static api.data.RandomData.invalidJsonProduct;
import static api.data.URLs.products;
import static io.restassured.RestAssured.given;


public class AddNewProductTest {
    @Test
    @DisplayName("Add new product")
    public void addNewProductTest() {
        given()
                .log().uri()
                .log().body()
                .body(RandomData.randomProduct)
                .contentType(ContentType.JSON)
                .when()
                .post(products)
                .then()
                .log().status()
                .log().body()
                .statusCode(201);  // Error: METHOD NOT ALLOWED

        //Негативные проверки
        given()
                .log().uri()
                .log().body()
                .body("")                         // Пустое тело запроса
                .contentType(ContentType.JSON)
                .when()
                .post(products)
                .then()
                .log().status()
                .log().body()
                .statusCode(405);

        given()
                .log().uri()
                .log().body()
                .body(invalidJsonProduct)         // Данные в неверном формате
                .contentType(ContentType.JSON)
                .when()
                .post(products)
                .then()
                .log().status()
                .log().body()
                .statusCode(405);
    }
}

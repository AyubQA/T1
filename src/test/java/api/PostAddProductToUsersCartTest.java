package api;

import api.data.Authorization;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static api.data.RandomData.BodyForAddProductForCart;
import static api.data.URLs.cart;
import static io.restassured.RestAssured.given;

public class PostAddProductToUsersCartTest {

    Authorization authExample = Authorization.getInstance();
    String authToken = authExample.getAuthToken();

    @Test
    @DisplayName("Add a product to the users shopping cart")
    public void postAddProductToUsersCart() {
        given()
                .log().uri()
                .log().body()
                .header("Authorization", "Bearer " + authToken)
                .contentType(ContentType.JSON)
                .body(BodyForAddProductForCart)
                .when()
                .post(cart)
                .then()
                .log().status()
                .log().body()
                .statusCode(201);

        //Проверка граничных значений.
        given()
                .log().uri()
                .log().body()
                .header("Authorization", "Bearer " + authToken)
                .contentType(ContentType.JSON)
                .body("{ \"product_id\": 1, \"quantity\": 99999999999999 }")
                .when()
                .post(cart)
                .then()
                .log().status()
                .log().body()
                .statusCode(201);

        //Негативные проверки. Обновление без токена авторизации
        given()
                .log().uri()
                .log().body()
                .contentType(ContentType.JSON)
                .body(BodyForAddProductForCart)
                .when()
                .post(cart)
                .then()
                .log().status()
                .log().body()
                .statusCode(401);

        //Обновление c некорректным id продукта
        given()
                .log().uri()
                .log().body()
                .header("Authorization", "Bearer " + authToken)
                .contentType(ContentType.JSON)
                .body("{ \"product_id\": 0, \"quantity\": 0 }")
                .when()
                .post(cart)
                .then()
                .log().status()
                .log().body()
                .statusCode(404);

        //Попытка добавить продукт с отсутствующим полем в JSON
        given()
                .log().uri()
                .log().body()
                .header("Authorization", "Bearer " + authToken)
                .contentType(ContentType.JSON)
                .body("{ \"product_id\": 1 }")
                .when()
                .post(cart)
                .then()
                .log().status()
                .log().body()
                .statusCode(500);  //В swagger нельзя отправить запрос без строки quantity,
        // но в данном случае ответ приходит 200.
    }
}

package api;

import api.data.Authorization;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static api.data.URLs.cart;
import static io.restassured.RestAssured.given;

public class GetUsersCartTest {

    Authorization authExample = Authorization.getInstance();
    String authToken = authExample.getAuthToken();

    @Test
    @DisplayName("Get users shopping cart")
    public void getUsersCartTest() {
        given()
                .log().uri()
                .log().body()
                .header("Authorization", "Bearer " + authToken)
                .contentType(ContentType.JSON)
                .when()
                .get(cart)
                .then()
                .log().status()
                .log().body()
                .statusCode(200);


        //Получение информации без токена авторизации
        given()
                .log().uri()
                .log().body()
                .contentType(ContentType.JSON)
                .when()
                .get(cart)
                .then()
                .log().status()
                .log().body()
                .statusCode(403);
    }
}

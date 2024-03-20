package api;

import api.data.Authorization;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static api.data.URLs.RandomIdCart;
import static api.data.URLs.cart;
import static io.restassured.RestAssured.given;


public class DeleteProductFromUsersCartTest {

    Authorization authExample = Authorization.getInstance();
    String authToken = authExample.getAuthToken();

    @Test
    @DisplayName("Remove a product from the users shopping cart")
    public void deleteProductFromUsersCart() {
        given()
                .log().uri()
                .log().body()
                .header("Authorization", "Bearer " + authToken)
                .contentType(ContentType.JSON)
                .when()
                .delete(RandomIdCart)
                .then()
                .log().status()
                .log().body()
                .statusCode(200);

        //Негативные проверки. Удаление без токена авторизации
        given()
                .log().uri()
                .log().body()
                .contentType(ContentType.JSON)
                .when()
                .delete(RandomIdCart)
                .then()
                .log().status()
                .log().body()
                .statusCode(403);

        //Удаление с несуществующим id продукта
        given()
                .log().uri()
                .log().body()
                .header("Authorization", "Bearer " + authToken)
                .contentType(ContentType.JSON)
                .when()
                .delete(cart + "/9999")
                .then()
                .log().status()
                .log().body()
                .statusCode(404);

        //Удаление с отрицательным id продукта
        given()
                .log().uri()
                .log().body()
                .header("Authorization", "Bearer " + authToken)
                .contentType(ContentType.JSON)
                .when()
                .delete(cart + "/-1")
                .then()
                .log().status()
                .log().body()
                .statusCode(500);
    }

}

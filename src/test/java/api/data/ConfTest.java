package api.data;

import io.restassured.http.ContentType;

import static api.data.URLs.products;
import static io.restassured.RestAssured.given;

public class ConfTest {
    public static void addProduct(Product requestBody, int expectedStatusCode) {
        given()
                .log().uri()
                .log().body()
                .body(requestBody)
                .contentType(ContentType.JSON)
                .when()
                .post(products)
                .then()
                .log().status()
                .log().body()
                .statusCode(expectedStatusCode);
    }

    public static void executePostRequest(String url, Object requestBody, int expectedStatusCode) {
        given()
                .log().uri()
                .log().body()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(url)
                .then()
                .assertThat()
                .log().status()
                .log().body()
                .statusCode(expectedStatusCode);
    }

    public static void executeDeleteRequest(String url, int expectedStatusCode) {
        given()
                .log().uri()
                .log().body()
                .contentType(ContentType.JSON)
                .when()
                .delete(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(expectedStatusCode);
    }
}
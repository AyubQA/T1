package api;

import api.data.Authorization;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static api.data.JsonData.*;
import static api.data.URLs.*;
import static io.restassured.RestAssured.given;

public class MyPostTest {
    Authorization authExample = Authorization.getInstance();
    String authToken = authExample.getAuthToken();

    @Test
    public void TestRegistration() {
        given()
                .log().uri()
                .log().body()
                .contentType(ContentType.JSON)
                .body(BodyForRegistration)
                .post(register)
                .then()
                .assertThat()
                .log().status()
                .log().body()
                .statusCode(201);
    }

    @Test
    public void TestLogin() {
        given()
                .log().uri()
                .log().body()
                .contentType(ContentType.JSON)
                .body(TestLogin)
                .post(login)
                .then()
                .assertThat()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    @DisplayName("Get all product")
    public void TestGetAllProducts() {
        given()
                .log().uri()
                .when()
                .get(products)
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    @DisplayName("Add new product")
    public void TestAddNewProduct() {
        given()
                .log().uri()
                .log().body()
                .body(BodyForAddProduct)
                .contentType(ContentType.JSON)
                .when()
                .post(products)
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    @DisplayName("Get information about specific product")
    public void TestGetInfoAboutProduct() {
        given()
                .log().uri()
                .log().body()
                .contentType(ContentType.JSON)
                .when()
                .get(products + "/1")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    @DisplayName("Update information about specific product")
    public void TestUpdateInfoAboutProduct() {
        given()
                .log().uri()
                .log().body()
                .body(BodyForUpdateProduct)
                .contentType(ContentType.JSON)
                .when()
                .put(products + "/1")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    @DisplayName("Delete information about specific product")
    public void TestDeleteInfoAboutProduct() {
        given()
                .log().uri()
                .log().body()
                .contentType(ContentType.JSON)
                .when()
                .delete(products + "/8")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    @DisplayName("Get users shopping cart")
    public void TestGetUsersCart() {
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
    }

    @Test
    @DisplayName("Add a product to the users shopping cart")
    public void PostAddProductToUsersCart() {
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
    }

    @Test
    @DisplayName("Remove a product from the users shopping cart")
    public void DeleteProductFromUsersCart() {
        given()
                .log().uri()
                .log().body()
                .header("Authorization", "Bearer " + authToken)
                .contentType(ContentType.JSON)
                .when()
                .delete(cart + "/1")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }
}
package api;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static api.data.JsonData.*;
import static api.data.URLs.*;
import static io.restassured.RestAssured.given;

public class MyPostTest {


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
                .queryParam("Product_Id", 1)
                .contentType(ContentType.JSON)
                .when()
                .get(products)
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
                .queryParam("Product_Id", 1)
                .contentType(ContentType.JSON)
                .when()
                .put(products)
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
                .queryParam("Product_Id", 8)
                .contentType(ContentType.JSON)
                .when()
                .delete(products)
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }
}
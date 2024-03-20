package api;

import api.data.Authorization;
import api.data.User;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static api.data.RandomData.BodyForRegistration;
import static api.data.URLs.loginURL;
import static api.data.URLs.register;
import static io.restassured.RestAssured.given;

public class AuthorizationTest {

    @Test
    public void registrationTest() {
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
    public void testLogin() {
        given()
                .log().uri()
                .log().body()
                .contentType(ContentType.JSON)
                .body(new User(Authorization.testUserLogin, Authorization.testUserPassword))
                .post(loginURL)
                .then()
                .assertThat()
                .log().status()
                .log().body()
                .statusCode(200);
    }


}
package api.data;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static api.data.JsonData.TestLogin;
import static api.data.URLs.login;


public class Authorization {
    private static Authorization instance;
    private String authToken;

    private Authorization() {
        // Private constructor to prevent instantiation
    }

    public static Authorization getInstance() {
        if (instance == null) {
            instance = new Authorization();
            instance.retrieveAuthToken();
        }
        return instance;
    }

    private void retrieveAuthToken() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(TestLogin)
                .when()
                .post(login);

        if (response.getStatusCode() == 200) {
            authToken = response.jsonPath().getString("access_token");
            System.out.println("access_token: " + authToken);
        } else {
            System.out.println("Failed to retrieve access token");
        }
    }

    public String getAuthToken() {
        return authToken;
    }
}

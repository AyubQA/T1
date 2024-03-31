package api;

import api.data.Authorization;
import api.data.User;
import org.testng.annotations.Test;

import static api.data.ConfTest.executePostRequest;
import static api.data.RandomData.BodyForRegistration;
import static api.data.URLs.loginURL;
import static api.data.URLs.register;


public class AuthorizationTest {

    @Test
    public void registrationTest() {
        executePostRequest(register, BodyForRegistration, 201);
    }

    @Test
    public void testLogin() {
        executePostRequest(loginURL, new User(Authorization.testUserLogin, Authorization.testUserPassword), 200);
    }
}
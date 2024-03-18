package api.data;

import java.util.Random;

public class JsonData {

    public static final String USERNAME_PREFIX = "user";
    public static final String PASSWORD_PREFIX = "pass";

    public static final String TestLogin = "{\n" +
            " \"username\": \"string\",\n" +
            " \"password\": \"string\"\n" +
            "}";
    public static final String BodyForAddProduct = "{\n" +
            "  \"name\": \"New Product\",\n" +
            "  \"category\": \"Electronics\",\n" +
            "  \"price\": 12.99,\n" +
            "  \"discount\": 5\n" +
            "}";
    private static final Random random = new Random();
    public static final String USERNAME = getRandomUsername();
    public static final String BodyForUpdateProduct = "{\n" +
            "  \"name\": \"" + USERNAME + "\",\n" +
            "  \"category\": \"Electronics\",\n" +
            "  \"price\": 15.99,\n" +
            "  \"discount\": 8\n" +
            "}";
    public static final String PASSWORD = getRandomPassword();
    public static final String BodyForRegistration = "{\n" +
            " \"username\": \"" + USERNAME + "\",\n" +
            " \"password\": \"" + PASSWORD + "\"\n" +
            "}";

    public static String getRandomUsername() {
        return USERNAME_PREFIX + random.nextInt(1000);
    }

    public static String getRandomPassword() {
        return PASSWORD_PREFIX + random.nextInt(1000);
    }

    public static String BodyForAddProductForCart = "{\n" +
            " \"product_id\": 1,\n" +
            " \"quantity\": 2\n" +
            "}";
}



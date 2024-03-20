package api.data;

import java.util.Random;

public class RandomData {

    public static final String USERNAME_PREFIX = "user";
    public static final String PASSWORD_PREFIX = "pass";
    public static final String TestData = "Test";

    private static final Random random = new Random();
    public static final String BodyForRegistration = "{\n" +
            " \"username\": \"" + getRandomUsername() + "\",\n" +
            " \"password\": \"" + getRandomPassword() + "\"\n" +
            "}";
    //JSON с рандомными значениями для эндпоинта products
    public static Product randomProduct = new Product("Test",
            generateRandomInt(),
            generateRandomInt(),
            randomData(),
            generateRandomDouble());
    //JSON с рандомными и некоректными значениями для эндпоинта products.
    public static Product invalidJsonProduct = new Product(generateRandomInt(),
            generateRandomInt(),
            generateRandomInt(),
            generateRandomInt(),
            generateRandomDouble());

    public static int generateRandomInt() {
        return random.nextInt(10);
    }

    public static double generateRandomDouble() {
        return random.nextDouble();
    }

    public static String BodyForAddProductForCart = "{\n" +
            " \"product_id\": 1,\n" +
            " \"quantity\": 2\n" +
            "}";

    public static String getRandomUsername() {
        return USERNAME_PREFIX + random.nextInt(100);
    }

    public static String getRandomPassword() {
        return PASSWORD_PREFIX + random.nextInt(100);
    }

    public static String randomData() {
        return TestData + random.nextInt(100);
    }


}



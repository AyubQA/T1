package api.data;

import static api.data.RandomData.generateRandomInt;

public class URLs {
    public static String register = "http://9b142cdd34e.vps.myjino.ru:49268/register";
    public static String loginURL = "http://9b142cdd34e.vps.myjino.ru:49268/login";
    public static String products = "http://9b142cdd34e.vps.myjino.ru:49268/products";
    public static String RandomIdProducts = "http://9b142cdd34e.vps.myjino.ru:49268/products" + "/" + generateRandomInt();
    public static String cart = "http://9b142cdd34e.vps.myjino.ru:49268/cart";
    public static String RandomIdCart = "http://9b142cdd34e.vps.myjino.ru:49268/cart" + "/" + generateRandomInt();
}

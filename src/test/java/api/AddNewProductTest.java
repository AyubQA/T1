package api;

import api.data.RandomData;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static api.data.ConfTest.addProduct;
import static api.data.RandomData.invalidJsonProduct;

public class AddNewProductTest {
    @Test
    @DisplayName("Add new product")
    public void addNewProductTest() {
        addProduct(RandomData.randomProduct, 201);
    }

    @Test
    @DisplayName("Add new Product. No body test")
    public void addNewProductWithNoBodyTest() {
        addProduct(null, 405);
    }

    @Test
    @DisplayName("Add new product.Invalid JSON")
    public void addNewProductWithInvalidBodyTest() {
        addProduct(invalidJsonProduct, 405);
    }

}

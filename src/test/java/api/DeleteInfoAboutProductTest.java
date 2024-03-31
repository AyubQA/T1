package api;

import org.testng.annotations.Test;

import static api.data.ConfTest.executeDeleteRequest;
import static api.data.URLs.RandomIdProducts;
import static api.data.URLs.products;

public class DeleteInfoAboutProductTest {
    @Test
    public void deleteInfoAboutProductTest() {
        executeDeleteRequest(RandomIdProducts, 200);
    }

    @Test
    public void deleteInfoAboutProductWithHugeIdTest() {
        executeDeleteRequest(products + "/999999", 404);
    }

    @Test
    public void deleteInfoAboutProductWithInvalidIdTest() {
        executeDeleteRequest(products + "/abc", 400);
    }

    @Test
    public void deleteInfoAboutProductNoIdTest() {
        executeDeleteRequest(products, 400);
    }
}

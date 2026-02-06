package api;

import client.StoreClient;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostToAllProductsTest {
    private final StoreClient storeClient =new StoreClient();

    @Description("Attempt to post to the list of all products")
    @Test
    public void test1(){
        Allure.step("Send a POST request to /productsList");
        Response response=storeClient.postToAllProducts();
        response.then()
                .log().all()
                .statusCode(200);
        Allure.step("Parse the response and check the response code");
        String html=response.getBody().asString();
        String json=html.substring(html.indexOf("{"),html.lastIndexOf("}")+1);
        JsonPath jp=new JsonPath(json);
        Assert.assertEquals(jp.getInt("responseCode"),405);
    }
}

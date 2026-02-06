package api;

import client.StoreClient;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostToSearchEmptyTest {
    private final StoreClient storeClient =new StoreClient();

    @Description("Attempt to post to search but without a search_product parameter")
    @Test
    public void test1(){
        Allure.step("Send a POST request without a search_product parameter to /searchProduct");
        Response response=storeClient.searchEmpty();
        response.then()
                .log().all()
                .statusCode(200);
        Allure.step("Parse the response and check the response code");
        String html=response.getBody().asString();
        String json=html.substring(html.indexOf("{"),html.lastIndexOf("}")+1);
        JsonPath jp=new JsonPath(json);
        Assert.assertEquals(jp.getInt("responseCode"),400);
    }
}

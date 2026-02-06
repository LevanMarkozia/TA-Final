package api;

import client.StoreClient;
import io.qameta.allure.Description;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllBrandsTest {
    private final StoreClient storeClient =new StoreClient();

    @Description("Attempt to get the list of all brands")
    @Test
    public void test1(){
        Response response=storeClient.getAllBrands();
        response.then()
                .log().all()
                .statusCode(200);
        String html=response.getBody().asString();
        String json=html.substring(html.indexOf("{"),html.lastIndexOf("}")+1);
        JsonPath jp=new JsonPath(json);
        Assert.assertEquals(jp.getInt("responseCode"),200);
    }
}
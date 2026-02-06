package api;

import client.StoreClient;
import client.UserClient;
import io.qameta.allure.Description;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostToVerifyLoginInvalidTest {
    private final UserClient userClient =new UserClient();

    @Description("Attempt to log in using valid credentials")
    @Test
    public void test1(){
        String email="uchzuy7v86atd6v@mail.com",password="12345678";
        Response response=userClient.login(email,password);
        response.then()
                .log().all()
                .statusCode(200);
        String html=response.getBody().asString();
        String json=html.substring(html.indexOf("{"),html.lastIndexOf("}")+1);
        JsonPath jp=new JsonPath(json);
        Assert.assertEquals(jp.getInt("responseCode"),404);
    }
}

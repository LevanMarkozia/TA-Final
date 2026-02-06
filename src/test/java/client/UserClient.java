package client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.RequestSpecFactory;

import static io.restassured.RestAssured.given;

public class UserClient {
    protected RequestSpecification spec=RequestSpecFactory.defaultJsonSpec();
    public Response login(String email,String password){
        return given()
                .spec(spec)
                .contentType(ContentType.URLENC)
                .formParam("email",email)
                .formParam("password",password)
                .when()
                .post("/verifyLogin");
    }
    public Response loginWithoutEmail(String password){
        return given()
                .spec(spec)
                .contentType(ContentType.URLENC)
                .formParam("password",password)
                .when()
                .post("/verifyLogin");
    }
    public Response loginDelete(){
        return given()
                .spec(spec)
                .when()
                .delete("/verifyLogin");
    }
}

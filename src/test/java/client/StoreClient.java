package client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.RequestSpecFactory;

import static io.restassured.RestAssured.given;

public class StoreClient {
    protected RequestSpecification spec=RequestSpecFactory.defaultJsonSpec();
    public Response getAllProducts(){
        return given()
                .spec(spec)
                .when()
                .get("/productsList");
    }
    public Response postToAllProducts(){
        return given()
                .spec(spec)
                .body("")
                .when()
                .post("/productsList");
    }
    public Response getAllBrands(){
        return given()
                .spec(spec)
                .when()
                .get("/brandsList");
    }
    public Response putToAllBrands(){
        return given()
                .spec(spec)
                .body("")
                .when()
                .put("/brandsList");
    }
    public Response search(String query){
        return given()
                .spec(spec)
                .contentType(ContentType.URLENC)
                .formParam("search_product",query)
                .when()
                .post("/searchProduct");
    }
    public Response searchEmpty(){
        return given()
                .spec(spec)
                .contentType(ContentType.URLENC)
                .when()
                .post("/searchProduct");
    }
}

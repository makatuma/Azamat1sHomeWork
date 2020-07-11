package API.RestAssured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredDeserialization2 {

    @Test
    public void getRequest(){

        ReqresPojo reqresPojo =  given().header("accept", ContentType.JSON).when().request("get", "https://reqres.in/api/users/2")
                .then().statusCode(200).and().contentType((ContentType.JSON)).extract()
                .as(ReqresPojo.class);

        Assert.assertEquals("janet.weaver@reqres.in", reqresPojo.getData().getEmail());
    }



    @Test
    public void getRequest2(){

        RequestSpecification requestSpecification =  given().header("accept", ContentType.JSON);
        Response response =requestSpecification.when().request("get", "https://reqres.in/api/users/2");
        ValidatableResponse validatableResponse = response.then().statusCode(200).and().contentType((ContentType.JSON));
        ReqresPojo reqresPojo = validatableResponse.extract().as(ReqresPojo.class);
        Assert.assertEquals("janet.weaver@reqres.in", reqresPojo.getData().getEmail());
    }

}

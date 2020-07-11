package API.RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CatFactsDesrialization {

    @Before
    public void setUp(){
        RestAssured.baseURI = "http://cat-fact.herokuapp.com";
        RestAssured.basePath = "facts";
    }

//http://cat-fact.herokuapp.com/facts

    @Test
    public void getCatFacts(){

Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).when().get()

        .then().statusCode(200).and().contentType(ContentType.JSON).extract()
        .response();


        CatFactAllPojo catParsed = response.as(CatFactAllPojo.class);

        Map<String, String>  name = (Map<String, String>) catParsed.getAll().get(24).getUser().get("name");

        System.out.println(name.get("first"));
        System.out.println(name.get("last"));


    }
}

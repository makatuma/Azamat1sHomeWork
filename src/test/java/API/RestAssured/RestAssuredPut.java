package API.RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredPut {

    @Test

    public void update(){

        File updatePayLoad = new File("target/pet.json");
        given().contentType(ContentType.JSON).accept(ContentType.JSON).body(updatePayLoad)
                .when().put("https://petstore.swagger.io/v2/pet")
                .then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body("name", Matchers.is("Gresha"))
                .body("status", Matchers.is("Sold")).log().body();

    }

    @Test
    public void update2(){

        String[] arr = {"www.makatuma.com"};

        Map<String, Object> petPayLoad = new HashMap<>();
        petPayLoad.put("age", "12");
        petPayLoad.put("" +
                "name", "Lukas");
        petPayLoad.put("photoUrls",arr );
        petPayLoad.put("status", "Ha ha ha");
        petPayLoad.put("id", "13123");



        given().contentType(ContentType.JSON).accept(ContentType.JSON).body(petPayLoad)
                .when().put("https://petstore.swagger.io/v2/pet").then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
                .and().body("name", Matchers.is("Lukas"))
              .body("status", Matchers.is("Ha ha ha")).log().body();



    }

}

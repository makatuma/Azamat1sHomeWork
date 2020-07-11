package API.RestAssured;

import API.HomeWork.PetSwagger.PetPayLoad;
import API.Pojo.PetSwagger.PetPojo;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import java.util.HashMap;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CreatePet {

    //https://petstore.swagger.io/v2/pet

    private static  final String NAME = "name";
    private static  final String STATUS = "status";
    private static  final String    ID = "id";

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    @Before
    public void setUp(){

        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "v2/pet";

        requestSpecification= new RequestSpecBuilder()
                .setContentType(ContentType.JSON).setAccept(ContentType.JSON).build();
        ResponseSpecification responseSpecification=  new ResponseSpecBuilder()
                .expectStatusCode(200).expectContentType(ContentType.JSON).build();
    }

    @Test
    public void createPet(){

        File petPayLoadFIle = new File("target/pet.json");

        given().spec(requestSpecification)
        .when().post()
        .then().and().spec(responseSpecification)
        .body(NAME, Matchers.equalTo("Gresha"))
        .body(ID, Matchers.equalTo(13123));

    }
    @Test
    public void createPet2(){

        PetPojo petPojo = new PetPojo("Hach", "Sold", 3443);

        given().spec(requestSpecification).body(petPojo)
                .when().post()
                .then().and().spec(responseSpecification)
                .and().body(NAME, Matchers.is(petPojo.getName()))
        .and().body(STATUS, Matchers.is(petPojo.getStatus())).log().body();


    }

    @Test

    public void createPet3(){

        String[] arr = {"www.makatuma.com"};

        Map<String, Object> petPayLoad = new HashMap<>();
        petPayLoad.put("age", "12");
        petPayLoad.put(NAME, "Roxana");
        petPayLoad.put("photoUrls",arr );
        petPayLoad.put(STATUS, "Available");
        petPayLoad.put(ID, "322452");



        given().spec(requestSpecification)
                .when().post().then().spec(responseSpecification).and()
                .and().body(NAME, Matchers.is(petPayLoad.get("name"))).log().body();



    }


}

package API.RestAssured.RestAssuredDelete;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class DeletePet {
    @Test
    public void deletePet(){
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "v2/pet";

        given().accept(ContentType.JSON)
                .when().delete("13123")
                .then().statusCode(200).contentType(ContentType.JSON)
                .log().body();

    }

}

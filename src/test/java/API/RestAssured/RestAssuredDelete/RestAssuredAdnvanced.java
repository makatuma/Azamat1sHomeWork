package API.RestAssured.RestAssuredDelete;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Before;
import org.junit.Test;


import static io.restassured.RestAssured.given;

public class RestAssuredAdnvanced {
    RequestSpecification requestSpecification;
    ResponseSpecification  responseSpecification;
    Response response;


    @Before
    public void setUp(){
        //http://api.football-data.org/v2/competitions/
        RestAssured.baseURI = "http://api.football-data.org";
        RestAssured.basePath = "v2/competitions";
        requestSpecification = new RequestSpecBuilder().setAccept(ContentType.JSON).build();
        responseSpecification = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
         response = given().spec(requestSpecification).when().get().then().spec(responseSpecification
        ).extract().response();

    }


    @Test
    public void getData(){


        CompetitionsPojo competitionsPojo = response.getBody().as(CompetitionsPojo.class);



        for(int i=0; i< competitionsPojo.getCompetitions().size(); i++){

            if((int)competitionsPojo.getCompetitions().get(i).get("id")>2100){
                System.out.println(competitionsPojo.getCompetitions().get(i).get("name"));
            }
        }


    }
}

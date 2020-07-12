package API.RestAssured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class RestAssuredGroovy {
//http://api.football-data.org/v2/competitions/2000/scorers
Response response;
    @Before
    public void setUp(){
        RestAssured.baseURI ="http://api.football-data.org";
        RestAssured.basePath = "v2/competitions/2000/scorers";
        RestAssured.requestSpecification = new RequestSpecBuilder().setAccept(ContentType.JSON)
                .addHeader("X-Auth-Token", "23313095d88c47c8a01362bf1adc1e6d").build();

        RestAssured.responseSpecification = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
      response = given().spec(requestSpecification).when().get().then().spec(responseSpecification).extract()
                .response();

    }


    @Test
    public void adv1(){

     int numberOFGoals =   response.path("scorers.find { it.player.name == 'Harry Kane' }.numberOfGoals");
        System.out.println(numberOFGoals);


    }

    @Test
    public void adv2(){

        String countryOfBirth = response.path("scorers.find { it.player.name == 'Denis Cheryshev' }.player.countryOfBirth");
        Assert.assertEquals("Russia", countryOfBirth);

    }

    @Test
    public void MaxAndMinFunctions(){

         String maxGoalPLayerName =   response.path("scorers.max { it.numberOfGoals }.player.name");
         System.out.println(maxGoalPLayerName);



        String minGoalPlayerName =   response.path("scorers.min { it.numberOfGoals }.player.name");
        System.out.println(minGoalPlayerName);


    }


    @Test
    public void ListMinAndMax(){

        int minGoals = response.path("scorers.min { it.numberOfGoals }.numberOfGoals");
        List<String> scorersName = response.path("scorers.findAll { it.numberOfGoals =="+minGoals+"}.player.name");
        System.out.println(scorersName);

    }


    @Test
    public void MaxAndMinMethodChain(){

         response.then().body("scorers.find {it.player.name == 'Harry Kane' }.numberOfGoals", Matchers.equalTo(6));
         response.then().body("scorers.findAll { it.team.name == 'Russia' }.size", Matchers.greaterThan(1));
    }
}

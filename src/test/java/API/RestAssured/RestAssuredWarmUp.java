package API.RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.regex.Matcher;

import static io.restassured.RestAssured.*;

public class RestAssuredWarmUp {


    @Test
    public void getRequest(){


        //https://breakingbadapi.com/api/characters/50

        given().header("accept", ContentType.JSON).when().get("https://breakingbadapi.com/api/characters/50")
                .then().assertThat().statusCode(200).and().contentType((ContentType.JSON))
                .body("[0].name", Matchers.equalToIgnoringCase("Juan Bolsa"))
                .body("[0].occupation", Matchers.hasSize(1));


    }




    @Test
    public void getResquesTest2(){

                 given().header("accept", ContentType.JSON).when()

                .get("https://breakingbadapi.com/api/characters/50")
                .then().log().all()
                .rootPath("[0]")

                .assertThat().statusCode(200)
                .and().contentType((ContentType.JSON))

                .body("status", Matchers.equalToIgnoringCase("Deceased"))
                .body("nickname",Matchers.equalToIgnoringCase("Don Juan"))
                .body("appearance.size",Matchers.greaterThan(1))
                 .body("appearance[1]",Matchers.equalTo(4));

    }

    @Test
    public void rootPathPracticeTest(){

        RestAssured.baseURI="https://api.got.show/api/map/characters/byId/5cc0743504e71a0010b852d9";
        RestAssured.basePath="api/map/characters/byId/5cc0743504e71a0010b852d9";


        given().header("accept", ContentType.JSON).when()

                .then().log().all()

                .statusCode(200)
                .and().contentType((ContentType.JSON))
                .body("data.bookd", Matchers.hasItems("A Storm of Swords"));
    }


}

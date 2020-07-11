package API.RestAssured;

import API.BreakingBad.BreakingPojo;
import com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.List;

import static io.restassured.RestAssured.given;

public class RestAssuredDesiralization {

    @Before

    public void setUp() {

        RestAssured.baseURI = "https://breakingbadapi.com";
        RestAssured.basePath = "api/characters";
    }


    @Test
    public void deser(){


        List<BreakingPojo> des = given().header("accept", ContentType.JSON)
                .when().get("50")
                .then().statusCode(200).contentType(ContentType.JSON).extract()
                .as(new TypeRef<List<BreakingPojo>>() {
                });


       Assert.assertEquals("Juan Bolsa",des.get(0).getName());

    }

    @Test
    public void deser2(){


        List<BreakingPojo> des = given().header("accept", ContentType.JSON)
                .when().get("35")
                .then().statusCode(200).contentType(ContentType.JSON).extract()
                .as(new TypeRef<List<BreakingPojo>>() {
                });


        Assert.assertEquals("Dr. Delcavoli",des.get(0).getName());
        Assert.assertEquals("Unknown", des.get(0).getBirthday());
        Assert.assertEquals("Dr. Delcavoli", des.get(0).getNickname());
        Assert.assertEquals(2, des.get(0).getAppearance().size());

    }
}

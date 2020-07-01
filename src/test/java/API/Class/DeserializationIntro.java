package API.Class;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class DeserializationIntro {


    @Test
    public void deserialization1() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();


        URIBuilder uriBuilder = new URIBuilder();

        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet/1");


        HttpGet httpGet = new HttpGet(uriBuilder.build());


     httpGet.setHeader("Accept","application/json");

        HttpResponse response = httpClient.execute(httpGet);


        if(response.getStatusLine().getStatusCode()!=200){
            Assert.fail();
        }

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> deseralizationResponce = objectMapper.readValue(response.getEntity().getContent(),
        new TypeReference<Map<String, Object>>(){});

        System.out.println(deseralizationResponce.get("id"));
        System.out.println(deseralizationResponce.get("name"));

        Map<String, Object> category = (Map<String, Object>) deseralizationResponce.get("category");
        category.get("name");
        System.out.println(category.get("name"));


    }

    @Test
    public void deserialization2() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();


        URIBuilder uriBuilder = new URIBuilder();
//https://reqres.in/api/users/2
        uriBuilder.setScheme("https");
        uriBuilder.setHost("reqres.in");
        uriBuilder.setPath("/api/users/2");


        HttpGet httpGet = new HttpGet(uriBuilder.build());


        httpGet.setHeader("Accept","application/json");

        HttpResponse response = httpClient.execute(httpGet);


        if(response.getStatusLine().getStatusCode()!=200){
            Assert.fail();
        }

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> deseralizationResponce = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>(){});


        Map<String, String> company = (Map<String, String>) deseralizationResponce.get("ad");
       company.get("company");
        System.out.println(company.get("company"));
    }


}

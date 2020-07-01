package API.Serialization;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Serialization {
    @Test
    public void serialization() throws IOException {

        Pet pet = new Pet("Hatiko", "waiting", 3);

        pet.setId(1);
        pet.setPhotoUrl("//https://s3.petpics.amazon.com");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("target/pet.json"), pet);


    }




    @Test
    public void carSerialization() throws IOException {
        Cars cars = new Cars();

        cars.setMake("Audi");
        cars.setModel("Q5");
        cars.setBodyStyle("SUV");
        cars.setNew(true);
        cars.setPrice(123214);


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("target/cars.json"), cars);


    }


    @Test
    public void createPet() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet");


       HttpPost httpPost = new HttpPost(uriBuilder.build());

        httpPost.setHeader("Content-Type","application/json");
        httpPost.setHeader("accept", "application/json");

        String petPayload = new String(Files.readAllBytes(Paths.get("target/pet.json")));

        HttpEntity httpEntity = new StringEntity(petPayload);
        httpPost.setEntity(httpEntity);


        HttpResponse httpResponse = httpClient.execute(httpPost);
        Assert.assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());

    }
}

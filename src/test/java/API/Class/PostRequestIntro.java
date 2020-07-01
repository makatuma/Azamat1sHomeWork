package API.Class;

import io.cucumber.java.bs.A;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import static Utils.PayLoadUtil.getPetPayload;

public class PostRequestIntro {

    @Test
    public void postRequest() throws URISyntaxException, IOException {



        //https://reqres.in/api/users

        //1. Open a client (POSTMAN, terminal)
        HttpClient httpClient = HttpClientBuilder.create().build();


         //2. Build URI
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("reqres.in");
        uriBuilder.setPath("api/users");


        //3. Specify the HTTP method (GET, POST)
        HttpPost httpPost = new HttpPost(uriBuilder.build());

        //add header
        httpPost.setHeader("Content-Type","application/json");
        httpPost.setHeader("Accept","application/json");

       HttpEntity entityBuilder = new StringEntity("{\n" +
               "    \"name\": \"Azi\",\n" +
               "    \"job\": \"QA engineer\"\n" +
               "}");


       httpPost.setEntity(entityBuilder);
       httpClient.execute(httpPost);

       HttpResponse response = httpClient.execute(httpPost);

        Assert.assertEquals(201,response.getStatusLine().getStatusCode());
        //The same as Success code
        Assert.assertEquals(HttpStatus.SC_CREATED,response.getStatusLine().getStatusCode());


    }



    @Test
    public void createPet() throws URISyntaxException, IOException {
       // https://petstore.swagger.io/v2/pet
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet");

        HttpPost httpPost =  new HttpPost(uriBuilder.build());

        httpPost.setHeader("Content-Type","application/json");
        httpPost.setHeader("Accept","application/json");


        HttpEntity httpEntity = new StringEntity(getPetPayload(1881,"Rex","sold"));


httpPost.setEntity(httpEntity);
httpClient.execute(httpPost);

HttpResponse httpResponse = httpClient.execute(httpPost);

Assert.assertEquals(200,httpResponse.getStatusLine().getStatusCode());
Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());


    }
}

package API.Pojo.PetSwagger;

import API.Pojo.PetSwagger.PetPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class PetRequest {


    @Test
    public void petReq() throws URISyntaxException, IOException {



        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet/12");


        HttpGet httpGet = new HttpGet(uriBuilder.build());


        httpGet.setHeader("accept", "application/json");

        httpClient.execute(httpGet);

        HttpResponse response = httpClient.execute(httpGet);


        ObjectMapper objectMapper = new ObjectMapper();


       PetPojo desObject = objectMapper.readValue(response.getEntity().getContent(), PetPojo.class);

        System.out.println(desObject.getId());
        System.out.println(desObject.getName());


    }

    @Test
    public void  petGetReq() throws IOException, URISyntaxException {

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet/12");


        HttpGet httpGet = new HttpGet(uriBuilder.build());


        httpGet.setHeader("accept", "application/json");

        httpClient.execute(httpGet);

        HttpResponse response = httpClient.execute(httpGet);


    }
}

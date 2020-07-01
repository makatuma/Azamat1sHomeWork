package API.Pojo.StarWars;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;

import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class StarWarsSer {


    @Test
    public void starWarsSer() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        //   https://swapi.dev/api/starships
        uriBuilder.setScheme("https");
        uriBuilder.setHost("swapi.dev");
        uriBuilder.setPath("api/starships");

        HttpGet httpGet = new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept", "application/json");

        HttpResponse httpResponse = httpClient.execute(httpGet);


        ObjectMapper objectMapper = new ObjectMapper();


        StarWarsPojo starWarsPojoDes = objectMapper.readValue(httpResponse.getEntity().getContent(), StarWarsPojo.class);

        System.out.println(starWarsPojoDes.getNext());


         for(int i=0; i<starWarsPojoDes.getResults().size(); i++){
             System.out.println(starWarsPojoDes.getResults().get(i).getName());
             System.out.println(starWarsPojoDes.getResults().get(i).getCost_in_credits());
         }
    }


}

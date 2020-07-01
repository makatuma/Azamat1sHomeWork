package API.Class;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.it.Ma;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class GameOfThronesApi {

    @Test
    public void GOTTest() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();


        //https://api.got.show/api/map/characters
        uriBuilder.setScheme("https");
        uriBuilder.setHost("api.got.show");
        uriBuilder.setPath("api/map/characters");


        HttpGet httpGet = new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept","application/json");


        HttpResponse httpResponse = httpClient.execute(httpGet);


        ObjectMapper objectMapper = new ObjectMapper();


        Map<String, Object> mapper = objectMapper.readValue(httpResponse.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });


        List<Map<String, Object>> data = (List<Map<String, Object>>) mapper.get("data");



        Set<Object> set = new HashSet<>();

        for(Map<String, Object> m: data){

            set.add(m.get("house"));

        }

         for(Object ob: set){
             System.out.println(ob);
         }

    }
    
    
    @Test
    public void verifyTest() throws IOException, URISyntaxException {


        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();


        //https://api.got.show/api/map/characters
        uriBuilder.setScheme("https");
        uriBuilder.setHost("reqres.in");
        uriBuilder.setPath("api/users");
        uriBuilder.addParameter("per_page","12");


        HttpGet httpGet = new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept","application/json");


        HttpResponse httpResponse = httpClient.execute(httpGet);


        ObjectMapper objectMapper = new ObjectMapper();


        Map<String, Object> mapper = objectMapper.readValue(httpResponse.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });

         List<Map<String, Object>> data  = (List<Map<String, Object>>) mapper.get("data");
         int sum = 0;

         for(Map<String, Object> n: data){
             sum+=(int)n.get("id");
         }

        System.out.println(sum);
        Assert.assertEquals(data.size(),mapper.get("per_page"));


    }




    @Test
    public void itunesTest() throws IOException, URISyntaxException {


        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();


     //https://itunes.apple.com/search
        uriBuilder.setScheme("https");
        uriBuilder.setHost("itunes.apple.com");
        uriBuilder.setPath("search");

         int limit = 100;
        uriBuilder.setCustomQuery("term=Imagine Dragons&limit="+limit);


        HttpGet httpGet = new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept","application/json");


        HttpResponse httpResponse = httpClient.execute(httpGet);


        ObjectMapper objectMapper = new ObjectMapper();


        Map<String, Object> mapper = objectMapper.readValue(httpResponse.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });

        List<Map<String, Object>> data  = (List<Map<String, Object>>) mapper.get("results");

         int count = 0;
        for(Map<String, Object> n: data){
            String temp = ""+n.get("artistName");
            Assert.assertTrue(temp.contains("Imagine Dragons"));
            count++;
        }


        Assert.assertTrue((int)mapper.get("resultCount")==limit);
        Assert.assertTrue(count==limit);


        Integer.valueOf(String.valueOf(mapper.get("resultCount")));

        System.out.println(count);
        System.out.println(mapper.get("resultCount"));




    }
}

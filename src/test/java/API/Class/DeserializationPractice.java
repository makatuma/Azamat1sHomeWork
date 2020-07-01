package API.Class;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.it.Ma;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class DeserializationPractice {

    @Test
    public void deserializationPractice() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();


        URIBuilder uriBuilder = new URIBuilder();

        uriBuilder.setScheme("https");
        uriBuilder.setHost("cat-fact.herokuapp.com");
        uriBuilder.setPath("facts");


        HttpGet httpGet = new HttpGet(uriBuilder.build());


        httpGet.setHeader("Accept","application/json");


        HttpResponse httpResponse = httpClient.execute(httpGet);


        ObjectMapper objectMapper = new ObjectMapper();


        Map<String, List> mapper = objectMapper.readValue(httpResponse.getEntity().getContent(),
                new TypeReference<Map<String, List>>(){

                });


        int count =0;
        List<Object> list = mapper.get("all");


        for(int i=0; i<list.size(); i++){


            Map<String, String> oo = (Map<String, String>) list.get(i);

            if(
                     oo.get("text").contains("cat")
                    ||oo.get("text").contains("Cat")
                    ||oo.get("text").contains("cats")
                    ||oo.get("text").contains("Cats")
                    &&oo.get("type").equals("cat")){
                count++;
                System.out.println(oo.get("text"));
                System.out.println("" +
                        "");
            }

        }

        System.out.println("The count of cat facts: "+count);


    }


    @Test
    public void printValues() throws IOException, URISyntaxException {

       //https://reqres.in/api/users/
        HttpClient httpClient = HttpClientBuilder.create().build();


        URIBuilder uriBuilder = new URIBuilder();

        uriBuilder.setScheme("https");
        uriBuilder.setHost("reqres.in");
        uriBuilder.setPath("api/users/");


        HttpGet httpGet = new HttpGet(uriBuilder.build());


        httpGet.setHeader("Accept","application/json");


        HttpResponse httpResponse = httpClient.execute(httpGet);


        ObjectMapper objectMapper = new ObjectMapper();



        Map<String, Object> mapper = objectMapper.readValue(httpResponse.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });

        Set<String> keys = mapper.keySet();
        List<Map<String, Object>> data = (List<Map<String, Object>>) mapper.get("data");

        System.out.println(data);
        for(Map<String, Object> ob: data){
            System.out.println(ob.get("first_name"));
        }




    }
}

package API.HomeWork.StarWars;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StarWarsDesirialize {




    @Test
    public void classifyTheSpecies() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
//https://swapi.dev/api/species


        uriBuilder.setScheme("https");
        uriBuilder.setHost("swapi.dev");
        uriBuilder.setPath("api/species");

        HttpGet httpGet = new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept","application/json");

        HttpResponse httpResponse = httpClient.execute(httpGet);


        ObjectMapper objectMapper = new ObjectMapper();

        StarWarsPojo starWarsPojo = objectMapper.readValue(httpResponse.getEntity().getContent(),
                StarWarsPojo.class);

        List<String>  mammal = new ArrayList<>();
        List<String>  artificial = new ArrayList<>();
        List<String>  sentient = new ArrayList<>();
        List<String>  gastropod = new ArrayList<>();
        List<String>  reptile = new ArrayList<>();
        List<String>  amphibian = new ArrayList<>();


        Map<String, List<String>>  species = new HashMap<>();




        for(int i=0; i<starWarsPojo.getResults().size(); i++){

           if(starWarsPojo.getResults().get(i).getClassification().equalsIgnoreCase("mammal")){

               mammal.add(starWarsPojo.getResults().get(i).getName());
           } else if(starWarsPojo.getResults().get(i).getClassification().equalsIgnoreCase("artificial")){

               artificial.add(starWarsPojo.getResults().get(i).getName());
            } else if(starWarsPojo.getResults().get(i).getClassification().equalsIgnoreCase("sentient")){

               sentient.add(starWarsPojo.getResults().get(i).getName());
           }else if(starWarsPojo.getResults().get(i).getClassification().equalsIgnoreCase("gastropod")){

               gastropod.add(starWarsPojo.getResults().get(i).getName());
           }else if(starWarsPojo.getResults().get(i).getClassification().equalsIgnoreCase("reptile")){

               reptile.add(starWarsPojo.getResults().get(i).getName());
           }else if(starWarsPojo.getResults().get(i).getClassification().equalsIgnoreCase("amphibian")){

               amphibian.add(starWarsPojo.getResults().get(i).getName());
           }else {
               System.out.println(starWarsPojo.getResults().get(i).getName());
           }
        }


        species.put("mammal", mammal);
        species.put("artificial", artificial);
        species.put("sentient", sentient);
        species.put("gastropod", gastropod);
        species.put("reptile", reptile);
        species.put("amphibian", amphibian);

        System.out.println(species.get("mammal"));
        System.out.println(species.get("amphibian"));
        System.out.println(species.get("sentient"));

    }
}

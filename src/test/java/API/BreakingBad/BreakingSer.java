package API.BreakingBad;

import API.Pojo.StarWars.StarWarsPojo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
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

public class BreakingSer {

private static final String ALIVE = "alive";
    private static final String DECEASED = "deceased";
    private static final String PRECUMED_DEAD = "presumed dead";
    private static final String UNKNOWN = "unknown";




    @Test
    public void Ser() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        //   https://swapi.dev/api/starships
        uriBuilder.setScheme("https");
        uriBuilder.setHost("breakingbadapi.com");
        uriBuilder.setPath("api/characters");


        HttpGet httpGet = new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept", "application/json");

        HttpResponse httpResponse = httpClient.execute(httpGet);


        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


        List<BreakingPojo> breakingPojos = objectMapper.readValue(httpResponse.getEntity().getContent(),
                new TypeReference<List<BreakingPojo>>() {

                });


        Map<String, List<String>> people = new HashMap<>();
        List<String> alive = new ArrayList<>();
        List<String>  deceased= new ArrayList<>();
        List<String> presumedDead = new ArrayList<>();
        List<String> unknown = new ArrayList<>();

        for(int i=0; i<breakingPojos.size(); i++){
            if(breakingPojos.get(i).getStatus().equalsIgnoreCase(ALIVE)){
                alive.add(breakingPojos.get(i).getName());

            }else if(breakingPojos.get(i).getStatus().equalsIgnoreCase(DECEASED)) {

                deceased.add(breakingPojos.get(i).getName());
            }else if(breakingPojos.get(i).getStatus().equalsIgnoreCase(PRECUMED_DEAD)) {

                presumedDead.add(breakingPojos.get(i).getName());
            }else {

               unknown.add(breakingPojos.get(i).getName());

            }

            people.put(ALIVE,alive);
            people.put(DECEASED,deceased);
            people.put(PRECUMED_DEAD,presumedDead);
            people.put(UNKNOWN, unknown);

        }

        System.out.println("-------------------------------------------------");
        System.out.println("Alive"+people.get(ALIVE));
        System.out.println("" +
                "");

        System.out.println("Deceased-->"+people.get(DECEASED));
        System.out.println("" +
                "");

        System.out.println("Presumed dead-->"+people.get(PRECUMED_DEAD));

        System.out.println("" +
                "");
        System.out.println("Unknown---> "+people.get(UNKNOWN));

    }
}

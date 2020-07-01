package API.Class;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StarWarsAPI {

    @Test
    public void swTest() throws IOException, URISyntaxException {

        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uri = new URIBuilder();
        uri.setScheme("https");
        uri.setHost("swapi.dev");
        uri.setPath("api/planets");
        //https://swapi.dev/api/planets

        HttpGet get = new HttpGet(uri.build());

        HttpResponse response = httpClient.execute(get);

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> parseResponse = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference< Map<String, Object>>() {
                });


        List<Map<String, Object>> result = (List<Map<String, Object>>) parseResponse.get("results");
        Map<String, String> planetPopulationMAp = new HashMap<>();



        for (int i = 0; i < result.size(); i++) {

            String planet=result.get(i).get("name").toString();
            String population =result.get(i).get("population").toString();;

            planetPopulationMAp.put(planet, (String) population);
            System.out.println(planetPopulationMAp.get("population"));

        }
    }
}

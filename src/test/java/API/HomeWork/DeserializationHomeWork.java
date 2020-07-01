package API.HomeWork;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class DeserializationHomeWork {

    @Test

    public void deserializationTest() throws URISyntaxException, IOException {

// https://tronalddump.io/random/quote
        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("tronalddump.io");
        uriBuilder.setPath("random/quote");

        HttpGet httpGet = new HttpGet(uriBuilder.build());

       httpGet.setHeader("Accept","application/json");

        HttpResponse httpResponse = httpClient.execute(httpGet);


        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> des = objectMapper.readValue(httpResponse.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {});


        System.out.println(des.get("value"));

        Map<String, Object> links = (Map<String, Object>) des.get("_links");

        Map<String, Object>  self = (Map<String, Object>) links.get("self");

        System.out.println(self.get("href"));

}

@Test
    public void test2() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();

//https://api.chucknorris.io/jokes/random
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("api.chucknorris.io");
        uriBuilder.setPath("jokes/random");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");

        HttpResponse httpResponse = httpClient.execute(httpGet);

       ObjectMapper objectMapper = new ObjectMapper();

       Map<String, Object> map = objectMapper.readValue(httpResponse.getEntity().getContent(),
               new TypeReference<Map<String, Object>>() {});

    System.out.println(map.get("value"));
}

}

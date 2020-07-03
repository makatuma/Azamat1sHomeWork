package API.HomeWork.BreakingBad;

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
import java.util.List;
import java.util.Random;

public class BreakingBadDesirialize {


    @Test
    public void desirializeTest() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();

        Random random = new Random();
        int upperBound = 40;


        URIBuilder uriBuilder = new URIBuilder();

        uriBuilder.setScheme("https");
        uriBuilder.setHost("breakingbadapi.com");
        uriBuilder.setPath("api/characters/"+random.nextInt(upperBound));

        HttpGet httpGet = new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept", "application/json");

        HttpResponse httpResponse = httpClient.execute(httpGet);


        ObjectMapper objectMapper =new ObjectMapper();

        List<BreakingBadPojo> breakingBadPojo = objectMapper.readValue(httpResponse.getEntity().getContent(),
                new TypeReference<List<BreakingBadPojo>>() {
                });

         if(!breakingBadPojo.isEmpty()){
             System.out.println(breakingBadPojo.get(0).getName());
         }

    }
}

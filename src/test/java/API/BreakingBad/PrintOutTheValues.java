package API.BreakingBad;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
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

public class PrintOutTheValues {


    @Test
    public void PrintAndSer() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        //   https://swapi.dev/api/starships
        uriBuilder.setScheme("https");
        uriBuilder.setHost("breakingbadapi.com");
        uriBuilder.setPath("api/characters/12");


        HttpGet httpGet = new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept", "application/json");

        HttpResponse httpResponse = httpClient.execute(httpGet);


        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


        List<PrintOutPojo> breakingPojos = objectMapper.readValue(httpResponse.getEntity().getContent(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, PrintOutPojo.class));



            System.out.println(breakingPojos.get(0).getStatus());
            System.out.println(breakingPojos.get(0).getCategory());
            System.out.println(breakingPojos.get(0).getPortrayed());

        }

    }

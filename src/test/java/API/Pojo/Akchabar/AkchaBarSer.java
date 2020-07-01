package API.Pojo.Akchabar;

import API.Pojo.StarWars.StarWarsPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class AkchaBarSer {
    @Test
    public void akchaBarPojo() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        //   http://rates.akchabar.kg/get.json
        uriBuilder.setScheme("http");
        uriBuilder.setHost("rates.akchabar.kg");
        uriBuilder.setPath("get.json");

        HttpGet httpGet = new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept", "application/json");

        HttpResponse httpResponse = httpClient.execute(httpGet);


        ObjectMapper objectMapper = new ObjectMapper();


        AkpchaBarPojo akpchaBarPojo = objectMapper.readValue(httpResponse.getEntity().getContent(), AkpchaBarPojo.class);

        System.out.println(akpchaBarPojo.getRates().getUsd());
        System.out.println(akpchaBarPojo.getUpdated_at());

    }

}

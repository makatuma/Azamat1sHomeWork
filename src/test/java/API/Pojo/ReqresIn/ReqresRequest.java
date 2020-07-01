package API.Pojo.ReqresIn;

import API.Pojo.PetSwagger.PetPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class ReqresRequest {



    @Test
    public void getUser() throws URISyntaxException, IOException {



        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("reqres.in");
        uriBuilder.setPath("api/users/7");


        HttpGet httpGet = new HttpGet(uriBuilder.build());


        httpGet.setHeader("accept", "application/json");

        httpClient.execute(httpGet);

        HttpResponse response = httpClient.execute(httpGet);


        ObjectMapper objectMapper = new ObjectMapper();


        ReqresPojo desObject = objectMapper.readValue(response.getEntity().getContent(), ReqresPojo.class);


        System.out.println(desObject.getData().getFirst_name());
        System.out.println(desObject.getData().getLast_name());



    }

}

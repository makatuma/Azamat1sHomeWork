package API.Class;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.bs.A;
import io.cucumber.java.it.Ma;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import static Utils.PayLoadUtil.getPetPayload;

public class PetPostVerification {

    String petName;
    int id;
    String status;


    @Test
    public void createPet() throws URISyntaxException, IOException {
        // https://petstore.swagger.io/v2/pet
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet");

        HttpPost httpPost = new HttpPost(uriBuilder.build());

        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Accept", "application/json");

        petName = "Gresha";
        id = 1202;
        status = "available";

        HttpEntity httpEntity = new StringEntity(getPetPayload(id, petName, status));


        httpPost.setEntity(httpEntity);
        httpClient.execute(httpPost);

        HttpResponse httpResponse = httpClient.execute(httpPost);


        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> mapper = objectMapper.readValue(httpResponse.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });

        Assert.assertEquals(200, httpResponse.getStatusLine().getStatusCode());
        Assert.assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());

        Assert.assertEquals(id, mapper.get("id"));
        Assert.assertEquals(petName, mapper.get("name"));
        Assert.assertEquals(status, mapper.get("status"));


        System.out.println(("----------------------------------------------------------------------------------------------"));


        uriBuilder.setPath("v2/pet/"+id);
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");
       httpResponse = httpClient.execute(httpGet);

        Map<String, Object> mapper2 = objectMapper.readValue(httpResponse.getEntity().getContent(), new TypeReference<Map<String, Object>>() {

        });

        Assert.assertEquals(200, httpResponse.getStatusLine().getStatusCode());
        Assert.assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());

        Assert.assertEquals(id, mapper2.get("id"));
        Assert.assertEquals(petName, mapper2.get("name"));
        Assert.assertEquals(status, mapper2.get("status"));

        
    }
    }
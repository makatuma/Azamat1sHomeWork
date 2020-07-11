package API.JiraApi;

import API.JiraApi.POJO.Cookie.getSessionCookie;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class CreateUserJira {



    @Test
    public void getStoriesFromJira() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        //http://localhost:8080/rest/api/2/search?jql=assignee=techtorial&maxResults=2
        uriBuilder.setScheme("http");
        uriBuilder.setHost("localhost:8080");
        uriBuilder.setPath("rest/api/2/search");
        uriBuilder.setCustomQuery("maxResults=5");

        HttpGet httpGet = new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept", "application/json");
        httpGet.setHeader("Cookie", "JSESSIONID=398EFC9850E0CEF2BB383924B8BCE5DC");

        HttpResponse httpResponse=httpClient.execute(httpGet);

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> mapper = objectMapper.readValue(httpResponse.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });

        List<Map<String, Object>>  issues = (List<Map<String, Object>>) mapper.get("issues");

        Assert.assertEquals(5,issues.size());


    }


    @Test
    public void advancedDes() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
  //http://localhost:8080/rest/api/2/search
        uriBuilder.setScheme("http");
        uriBuilder.setHost("localhost:8080");
        uriBuilder.setPath("rest/api/2/search");


        HttpGet httpGet = new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept", "application/json");
        httpGet.setHeader("Content-Type", "application/json");
        httpGet.setHeader("Cookie", "JSESSIONID=398EFC9850E0CEF2BB383924B8BCE5DC");

        HttpResponse httpResponse=httpClient.execute(httpGet);

        System.out.println(httpResponse.getStatusLine().getStatusCode());

        ObjectMapper objectMapper = new ObjectMapper();


      JsonNode parseResponse =  objectMapper.readTree(httpResponse.getEntity().getContent());

        System.out.println(parseResponse.get("total"));
        System.out.println(parseResponse.get("issues").get(0).get("key").asText());


    }

}

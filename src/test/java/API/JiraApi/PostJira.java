package API.JiraApi;

import API.JiraApi.POJO.Cookie.getSessionCookie;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.xsom.impl.scd.Iterators;
import io.github.bonigarcia.wdm.WebDriverManager;
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Set;

public class PostJira {
    @Test
    public void postJiraApi() throws URISyntaxException, IOException {


        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
//http://localhost:8080/rest/api/2/issue
        uriBuilder.setScheme("http");
        uriBuilder.setHost("localhost:8080");
        uriBuilder.setPath("rest/api/2/issue");


        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Cookie", getSessionCookie.getSession());


        HttpEntity httpEntity = new StringEntity(getJiraPaylaod.getJiraPayload("Summary5",
                "The user should be able to create a story with JAVA1", "Story"));

        httpPost.setEntity(httpEntity);
        HttpResponse httpResponse = httpClient.execute(httpPost);

        Assert.assertEquals(HttpStatus.SC_CREATED, httpResponse.getStatusLine().getStatusCode());


        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, String> mapper = objectMapper.readValue(httpResponse.getEntity().getContent(), new TypeReference<Map<String, String>>() {

        });


Set<String> keys = mapper.keySet();

for(String key: keys){
    System.out.printf("%s: %s\n",key,mapper.get(key));
}


    }

}

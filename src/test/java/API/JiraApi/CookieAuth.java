package API.JiraApi;

import API.JiraApi.POJO.Cookie.CookiePojo;
import API.JiraApi.POJO.Cookie.CookieSessionPayload;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class CookieAuth {

    @Test
    public void jirApiTest() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
//http://localhost:8080/rest/auth/1/session
        uriBuilder.setScheme("http");
        uriBuilder.setHost("localhost:8080");
        uriBuilder.setPath("rest/auth/1/session");

        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");




        HttpEntity httpEntity = new StringEntity(CookieSessionPayload.getCookiePayload());


        httpPost.setEntity(httpEntity);


        HttpResponse httpResponse = httpClient.execute(httpPost);


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Assert.assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());

        CookiePojo cookiePojo = objectMapper.readValue(httpResponse.getEntity().getContent()
        , CookiePojo.class);


        System.out.println(cookiePojo.getSession().get("name"));
        System.out.println(cookiePojo.getSession().get("value"));


    }
}

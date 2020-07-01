package StepDefinitions.API;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Map;

import static Utils.PayLoadUtil.getPetPayload;

public class petStoreSteps {

    HttpClient httpClient;
    URIBuilder uriBuilder;
    HttpPost httpPost;
    HttpEntity httpEntity;
    HttpResponse httpResponse;
    ObjectMapper objectMapper;

    @When("user creates a pet with {int}, {string}, {string}")
    public void user_creates_a_pet_with(int id, String petName, String status) throws IOException, URISyntaxException {

         httpClient = HttpClientBuilder.create().build();
         uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet");


         httpPost = new HttpPost(uriBuilder.build());

        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Accept", "application/json");



         httpEntity = new StringEntity(getPetPayload(id, petName, status));


        httpPost.setEntity(httpEntity);
        httpClient.execute(httpPost);

         httpResponse = httpClient.execute(httpPost);








    }

    @Then("the status code is {string};")
    public void the_status_code_is(String statusCode) throws IOException {

        Assert.assertEquals(Integer.parseInt(statusCode),httpResponse.getStatusLine().getStatusCode());


    }

    @Then("pet with {int}, {string}, {string} is created")
    public void pet_with_is_created(int id, String petName, String status) throws IOException {

        objectMapper = new ObjectMapper();
        Map<String, Object> mapper  = objectMapper.readValue(httpResponse.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });


        Assert.assertEquals(id, mapper.get("id"));
        Assert.assertEquals(petName, mapper.get("name"));
        Assert.assertEquals(status, mapper.get("status"));
    }


}

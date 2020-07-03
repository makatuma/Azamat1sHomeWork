package API.HomeWork.PetSwagger;

import API.HomeWork.PetSwagger.PetPayLoad;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class PostPets {


    public static List<Long> ids;


    @Test
    public void postPetTest() throws URISyntaxException, IOException {
        //https://petstore.swagger.io/v2/pet


        ids = new ArrayList<>();

        for (int i = 0; i < 25; i++) {
            Long id = System.currentTimeMillis();

            ids.add(id);


            HttpClient httpClient = HttpClientBuilder.create().build();
            URIBuilder uriBuilder = new URIBuilder();
            uriBuilder.setScheme("https");
            uriBuilder.setHost("petstore.swagger.io");
            uriBuilder.setPath("v2/pet");

            HttpPost httpPost = new HttpPost(uriBuilder.build());
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("Accept", "application/json");


            System.out.println("Post id: " + ids.get(i));

            HttpEntity httpEntity = new StringEntity(PetPayLoad.getPetPayload(id));


            httpPost.setEntity(httpEntity);
            httpClient.execute(httpPost);

            HttpResponse httpResponse = httpClient.execute(httpPost);

            Assert.assertEquals(200, httpResponse.getStatusLine().getStatusCode());
            Assert.assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());

        }

        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
    }

    @Test
    public void putPostPet() throws URISyntaxException, IOException {
        //https://petstore.swagger.io/v2/pet


        for (int i = 0; i < 25; i++) {
            HttpClient httpClient = HttpClientBuilder.create().build();
            URIBuilder uriBuilder = new URIBuilder();
            uriBuilder.setScheme("https");
            uriBuilder.setHost("petstore.swagger.io");
            uriBuilder.setPath("v2/pet");

            HttpPut httpPut = new HttpPut(uriBuilder.build());
            httpPut.setHeader("Content-Type", "application/json");
            httpPut.setHeader("Accept", "application/json");

            System.out.println("Put id: " + ids.get(i));
            HttpEntity httpEntity = new StringEntity(PetPayLoad.getPetPayload(ids.get(i)));


            httpPut.setEntity(httpEntity);
            httpClient.execute(httpPut);

            HttpResponse httpResponse = httpClient.execute(httpPut);

            Assert.assertEquals(200, httpResponse.getStatusLine().getStatusCode());
            Assert.assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());

        }

    }


    @Test
    public void deletePets() throws URISyntaxException, IOException {

        //https://petstore.swagger.io/v2/pet/1593116485347

        for (int i = 0; i < 25; i++) {

            HttpClient httpClient = HttpClientBuilder.create().build();


            URIBuilder uriBuilder = new URIBuilder();
            uriBuilder.setScheme("https");
            uriBuilder.setHost("petstore.swagger.io");
            System.out.println(ids.get(i));
            uriBuilder.setPath("v2/pet" +"/"+ids.get(i));

            HttpDelete httpDelete = new HttpDelete(uriBuilder.build());
            httpClient.execute(httpDelete);
            httpDelete.setHeader("Accept","application/json");
            HttpResponse httpResponse = httpClient.execute(httpDelete);

           Assert.assertEquals(200, httpResponse.getStatusLine().getStatusCode());

        }
    }
}
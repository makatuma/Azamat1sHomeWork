package API.HomeWork.GameOFThrones;

import API.HomeWork.GameOFThrones.GOTPojo;
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

public class GotSerialize {

    @Test
    public void countGender() throws URISyntaxException, IOException {
//GET https://api.got.show/api/map/characters

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();

        uriBuilder.setScheme("https");
        uriBuilder.setHost("api.got.show");
        uriBuilder.setPath("api/map/characters");



        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept", "application/json");

        HttpResponse httpResponse = httpClient.execute(httpGet);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


        GOTPojo gotPojoDes = objectMapper.readValue(httpResponse.getEntity().getContent(), GOTPojo.class);

        int countOfMale = 0;
        int countOfFemale = 0;







for(int i=0; i<gotPojoDes.getData().size(); i++){

    if(gotPojoDes.getData().get(i).isMale()==true){

        countOfMale++;



    }else if(gotPojoDes.getData().get(i).isMale()==false){
        countOfFemale++;



    }else {
        System.out.println("Other--->"+gotPojoDes.getData().get(i).isMale());
    }




}

        System.out.println("Sum of females: "+countOfFemale);
        System.out.println("Sum of males: "+countOfMale);
    }


    @Test
    public void countCharacters() throws URISyntaxException, IOException {
//GET https://api.got.show/api/map/characters

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();

        uriBuilder.setScheme("https");
        uriBuilder.setHost("api.got.show");
        uriBuilder.setPath("api/map/characters");


        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept", "application/json");

        HttpResponse httpResponse = httpClient.execute(httpGet);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


        GOTPojo gotPojoDes = objectMapper.readValue(httpResponse.getEntity().getContent(), GOTPojo.class);

        int count =0;
        String strBooks = "";



            for (int k = 0; k < gotPojoDes.getData().size(); k++) {

                strBooks = gotPojoDes.getData().get(k).getBooks().toString();

                System.out.println(strBooks);
                if (strBooks.contains(gotPojoDes.getData().get(k).getBooks().toString())) {
                    count++;
                }
        }


        System.out.println(count);
    }
    }
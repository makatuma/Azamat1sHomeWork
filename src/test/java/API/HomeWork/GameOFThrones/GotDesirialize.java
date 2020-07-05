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

import javax.imageio.stream.ImageInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class GotDesirialize {

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


        Map<String, Integer> numberOfMandW = new HashMap<>();





for(int i=0; i<gotPojoDes.getData().size(); i++){

    if(gotPojoDes.getData().get(i).isMale()==true){

        countOfMale++;



    }else if(gotPojoDes.getData().get(i).isMale()==false){
        countOfFemale++;



    }else {
        System.out.println("Other--->"+gotPojoDes.getData().get(i).isMale());
    }


}
numberOfMandW.put("males", countOfMale);
numberOfMandW.put("females", countOfFemale);

        System.out.println("Sum of females: "+numberOfMandW.get("females"));
        System.out.println("Sum of males: "+numberOfMandW.get("males"));


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

     List <String>  listOfbookNames = new ArrayList<>();
     Set<String>    setOfBooks = new HashSet<>();

     int count =0;
     int numOfChars = 0;





        for(int i=0; i<gotPojoDes.getData().size(); i++){
numOfChars++;
                for( int k=0; k<gotPojoDes.getData().get(i).getBooks().size(); k++){

                    setOfBooks.add(gotPojoDes.getData().get(i).getBooks().get(k));
                    listOfbookNames.add(gotPojoDes.getData().get(i).getBooks().get(k));

                }
                }

    }
    }
package API.Class;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class GetRequestIntro {
//
//    To Send a API call:
//
//            1. Open a client (POSTMAN, terminal)
//2. Specify the HTTP method (GET, POST)
//3. Specify URL/URI/endpoint
//4. Add Query parameter (if needed)
//5. Add header parameters (Content-Type, Accept)
//6. Add body parameter (for POST)
//7. Execute (click on Send button)
    @Test
    public void getRequest() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();



        URIBuilder uri = new URIBuilder();
        uri.setScheme("https");
        uri.setHost("petstore.swagger.io");
        uri.setPath("v2/pet/158898");




        HttpGet get = new HttpGet(uri.build());
        get.setHeader("Accept","application/json");
        client.execute(get);

        HttpResponse response = client.execute(get);

        System.out.println("Status code is----> "+response.getStatusLine().getStatusCode());
        System.out.println(response.getEntity().getContentType().getValue());

        Assert.assertEquals(200,response.getStatusLine().getStatusCode());
        Assert.assertEquals("application/json",response.getEntity().getContentType().getValue());




    }


    @Test
    public void getByStatus() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder uri = new URIBuilder();

        uri.setScheme("https");

        uri.setHost("petstore.swagger.io");

        uri.setPath("v2/finByStatus");

        uri.setCustomQuery("status=sold");

        HttpGet get = new HttpGet(uri.build());

        get.setHeader("Accept","application/json");
        client.execute(get);

        HttpResponse response = client.execute(get);




        System.out.println("Status: "+response.getStatusLine().getStatusCode());
        System.out.println(response.getEntity().getContentType().getValue());

        
    }
}

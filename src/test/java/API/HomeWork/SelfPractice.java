package API.HomeWork;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class SelfPractice {
    @Test
    public void getRequest() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();



        URIBuilder uriBuilder = new URIBuilder();
               uriBuilder.setScheme("https");
                uriBuilder.setHost("www.amazon.com");
                uriBuilder.setPath("b/ref=OUT_E_DSC_D_EN_US");
                 uriBuilder.setCustomQuery("node=17895003011");


        HttpGet get = new HttpGet(uriBuilder.build());
        get.setHeader("Accept","application/json");
        client.execute(get);

        HttpResponse response = client.execute(get);

        System.out.println("Status code is----> "+response.getStatusLine().getStatusCode());
        System.out.println(response.getEntity().getContentType().getValue());





    }

}

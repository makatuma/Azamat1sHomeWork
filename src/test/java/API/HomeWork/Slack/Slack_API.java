package API.HomeWork.Slack;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import static API.HomeWork.Slack.SlackPayload.getSlackPayload;

public class Slack_API {
    public  static  String message;



    @Test
    public void  slackAPIVerification() throws URISyntaxException, IOException, InterruptedException {


            message ="Aza-Maza";

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder;
        uriBuilder = new URIBuilder();

            uriBuilder.setScheme("https");
            uriBuilder.setHost("slack.com");
            uriBuilder.setPath("api/chat.postMessage");


            HttpPost httpPost = new HttpPost(uriBuilder.build());
            httpPost.setHeader("Accept","application/json");
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("Authorization", "Bearer xoxb-941125893829-1209222336674-V71HpFW2Xr33KoX1tBuZecRV");

            HttpEntity httpEntity = new StringEntity(getSlackPayload(message));

            httpPost.setEntity(httpEntity);
            httpClient.execute(httpPost);

           HttpResponse response = httpClient.execute(httpPost);


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.slack.com/client/TTP3PS9QD/C0164SXRETU");

        driver.findElement(By.xpath("//input[@class='input_inline align_right small_right_margin team_name_input']"))
                .sendKeys("techtorialbatch4");

        driver.findElement(By.xpath("//button[@id='submit_team_domain']")).click();
        driver.findElement(By.xpath("//input[@data-qa='login_email']")).sendKeys("dkc.dov@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login_password']")).sendKeys("azakg007");
        driver.findElement(By.xpath("//button[@data-qa='signin_button']")).click();
        Thread.sleep(2000);


        List<WebElement> listOfMessages = driver.findElements(By.xpath("//span[@class='c-message_kit__text']"));

        Assert.assertEquals(message, listOfMessages.get(listOfMessages.size()-1).getText());




    }


    @Test
    public void getMessages() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder;
        uriBuilder = new URIBuilder();

        uriBuilder.setScheme("https");
        uriBuilder.setHost("slack.com");
        uriBuilder.setPath("api/conversations.history");
        uriBuilder.setCustomQuery("channel=C0164SXRETU");


        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");
        httpGet.setHeader("Authorization", "Bearer xoxb-941125893829-1209222336674-V71HpFW2Xr33KoX1tBuZecRV");




        httpClient.execute(httpGet);

        HttpResponse response = httpClient.execute(httpGet);


        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> mapper = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });

        List<Map<String,Object>> mapper2 = (List<Map<String, Object>>) mapper.get("messages");
        Assert.assertEquals(message,mapper2.get(0).get("text"));

    }


}

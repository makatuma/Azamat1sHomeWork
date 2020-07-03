package StepDefinitions.API;

import Pages.API.SlackPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import static API.HomeWork.Slack.SlackPayload.getSlackPayload;

public class Slack_Steps {





    public  static  String message;
    public static  String UIMessage;
    SlackPage slackPage;
    WebDriver driver;




    public void navigateToSlack() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        slackPage = new SlackPage(driver);

        driver.get("https://app.slack.com/client/TTP3PS9QD/C0164SXRETU");


        slackPage.workSpace.sendKeys("techtorialbatch4");

        slackPage.continueBtn.click();
        slackPage.email.sendKeys("dkc.dov@gmail.com");
        slackPage.password.sendKeys("azakg007");
        slackPage.loginBtn.click();
        Thread.sleep(3000);

   }


    @Given("send message to slack via POST request")
    public void send_message_to_slack_via_POST_request() throws IOException, URISyntaxException {
        message ="Tash";
        UIMessage = "Chainar";

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder;
        uriBuilder = new URIBuilder();

        uriBuilder.setScheme("https");
        uriBuilder.setHost("slack.com");
        uriBuilder.setPath("api/chat.postMessage");


        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.setHeader("Accept","application/json");
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Authorization", "Bearer xoxb-941125893829-1209222336674-bAXxCFoJlNU7qhWlTL9yQAF7");

        HttpEntity httpEntity = new StringEntity(getSlackPayload(message));

        httpPost.setEntity(httpEntity);
        httpClient.execute(httpPost);


    }

    @Given("verify the message via GET request")
    public void verify_the_message_via_GET_request() throws IOException, URISyntaxException {
        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder;
        uriBuilder = new URIBuilder();

        uriBuilder.setScheme("https");
        uriBuilder.setHost("slack.com");
        uriBuilder.setPath("api/conversations.history");
        uriBuilder.setCustomQuery("channel=C0164SXRETU");


        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept", "application/json");
        httpGet.setHeader("Authorization", "Bearer xoxb-941125893829-1209222336674-a9qBQeDSYC16a0SI1NLgs6lI");


        httpClient.execute(httpGet);

        HttpResponse response = httpClient.execute(httpGet);


        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> mapper = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });

        List<Map<String, Object>> mapper2 = (List<Map<String, Object>>) mapper.get("messages");


//        System.out.println("Size--->" + mapper2.size());
//        String actualMess = (String) mapper2.get(0).get("text");
//        System.out.println(actualMess);
//        Assert.assertEquals(message, actualMess);

    }

    @When("the user sends message to slack via POST request")
    public void the_user_sends_message_to_slack_via_POST_request() throws URISyntaxException, IOException {
        message ="Tash";
        UIMessage = "Chainar";

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder;
        uriBuilder = new URIBuilder();

        uriBuilder.setScheme("https");
        uriBuilder.setHost("slack.com");
        uriBuilder.setPath("api/chat.postMessage");


        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.setHeader("Accept","application/json");
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Authorization", "Bearer xoxb-941125893829-1209222336674-bAXxCFoJlNU7qhWlTL9yQAF7");

        HttpEntity httpEntity = new StringEntity(getSlackPayload(message));

        httpPost.setEntity(httpEntity);
        httpClient.execute(httpPost);

    }


    @Then("the user verifies the message with Selenium Webdriver in UI")
    public void the_user_verifies_the_message_with_Selenium_Webdriver_in_UI() throws InterruptedException {

        navigateToSlack();
//        String actualMessage = driver.findElement(By.xpath("//div[contains(text(),'"+message+"')]")).getText();
//        System.out.println(actualMessage);
//        Assert.assertEquals(message, actualMessage);

    }



    @When("the user sends message to slack with Selenium Webdriver in UI")
    public void the_user_sends_message_to_slack_with_Selenium_Webdriver_in_UI() {
        slackPage.messageField.sendKeys(UIMessage);
        slackPage.sendButton.click();
    }

    @Then("the user verifies the message via GET request")
    public void the_user_verifies_the_message_via_GET_request() throws IOException, URISyntaxException {
        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder;
        uriBuilder = new URIBuilder();

        uriBuilder.setScheme("https");
        uriBuilder.setHost("slack.com");
        uriBuilder.setPath("api/conversations.history");
        uriBuilder.setCustomQuery("channel=C0164SXRETU");


        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept", "application/json");
        httpGet.setHeader("Authorization", "Bearer xoxb-941125893829-1209222336674-a9qBQeDSYC16a0SI1NLgs6lI");


        httpClient.execute(httpGet);

        HttpResponse response = httpClient.execute(httpGet);


        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> mapper = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });

        List<Map<String, Object>> mapper2 = (List<Map<String, Object>>) mapper.get("messages");


//        System.out.println("Size--->" + mapper2.size());
//        String actualMess = (String) mapper2.get(0).get("text");
//        System.out.println(actualMess);
//        Assert.assertEquals(UIMessage, actualMess);

    }

    @Given("delete message from slack via POST request")
    public void delete_message_from_slack_via_POST_request() {
        System.out.println("NOT IMPLEMENTED");
    }

    @Given("verify the message is gone via GET request")
    public void verify_the_message_is_gone_via_GET_request() {
        System.out.println("NOT IMPLEMENTED");
    }

    @When("the user deletes the message from slack via POST request")
    public void the_user_deletes_the_message_from_slack_via_POST_request() {
        System.out.println("NOT IMPLEMENTED");
    }

    @Then("Verify the message is gone via Selenium Webdriver in UI")
    public void verify_the_message_is_gone_via_Selenium_Webdriver_in_UI() {
        System.out.println("NOT IMPLEMENTED");
    }


}

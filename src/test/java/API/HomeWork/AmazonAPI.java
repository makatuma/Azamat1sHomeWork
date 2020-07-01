package API.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class AmazonAPI {




    @Test
    public void linkVerificationTest() throws InterruptedException, URISyntaxException, IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();







        List<WebElement> links = driver.findElements(By.xpath("//a[@href]"));

        for(int i=1; i<links.size(); i++){

            System.out.println(links.get(i).getAttribute("href"));

            String url = links.get(i).getAttribute("href");

            Response response =  RestAssured.get(url);
            int statusCode = response.getStatusCode();

           if(statusCode==200){
               System.out.println("URL ==>>> "+url);
               System.out.println("Status code----> "+response.getStatusCode());
           }

        }


    }
}

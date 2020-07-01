package Pages.API;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SlackPage {



    public SlackPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }







    @FindBy(xpath = "//input[@class='input_inline align_right small_right_margin team_name_input']")
    public WebElement workSpace;

    @FindBy(xpath = "//button[@id='submit_team_domain']")
    public WebElement continueBtn;

    @FindBy(xpath = "//input[@data-qa='login_email']")
    public WebElement email;

    @FindBy(xpath = "//input[@data-qa='login_password']")
    public WebElement password;

   @FindBy(xpath = "//button[@data-qa='signin_button']")
   public WebElement loginBtn;


    @FindBy(xpath = "//div[@class='p-rich_text_section']")
    public List<WebElement> listOfMessages;


    @FindBy(xpath = "//div[@data-team-id='TTP3PS9QD']")
    public WebElement messageField;


    @FindBy(xpath = "//i[@type='paperplane-filled']")
    public WebElement sendButton;

    @FindBy(xpath = "//i[@class='c-icon c-icon--vertical-ellipsis']")
    public WebElement dots;

    @FindBy(xpath = "//div[@data-qa='message_content']")
    public List<WebElement> hoverOvers;


}

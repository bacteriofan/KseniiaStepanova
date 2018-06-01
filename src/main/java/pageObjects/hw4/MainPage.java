package pageObjects.hw4;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;


public class MainPage {

    @FindBy(css = ".profile-photo")
    private SelenideElement loginButton;

    @FindBy(css = "#Name")
    private SelenideElement loginInput;

    @FindBy(css = "#Password")
    private SelenideElement paswordInput;

    @FindBy(css = ".form-horizontal button[type = 'submit']")
    private SelenideElement submitButton;

    @FindBy(css = ".benefit-icon")
    private List<SelenideElement> images;

    public void login(String login, String password) {
        loginButton.click();
        loginInput.sendKeys(login);
        paswordInput.sendKeys(password);
        submitButton.click();
    }


    // page object example http://ru.selenide.org/documentation/page-objects.html
}

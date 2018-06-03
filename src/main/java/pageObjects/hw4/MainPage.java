package pageObjects.hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.LinkedList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class MainPage {

    @FindBy(css = ".profile-photo")
    private SelenideElement loginButton;

    @FindBy(css = "#Name")
    private SelenideElement loginInput;

    @FindBy(css = "#Password")
    private SelenideElement paswordInput;

    @FindBy(css = ".form-horizontal button[type = 'submit']")
    private SelenideElement submitButton;

    @FindBy(css = ".profile-photo span")
    private SelenideElement userNameLabel;

    @FindBy(css = ".benefit-icon")
    private List<SelenideElement> images;

    @FindBy(css = ".benefit-txt")
    private List<SelenideElement> textsUnderImages;

    @FindBy(css = "h3[name='main-title']")
    private SelenideElement mainText;

    @FindBy(css = "p[name='jdi-text']")
    private SelenideElement subText;

    @FindBy(css = "ul[class='uui-navigation nav navbar-nav m-l8'] a[class='dropdown-toggle']")
    private SelenideElement service;

    @FindBy(css = "ul[class='dropdown-menu'] > li > a")
    private List<SelenideElement> serviceDropdown;

    @FindBy(xpath = "//ul[@class='sub']/li/a/p/span")
    private List<SelenideElement> serviceLeftPanel;



    public void openMainPage() {
        open("https://epam.github.io/JDI/index.html");
    }

    public void checkBrowserTitle(String title) {
        Assert.assertEquals(getWebDriver().getTitle(), title);
    }

    public void login(String login, String password) {
        loginButton.click();
        loginInput.sendKeys(login);
        paswordInput.sendKeys(password);
        submitButton.click();
    }

    public void checkUserName(String userName) {
        userNameLabel.shouldHave(Condition.exactText(userName));
    }

    public void checkPictures() {
        for (SelenideElement image : images) {
            image.shouldBe(Condition.visible);
        }
    }

    public void checkTextUnderImages() {
        List<String> actualTexts = new LinkedList<>();

        List<String> expectedTexts = new LinkedList<String>();
        expectedTexts.add("To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        expectedTexts.add("To be flexible and\n" +
                "customizable");
        expectedTexts.add("To be multiplatform");
        expectedTexts.add("Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        // get text from each element
        for (SelenideElement textUnderImage : textsUnderImages) {
            actualTexts.add(textUnderImage.getText());

        }
        Assert.assertTrue(actualTexts.equals(expectedTexts));
    }

    public void checkMainHeaderTexts() {
        mainText.shouldHave(Condition.exactText("EPAM FRAMEWORK WISHES…"));
        subText.shouldHave(Condition.exactText("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
                "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE " +
                "IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."));
    }

    public void openServiceDropdown() {
        service.click();
    }

    public void checkServiceDropdown() {
        List<String> actualServiceElements = new LinkedList<>();
        for(SelenideElement element : serviceDropdown) {
            actualServiceElements.add(element.getText());
        }
        checkServiceElements(actualServiceElements);
    }

    public void checkServiceLeftPanel() {
        List<String> actualServiceElements = new LinkedList<>();
        for(SelenideElement element : serviceLeftPanel) {
            actualServiceElements.add(element.getAttribute("innerHTML").toUpperCase().trim());
        }
        checkServiceElements(actualServiceElements);
    }


    public void checkServiceElements(List<String> actualServiceElements) {
        List<String> expectedServiceElements = new LinkedList<>();
        expectedServiceElements.add("SUPPORT");
        expectedServiceElements.add("DATES");
        expectedServiceElements.add("COMPLEX TABLE");
        expectedServiceElements.add("SIMPLE TABLE");
        expectedServiceElements.add("USER TABLE");
        expectedServiceElements.add("TABLE WITH PAGES");
        expectedServiceElements.add("DIFFERENT ELEMENTS");
        expectedServiceElements.add("PERFORMANCE");

        Assert.assertEquals(actualServiceElements, expectedServiceElements);
    }
}

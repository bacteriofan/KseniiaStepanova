package pageObjects.hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import java.util.LinkedList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.ServiceList.*;
import static org.testng.Assert.assertEquals;


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
    private ElementsCollection images;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection textsUnderImages;

    @FindBy(css = "h3[name='main-title']")
    private SelenideElement mainText;

    @FindBy(css = "p[name='jdi-text']")
    private SelenideElement subText;

    @FindBy(css = "ul[class='uui-navigation nav navbar-nav m-l8'] a[class='dropdown-toggle']")
    private SelenideElement service;

    @FindBy(css = "ul[class='dropdown-menu'] > li > a")
    private ElementsCollection serviceDropdown;

    @FindBy(xpath = "//ul[@class='sub']//span")
    private ElementsCollection serviceLeftPanel;


    public void openMainPage() {
        open("https://epam.github.io/JDI/index.html");
    }

    public void checkBrowserTitle(String title) {
        assertEquals(getWebDriver().getTitle(), title);
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
        images.shouldHaveSize(4);
        images.forEach(image -> image.shouldBe(Condition.visible));
    }

    public void checkTextUnderImages() {
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

        for (int i = 0; i < textsUnderImages.size(); i++) {
            assertEquals(textsUnderImages.get(i).getText(),
                    expectedTexts.get(i));
        }
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
        serviceDropdown.forEach(option -> actualServiceElements.add(option.getText()));

        checkServiceElements(actualServiceElements);
    }

    public void checkServiceLeftPanel() {
        List<String> actualServiceElements = new LinkedList<>();
        serviceLeftPanel.forEach(option -> actualServiceElements.add(option.getAttribute("innerHTML").toUpperCase().trim()));

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

        for (int i = 0; i < actualServiceElements.size(); i++) {
            assertEquals(actualServiceElements.get(i),
                    expectedServiceElements.get(i));
        }
    }

    public Object selectOptionFromServiceDropdown(String option) {
        openServiceDropdown();
        $(By.linkText(option)).click();
        Object page = null;

        if (option.equals(DIFFERENT_ELEMENTS.option)) {
            page = page(DifferentElementsPage.class);
        }

        if (option.equals(DATES.option))  {
            page = page(DatesPage.class);
        }
        return page;
    }
}

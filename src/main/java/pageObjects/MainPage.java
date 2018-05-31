package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.LinkedList;
import java.util.List;


public class MainPage {

    public WebDriver driver;


    @FindBy(xpath = "//li[@class = 'dropdown uui-profile-menu']")
    private WebElement loginButton;

    @FindBy(id = "Name")
    private WebElement usernameField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement submitCredentials;

    @FindBy(xpath = "//span[@ui = 'label']")
    private WebElement userNameLabel;

    @FindBy(xpath = "//h3[@name = 'main-title']")
    private WebElement mainHeader;

    @FindBy(xpath = "//p[@name = 'jdi-text']")
    private WebElement mainText;

    @FindBy(xpath = "//a[contains(text(),'JDI Github')]")
    private WebElement subHeader;

    @FindBy(xpath = "//h3[@class='text-center']/a")
    private WebElement url;

    @FindBy(xpath = "//div[@id = 'mCSB_1_container']")
    private WebElement leftSection;

    @FindBy(xpath = "//div[@class = 'footer-content overflow']")
    private WebElement footer;

    @FindBy(xpath = "//ul[@calss='uui-navigation nav navbar-nav m-l8']")
    private List<WebElement> headerItemsText;

    @FindBy(xpath = "//div[@class = 'row clerafix benefits']//div[@class = 'benefit-icon']")
    private List<WebElement> images;

    @FindBy(xpath = "//div[@class = 'row clerafix benefits']//span[@class = 'benefit-txt']")
    private List<WebElement> textUnderImages;


    //---------------------------------------------------------------------------------------------------------------------

    public void open(WebDriver driver) {
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        Assert.assertEquals(driver.getTitle(), "Home Page");
    }

    public void checkMainPageTitle(WebDriver driver) {
        Assert.assertEquals(driver.getTitle(), "Home Page");
    }

    public void login(String login, String password, String name) {
        loginButton.click();
        usernameField.sendKeys(login);
        passwordField.sendKeys(password);
        submitCredentials.click();
        Assert.assertEquals(userNameLabel.getText(), name);
    }

    public void checkHeaderItemsText() {
        List<String> expectedHeaders = new LinkedList<String>();
        expectedHeaders.add("HOME");
        expectedHeaders.add("CONTACT FORM");
        expectedHeaders.add("SERVICE");
        expectedHeaders.add("METALS & COLORS");

        for (WebElement actualHeader : headerItemsText) {
            for (String expectedHeader : expectedHeaders) {
                Assert.assertEquals(actualHeader.getText(), expectedHeader);
            }
        }
    }

    public void checkImagesAreDisplayed() {
        Assert.assertEquals(images.size(), 4);
        for (WebElement image : images) {
            Assert.assertTrue(image.isDisplayed());
        }
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

        for (WebElement actualText : textUnderImages) {
            for (String expectedText : expectedTexts) {
                Assert.assertEquals(actualText.getText(), expectedText);

            }
        }
    }

    public void checkMainHeaderText() {
        Assert.assertEquals(mainHeader.getText(), "EPAM FRAMEWORK WISHES…");
        Assert.assertEquals(mainText.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
                "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE " +
                "IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
    }

    public void checkSubHeader() {
        Assert.assertEquals(subHeader.getText(), "JDI GITHUB");
    }

    public void checkURL() {
        Assert.assertEquals(url.getAttribute("href"), "https://github.com/epam/JDI");
    }

    public void checkLeftSectionIsDisplayed() {
        Assert.assertTrue(leftSection.isDisplayed());
    }

    public void checkFooterIsDisplayed() {
        Assert.assertTrue(footer.isDisplayed());
    }

}


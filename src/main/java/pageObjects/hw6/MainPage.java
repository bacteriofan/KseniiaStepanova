package pageObjects.hw6;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pageObjects.hw4.DatesPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Formatter;
import java.util.LinkedList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.ServiceList.DATES;
import static enums.ServiceList.DIFFERENT_ELEMENTS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class MainPage {

    public MainPage() {
        page(this);
    }

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


    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radiobuttons;

    @FindBy(css = ".colors .uui-form-element")
    private SelenideElement dropdown;

    @FindBy(css = "button[class = 'uui-button']")
    private SelenideElement defaultButton;

    @FindBy(css = "input[class = 'uui-button']")
    private SelenideElement button;

    @FindBy(css = "div[name = 'log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = "div[name = 'navigation-sidebar']")
    private SelenideElement leftSection;

    @FindBy(css = ".panel-body-list>li")
    private SelenideElement logRow;

    @FindBy(css = ".colors .uui-form-element")
    private SelenideElement colorsDropdown;

    @Given("I am on Main Page")
    public void openMainPage() {
        open("https://epam.github.io/JDI/index.html");
    }

    @When("Browser title is Home Page")
    public void checkBrowserTitle(String title) {
        assertEquals(getWebDriver().getTitle(), title);
    }

    @Step
    @Then("I login as user (.+) with password (.+)")
    public void login(String login, String password) {
        loginButton.click();
        loginInput.sendKeys(login);
        paswordInput.sendKeys(password);
        submitButton.click();
    }

    @Step
    @Then("User name is (.+)")
    public void checkUserName(String userName) {
        userNameLabel.shouldHave(Condition.exactText(userName));
    }

    @Step
    @Then("4 pictures are displayed")
    public void checkPictures() {
        images.shouldHaveSize(4);
        images.forEach(image -> image.shouldBe(Condition.visible));
    }

    @Step
    @Then("Texts under images are correct")
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

    @Step
    @Then("Main headers texts are correct")
    public void checkMainHeaderTexts() {
        mainText.shouldHave(Condition.exactText("EPAM FRAMEWORK WISHES…"));
        subText.shouldHave(Condition.exactText("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
                "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE " +
                "IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."));
    }

    @Step
    @When("I open Service dropdown list")
    public void openServiceDropdown() {
        service.click();
    }

    @Step
    @Then("Service dropdown list is correct")
    public void checkServiceDropdown() {
        List<String> actualServiceElements = new LinkedList<>();
        serviceDropdown.forEach(option -> actualServiceElements.add(option.getText()));

        checkServiceElements(actualServiceElements);
    }

    @Step
    @Then("Service left panel list is correct")
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

    @Step
    @When("I open (.+) page through Service dropdown list")
    public void selectOptionFromServiceDropdown(String option) {
        openServiceDropdown();
        $(By.linkText(option)).click();
    }


    @Step
    @Then("4 checkboxes are displayed")
    public void checkCheckboxes() {
        checkboxes.shouldHaveSize(4);
        checkboxes.forEach(checkbox -> assertTrue(checkbox.exists()));
    }

    @Step
    @Then("4 radio buttons are displayed")
    public void checkRadiobuttons() {
        radiobuttons.shouldHaveSize(4);
        radiobuttons.forEach(radiobutton -> assertTrue(radiobutton.exists()));
    }

    @Step
    @Then("Dropdown is displayed")
    public void checkDropdown() {
        assertTrue(dropdown.isDisplayed());
    }

    @Step
    @Then("2 buttons are displayed")
    public void checkButtons() {
        assertTrue(defaultButton.isDisplayed());
        assertTrue(button.isDisplayed());
    }

    @Step
    @Then("Right section is displayed")
    public void checkRightSection() {
        assertTrue(rightSection.isDisplayed());
    }

    @Step
    @Then("Left section is displayed")
    public void checkLeftSection() {
        assertTrue(leftSection.isDisplayed());
    }

    @Step
    @When("I click (.+) checkbox")
    public void clickCheckbox(String checkbox) {
        checkboxes.findBy(text(checkbox)).click();
    }

    @Step
    @When("I select (.+) radio button")
    public void selectRadiobutton(String radiobutton) {
        radiobuttons.findBy(text(radiobutton)).click();
    }

    @Step
    @When("I select color (.+) from dropdown")
    public void selectColorFromDropdown (String color) {
        colorsDropdown.selectOptionContainingText(color);
    }

    @Step
    @Then("I check log: (.+) checkbox is (.+)")
    public void checkLog(String checkboxName, String status) {
        String actualText = logRow.getText().substring(9, logRow.getText().length());
        Formatter f = new Formatter();
        f.format("%s" + ": condition changed to " + "%s", checkboxName, status);
        String expectedText = f.toString();

        assertEquals(actualText, expectedText);
    }

    @Step
    @Then("I check log: (.+) value is changed")
    public void checkLog(String changedValue) {
        String actualText = logRow.getText().substring(9, logRow.getText().length());
        String expectedText = "";
        Formatter f = new Formatter();
        if (actualText.contains("metal")) {
            f.format("metal: value changed to " + "%s", changedValue);
            expectedText = f.toString();
        }
        if (actualText.contains("Colors")) {
            f.format("Colors: value changed to " + "%s", changedValue);
            expectedText = f.toString();
        }
        assertEquals(actualText, expectedText);
    }
}

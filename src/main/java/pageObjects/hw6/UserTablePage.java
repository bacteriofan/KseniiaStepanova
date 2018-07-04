package pageObjects.hw6;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class UserTablePage {

    public UserTablePage() {
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

    @FindBy(css = "ul[class='uui-navigation nav navbar-nav m-l8'] a[class='dropdown-toggle']")
    private SelenideElement service;

    @FindBy(xpath = "//tbody/tr//td[1]")
    private List<WebElement> numbers;

    @FindBy(xpath = "//tbody/tr//td[3]/a")
    private List<WebElement> users;

    @FindBy(css = ".user-descr span")
    private List<WebElement> descriptions;

    @FindBy(css = ".panel-body-list>li")
    private SelenideElement logRow;

    List<String> numbersList = new LinkedList<>();
    List<String> usersList = new LinkedList<>();
    List<String> descriptionList = new LinkedList<>();
    List<String> dropdownActual = new LinkedList<>();

    @Given("I am on Home Page")
    public void openMainPage() {
        open("https://epam.github.io/JDI/index.html");
    }

    @Step
    @And("I logged in as Piter Chalovslii with login (.+) and password (.+)")
    public void login(String login, String password) {
        loginButton.click();
        loginInput.sendKeys(login);
        paswordInput.sendKeys(password);
        submitButton.click();
    }

    public void openServiceDropdown() {
        service.click();
    }

    @Step
    @When("I open (.+) through the header menu Service")
    public void selectOptionFromServiceDropdown(String option) {
        openServiceDropdown();
        $(By.linkText(option)).click();
    }

    @Step
    @And("I am on Users Table Page")
    public void checkUrl() {
        assertEquals(getWebDriver().getTitle(), "User Table");
    }

    @Step
    @When("I check Number and User columns of Users table")
    public void checkNumbersAndUsers() {
        numbers.forEach(number -> numbersList.add(number.getText()));
        users.forEach(user -> usersList.add(user.getText()));
    }

    @Step
    @Then("User table contain correct values for numbers and users")
    public void checkTableValues(DataTable table) {
        Map<String, String> mapExpected = table.asMap(String.class, String.class);

        List<String> numbersExpected = new LinkedList<>();
        List<String> usersExpected = new LinkedList<>();

        for (Map.Entry<String, String> entry : mapExpected.entrySet()) {
            numbersExpected.add(entry.getKey());
            usersExpected.add(entry.getValue());
        }
        assertThat(numbersExpected, equalTo(numbersList));
        assertThat(usersExpected, equalTo(usersList));
    }

    @Step
    @When("I check Description column of Users table")
    public void getDescription() {
        descriptions.forEach(description -> descriptionList.add(description.getAttribute("innerHTML").replace("<br>", "")));
    }

    @Step
    @Then("All cells of 'Description' column contains text")
    public void checkDescriptionList(DataTable table) {
        Map<String, String> mapExpected = table.asMap(String.class, String.class);

        List<String> numbersExpected = new LinkedList<>();
        List<String> descriptionsExpected = new LinkedList<>();

        for (Map.Entry<String, String> entry : mapExpected.entrySet()) {
            numbersExpected.add(entry.getKey());
            descriptionsExpected.add(entry.getValue());
        }
        assertThat(descriptionsExpected, equalTo(descriptionList));
        assertThat(numbersExpected, equalTo(numbersList));
    }

    @Step
    @When("I set 'vip' status to (.+)")
    public void clickVipStatus(String name) {
        Formatter f = new Formatter();
        String element = f.format("//a[contains(text(), '%s')]/ancestor::tr//input[@type ='checkbox']", name).toString();
        $(By.xpath(element)).click();
    }

    @Step
    @Then("Log section shows a log row in format: (.+): condition changed to (.+)")
    public void checkLog(String field, String status) {
        String actualText = logRow.getText().substring(9, logRow.getText().length());
        Formatter f = new Formatter();
        f.format("%s" + ": condition changed to " + "%s", field, status);
        String expectedText = f.toString();
        assertEquals(actualText, expectedText);
    }

    @Step
    @When("I click on dropdown in column Type for user (.+)")
    public void clickDropdownList(String name) {
        Formatter f = new Formatter();
        String element = f.format("//a[contains(text(), '%s')]/ancestor::tr//select", name).toString();
        $(By.xpath(element)).click();
        $$x(element + "/option").forEach(dropdownElement -> dropdownActual.add(dropdownElement.getText()));
    }

    @Step
    @Then("Dropdownlist contains values")
    public void checkDropdownList(DataTable table) {
        List<String> dropdownExpected = table.asList();

        assertThat(dropdownExpected, equalTo(dropdownActual));
    }
}








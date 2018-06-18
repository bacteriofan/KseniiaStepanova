package pageObjects.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Formatter;
import static com.codeborne.selenide.Condition.text;
import static org.testng.Assert.*;

public class DifferentElementsPage extends MainPage{


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


    @Step
    public void checkCheckboxes() {
        checkboxes.shouldHaveSize(4);
        checkboxes.forEach(checkbox -> assertTrue(checkbox.exists()));
    }

    @Step
    public void checkRadiobuttons() {
        radiobuttons.shouldHaveSize(4);
        radiobuttons.forEach(radiobutton -> assertTrue(radiobutton.exists()));
    }

    @Step
    public void checkDropdown() {
        assertTrue(dropdown.isDisplayed());
    }

    @Step
    public void checkButtons() {
        assertTrue(defaultButton.isDisplayed());
        assertTrue(button.isDisplayed());
    }

    @Step
    public void checkRightSection() {
        assertTrue(rightSection.isDisplayed());
    }

    @Step
    public void checkLeftSection() {
        assertTrue(leftSection.isDisplayed());
    }

    @Step
    public void clickCheckbox(String checkbox) {
        checkboxes.findBy(text(checkbox)).click();
    }

    @Step
    public void selectRadiobutton(String radiobutton) {
        radiobuttons.findBy(text(radiobutton)).click();
    }

    @Step
    public void selectColorFromDropdown (String color) {
        colorsDropdown.selectOptionContainingText(color);
    }

    @Step
    public void checkLog(String checkboxName, boolean status) {
        String statusString = String.valueOf(status);

        String actualText = logRow.getText().substring(9, logRow.getText().length());
        Formatter f = new Formatter();
        f.format("%s" + ": condition changed to " + "%s", checkboxName, statusString);
        String expectedText = f.toString();

        assertEquals(actualText, expectedText);
    }

    @Step
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

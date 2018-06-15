package pageObjects.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.util.Formatter;
import static com.codeborne.selenide.Condition.text;

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



    public void checkCheckboxes() {
        checkboxes.shouldHaveSize(4);
        for (SelenideElement checkbox : checkboxes) {
            checkbox.exists();
        }
    }

    public void checkRadiobuttons() {
        radiobuttons.shouldHaveSize(4);
        for (SelenideElement radiobutton : radiobuttons) {
            radiobutton.exists();
        }
    }

    public void checkDropdown() {
        Assert.assertTrue(dropdown.isDisplayed());
    }

    public void checkButtons() {
        Assert.assertTrue(defaultButton.isDisplayed());
        Assert.assertTrue(button.isDisplayed());
    }

    public void checkRightSection() {
        Assert.assertTrue(rightSection.isDisplayed());
    }

    public void checkLeftSection() {
        Assert.assertTrue(leftSection.isDisplayed());
    }

    public void selectCheckbox(String checkbox) {
        checkboxes.findBy(text(checkbox)).click();
    }

    public void selectRadiobutton(String radiobutton) {
        radiobuttons.findBy(text(radiobutton)).click();
    }

    public void selectColorFromDropdown (String color) {
        colorsDropdown.selectOptionContainingText(color);
    }


    public void checkLog(String checkboxName, String status) {
        String actualText = logRow.getText().substring(9, logRow.getText().length());
        Formatter f = new Formatter();
        f.format("%s" + ": condition changed to " + "%s", checkboxName, status);
        String expectedText = f.toString();

        Assert.assertEquals(actualText, expectedText);
    }

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
        Assert.assertEquals(actualText, expectedText);
    }
}

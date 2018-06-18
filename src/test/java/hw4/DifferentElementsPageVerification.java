package hw4;
import base.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.hw4.DifferentElementsPage;
import pageObjects.hw4.MainPage;

import static enums.Checkbox.WATER;
import static enums.Checkbox.WIND;
import static enums.DropdownList.YELLOW;
import static enums.Radiobutton.SELEN;
import static enums.Users.PITER_CHAILOVSKII;
import static com.codeborne.selenide.Selenide.*;
import static enums.ServiceList.*;



public class DifferentElementsPageVerification extends TestBase {

    private MainPage mainPage;
    private DifferentElementsPage differentElementsPage;

    @BeforeClass
    public void beforeClass() {
        mainPage = page(MainPage.class);
        differentElementsPage = page(DifferentElementsPage.class);
    }

    @Test
    public void pageElementsVerification() {

        //1 open Main Page
        mainPage.openMainPage();

        //2 check browser title
        mainPage.checkBrowserTitle("Home Page");

        //3 login
        mainPage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4 check User Name
        mainPage.checkUserName(PITER_CHAILOVSKII.name);

        //5 check page elements
        mainPage.checkPictures();
        mainPage.checkTextUnderImages();
        mainPage.checkMainHeaderTexts();

        //6 check Service dropdown elements
        mainPage.openServiceDropdown();
        mainPage.checkServiceDropdown();

        //7 check Service elements on left panel
        mainPage.checkServiceLeftPanel();

        //8 open Different Elements page
        mainPage.selectOptionFromServiceDropdown(DIFFERENT_ELEMENTS.option);

        //9 check interface on Different elements page are displayed
        differentElementsPage.checkCheckboxes();
        differentElementsPage.checkRadiobuttons();
        differentElementsPage.checkDropdown();
        differentElementsPage.checkButtons();

        //10 check right section is displayed
        differentElementsPage.checkRightSection();

        //11 check left section is displayed
        differentElementsPage.checkLeftSection();

        //12 select checkboxes and check log
        differentElementsPage.clickCheckbox(WATER.checkbox);
        differentElementsPage.checkLog(WATER.checkbox, true);
        differentElementsPage.clickCheckbox(WIND.checkbox);
        differentElementsPage.checkLog(WIND.checkbox, true);
        
        //13
        differentElementsPage.selectRadiobutton(SELEN.radiobutton);
        differentElementsPage.checkLog(SELEN.radiobutton);

        //14 select color from dropdown
        differentElementsPage.selectColorFromDropdown(YELLOW.row);
        differentElementsPage.checkLog(YELLOW.row);

        //15 uncheck checkboxes
        differentElementsPage.clickCheckbox(WATER.checkbox);
        differentElementsPage.checkLog(WATER.checkbox, false);
        differentElementsPage.clickCheckbox(WIND.checkbox);
        differentElementsPage.checkLog(WIND.checkbox, false);
    }
}

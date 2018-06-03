package hw4;
import base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.hw4.MainPage;
import static enums.Users.PITER_CHAILOVSKII;
import static com.codeborne.selenide.Selenide.*;



public class PageElemetsVerification extends TestBase {

    private MainPage mainPage;

    @BeforeClass
    public void beforeClass() {
        mainPage = page(MainPage.class);
    }

    @AfterMethod
    public void afterMethod() {
    }


    @Test
    public void pageElementsVerifiction() {

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

        //check Service elements on left panel
        mainPage.checkServiceLeftPanel();
    }
}

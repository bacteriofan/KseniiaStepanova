package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.MainPage;


public class MainPageVerification {

    public static MainPage mainPage = new MainPage();
    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void mainPageVerification() {
        //1 open main page
        mainPage.open(driver);

        //2 check main page title
        mainPage.checkMainPageTitle(driver);

        //3 login
        mainPage.login("epam", "1234", "PITER CHAILOVSKII");

        //4 check text items on the header
        mainPage.checkHeaderItemsText();

        //5 check images are displayed
        mainPage.checkImagesAreDisplayed();

        //6 check text texts under images
        //mainPage.checkTextUnderImages();

        //7 check main header test
        mainPage.checkMainHeaderText();

        //8 check sub header text
        mainPage.checkSubHeader();

        //9 check url
        mainPage.checkURL();

        //10 check left section is displayed\
        mainPage.checkLeftSectionIsDisplayed();

        //11 check footer is displayed
        mainPage.checkFooterIsDisplayed();
    }
}
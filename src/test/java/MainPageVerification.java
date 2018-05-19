import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MainPageVerification {
    public static MainPage mainPage;

    @BeforeMethod
    public void setup() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        driver.navigate().to("https://epam.github.io/JDI/index.html");

    }

    @AfterMethod
    public void tearDown() {
        mainPage.driver.quit();
    }


    @Test
    public void mainPageVerification(){

        //1 verification for the title
        Assert.assertEquals(mainPage.driver.getTitle(), "Home Page");

        //2 login and verification for username label and browser title
        mainPage.openLoginForm();
        mainPage.enterCredentials("epam", "1234");
        Assert.assertEquals(mainPage.userNameLabel().getText(), "PITER CHAILOVSKII");
        Assert.assertEquals(mainPage.driver.getTitle(),"Home Page" );

        //3 verification for page headers
        Assert.assertEquals(mainPage.topPanelSectionHome().getText(),"HOME");
        Assert.assertEquals(mainPage.topPanelSectionContactForm().getText(),"CONTACT FORM");
        Assert.assertEquals(mainPage.topPanelSectionService().getText(),"SERVICE");
        Assert.assertEquals(mainPage.topPanelSectionMetalsAndColors().getText(),"METALS & COLORS");

        //4 verification for page pictures
        Assert.assertTrue(mainPage.iconPrictice().isDisplayed());
        Assert.assertTrue(mainPage.iconCustomizible().isDisplayed());
        Assert.assertTrue(mainPage.iconMultiplatform().isDisplayed());
        Assert.assertTrue(mainPage.iconGoodBase().isDisplayed());

        //5 verification for text under pictures
        Assert.assertEquals(mainPage.textBenefit().getText(),
                "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        Assert.assertEquals(mainPage.textCustomizible().getText(),
                "To be flexible and\n" +
                "customizable");
        Assert.assertEquals(mainPage.textMultiplatform().getText(),
                "To be multiplatform");
        Assert.assertEquals(mainPage.textGoodBase().getText(),
                "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");


        //6 verification for text of main header and header itself
        Assert.assertEquals(mainPage.mainHeader().getText(),"EPAM FRAMEWORK WISHES…");
        Assert.assertEquals(mainPage.mainText().getText(),"LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING " +
                "ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS " +
                "NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN " +
                "REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //7 verification for sub header text
        Assert.assertEquals(mainPage.subHeader().getText(),"JDI GITHUB");

        //8 verification for JDI GITHUB link
        mainPage.subHeader().click();
        Assert.assertEquals(mainPage.driver.getTitle(), "GitHub - epam/JDI: JDI is the test Framework for UI test automation");
        Assert.assertEquals(mainPage.driver.getCurrentUrl(), "https://github.com/epam/JDI");
        mainPage.driver.navigate().back();

        //9 verification that left panel is displayed
        Assert.assertTrue(mainPage.leftPanel().isDisplayed());

        //10 verification that footer is displayed
        Assert.assertTrue(mainPage.footer().isDisplayed());

    }

}

package hw4;

import base.TestBase;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.hw4.DatesPage;
import pageObjects.hw4.MainPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static com.codeborne.selenide.Selenide.page;
import static enums.ServiceList.DATES;
import static enums.Users.KSENIIA_STEPANOVA;
import static enums.Users.PITER_CHAILOVSKII;

@Listeners(AllureAttachmentListener.class)
@Features("Selenide tests")
@Stories("Failed test")
public class FailedTest extends TestBase {
    private MainPage mainPage;
    private DatesPage datesPage;


    @BeforeClass
    public void beforeClass() {
        mainPage = page(MainPage.class);
        datesPage = page(DatesPage.class);
    }

    @Test
    public void slidersVerification() {
        //1 open Main Page
        mainPage.openMainPage();

        //2 check browser title
        mainPage.checkBrowserTitle("Home Page");

        //3 login
        mainPage.login(KSENIIA_STEPANOVA.login, KSENIIA_STEPANOVA.password);

        //4 check User Name
        mainPage.checkUserName(PITER_CHAILOVSKII.name);

        //5 open Different Elements page
        mainPage.selectOptionFromServiceDropdown(DATES.option);

        //6 set range from = 0, to = 100
        datesPage.setSliderRange(0, 100);

        //7 check log rows
        datesPage.checkLog(0, 100);

        //8 set range from = 0, to = 0
        datesPage.setSliderRange(0, 0);

        //9 check log rows
        datesPage.checkLog(0, 0);

        //10 set range from = 100, to = 100
        datesPage.setSliderRange(100, 100);

        //11 check log rows
        datesPage.checkLog(100, 100);

        //12 set range from = 30, to = 70
        datesPage.setSliderRange(30, 70);

        //13 check log rows
        datesPage.checkLog(30, 70);
    }

}

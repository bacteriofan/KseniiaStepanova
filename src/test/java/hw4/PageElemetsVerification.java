package hw4;

import base.TestBase;
import org.testng.annotations.Test;
import pageObjects.hw4.MainPage;
import static enums.Users.PITER_CHAILOVSKII;
import static com.codeborne.selenide.Selenide.*;



public class PageElemetsVerification extends TestBase {


    @Test
    public void pageElementsVerifiction() {
        MainPage mainPage = open("https://epam.github.io/JDI/index.html", MainPage.class);
        mainPage.login(PITER_CHAILOVSKII.name, PITER_CHAILOVSKII.password);

    }
}

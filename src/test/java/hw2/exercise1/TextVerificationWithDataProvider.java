package hw2.exercise1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TextVerificationWithDataProvider {

    @DataProvider(name = "TextLocators", parallel = true)
    public static Object[][] text() {
        return new Object[][]{
                {"//span[@class ='icons-benefit icon-practise']/ancestor::div/span[@class='benefit-txt']",
                                "To include good practices\n" +
                                "and ideas from successful\n" +
                                "EPAM project"},
                {"//span[@class ='icons-benefit icon-custom']/ancestor::div/span[@class='benefit-txt']",
                                "To be flexible and\n" +
                                "customizable"},
                {"//span[@class ='icons-benefit icon-multi']/ancestor::div/span[@class='benefit-txt']",
                                "To be multiplatform"},
                {"//span[@class ='icons-benefit icon-base']/ancestor::div/span[@class='benefit-txt']",
                                "Already have good base\n" +
                                "(about 20 internal and\n" +
                                "some external projects),\n" +
                                "wish to get more…"}
        };
    }


    @Test(dataProvider = "TextLocators", threadPoolSize = 4, invocationCount = 1)
    public void checkTexts(String locator, String expectedText) {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        driver.manage().window().maximize();

        WebElement textElement = driver.findElement(By.xpath(locator));
        Assert.assertEquals(textElement.getText(), expectedText);

        driver.quit();
    }
}

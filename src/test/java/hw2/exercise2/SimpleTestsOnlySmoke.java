package hw2.exercise2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SimpleTestsOnlySmoke {

    @Test(groups = "Smoke")
    public void simpleSeleniumTestSmoke1() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1 open test site by url
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 verification for the title
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //3 login
        driver.findElement(By.xpath("//li[@class = 'dropdown uui-profile-menu']")).click();
        driver.findElement(By.id("Name")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".form-horizontal button[type = 'submit']")).click();

        //4 check user name
        WebElement userName = driver.findElement(By.xpath("//span[@ui = 'label']"));
        Assert.assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //5 check the browser title
        Assert.assertEquals(driver.getTitle(),"Home Page" );

        //6 verification for page headers
        List<String> expectedHeaders = new ArrayList<String>();
        expectedHeaders.add("HOME");
        expectedHeaders.add("CONTACT FORM");
        expectedHeaders.add("SERVICE");
        expectedHeaders.add("METALS & COLORS");

        List<String> actualHeaders = new ArrayList<String>();

        List<WebElement> headersElements = driver.findElements(By.xpath("//ul[@class = 'uui-navigation nav navbar-nav m-l8']/li"));
        for (WebElement header : headersElements) {
            actualHeaders.add(header.getText());
        }
        Assert.assertEquals(actualHeaders, expectedHeaders);


        //7 verification for page pictures
        List<WebElement> pictures = driver.findElements(By.xpath("//div[@class = 'benefit']/div[@class = 'benefit-icon']"));
        for (WebElement picture : pictures) {
            Assert.assertTrue(picture.isDisplayed());
        }


        //8 check text under pictures
        String firstPicture = driver.findElement(By.xpath("//span[@class ='icons-benefit icon-practise']/ancestor::div/span[@class='benefit-txt']")).getText();
        Assert.assertEquals(firstPicture,
                    "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project");

        String secondPicture = driver.findElement(By.xpath("//span[@class ='icons-benefit icon-custom']/ancestor::div/span[@class='benefit-txt']")).getText();
        Assert.assertEquals(secondPicture,
                    "To be flexible and\n" + "customizable");

        String thirdPicture = driver.findElement(By.xpath("//span[@class ='icons-benefit icon-multi']/ancestor::div/span[@class='benefit-txt']")).getText();
        Assert.assertEquals(thirdPicture,
                    "To be multiplatform");

        String fourthPicture = driver.findElement(By.xpath("//span[@class ='icons-benefit icon-base']/ancestor::div/span[@class='benefit-txt']")).getText();
        Assert.assertEquals(fourthPicture,
                    "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…");


        //9 check text of main header
        Assert.assertEquals(driver.findElement(By.xpath("//h3[@name = 'main-title']")).getText(),"EPAM FRAMEWORK WISHES…");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@name = 'jdi-text']")).getText(),"LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING " +
                "ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS " +
                "NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN " +
                "REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 check sub header text
        Assert.assertEquals(driver.findElement(By.xpath("//a[contains(text(),'JDI Github')]")).getText(),"JDI GITHUB");

        //11 verification for JDI GITHUB link
        String linkAtrribute = driver.findElement(By.xpath("//a[contains(text(),'JDI Github')]")).getAttribute("href");
        Assert.assertEquals(linkAtrribute, "https://github.com/epam/JDI");

        //12 verification that left panel is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id = 'mCSB_1_container']")).isDisplayed());

        //13 verification that footer is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'footer-content overflow']")).isDisplayed());

        //14 close browser
        driver.close();

    }


    @Test(groups = "Smoke")
    public void simpleSeleniumTestSmoke2() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1 open test site by url
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 verification for the title
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //3 login
        driver.findElement(By.xpath("//li[@class = 'dropdown uui-profile-menu']")).click();
        driver.findElement(By.id("Name")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".form-horizontal button[type = 'submit']")).click();

        //4 check user name
        WebElement userName = driver.findElement(By.xpath("//span[@ui = 'label']"));
        Assert.assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //5 check the browser title
        Assert.assertEquals(driver.getTitle(),"Home Page" );

        //6 verification for page headers
        List<String> expectedHeaders = new ArrayList<>();
        expectedHeaders.add("HOME");
        expectedHeaders.add("CONTACT FORM");
        expectedHeaders.add("SERVICE");
        expectedHeaders.add("METALS & COLORS");

        List<String> actualHeaders = new ArrayList<>();

        List<WebElement> headersElements = driver.findElements(By.xpath("//ul[@class = 'uui-navigation nav navbar-nav m-l8']/li"));
        for (WebElement header : headersElements) {
            actualHeaders.add(header.getText());
        }
        Assert.assertEquals(actualHeaders, expectedHeaders);


        //7 verification for page pictures
        List<WebElement> pictures = driver.findElements(By.xpath("//div[@class = 'benefit']/div[@class = 'benefit-icon']"));
        for (WebElement picture : pictures) {
            Assert.assertTrue(picture.isDisplayed());
        }


        //8 check text under pictures
        String firstPicture = driver.findElement(By.xpath("//span[@class ='icons-benefit icon-practise']/ancestor::div/span[@class='benefit-txt']")).getText();
        Assert.assertEquals(firstPicture,
                    "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project");

        String secondPicture = driver.findElement(By.xpath("//span[@class ='icons-benefit icon-custom']/ancestor::div/span[@class='benefit-txt']")).getText();
        Assert.assertEquals(secondPicture,
                     "To be flexible and\n" + "customizable");

        String thirdPicture = driver.findElement(By.xpath("//span[@class ='icons-benefit icon-multi']/ancestor::div/span[@class='benefit-txt']")).getText();
        Assert.assertEquals(thirdPicture,
                    "To be multiplatform");

        String fourthPicture = driver.findElement(By.xpath("//span[@class ='icons-benefit icon-base']/ancestor::div/span[@class='benefit-txt']")).getText();
        Assert.assertEquals(fourthPicture,
                    "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…");


        //9 check text of main header
        Assert.assertEquals(driver.findElement(By.xpath("//h3[@name = 'main-title']")).getText(),"EPAM FRAMEWORK WISHES…");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@name = 'jdi-text']")).getText(),"LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING " +
                "ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS " +
                "NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN " +
                "REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 check sub header text
        Assert.assertEquals(driver.findElement(By.xpath("//a[contains(text(),'JDI Github')]")).getText(),"JDI GITHUB");

        //11 verification for JDI GITHUB link
        String linkAtrribute = driver.findElement(By.xpath("//a[contains(text(),'JDI Github')]")).getAttribute("href");
        Assert.assertEquals(linkAtrribute, "https://github.com/epam/JDI");

        //12 verification that left panel is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id = 'mCSB_1_container']")).isDisplayed());

        //13 verification that footer is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'footer-content overflow']")).isDisplayed());

        //14 close browser
        driver.close();

    }

    @Test(groups = "Smoke")
    public void simpleSeleniumTestSmoke3() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1 open test site by url
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 verification for the title
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //3 login
        driver.findElement(By.xpath("//li[@class = 'dropdown uui-profile-menu']")).click();
        driver.findElement(By.id("Name")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".form-horizontal button[type = 'submit']")).click();

        //4 check user name
        WebElement userName = driver.findElement(By.xpath("//span[@ui = 'label']"));
        Assert.assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //5 check the browser title
        Assert.assertEquals(driver.getTitle(),"Home Page" );

        //6 verification for page headers
        List<String> expectedHeaders = new ArrayList<String>();
        expectedHeaders.add("HOME");
        expectedHeaders.add("CONTACT FORM");
        expectedHeaders.add("SERVICE");
        expectedHeaders.add("METALS & COLORS");

        List<String> actualHeaders = new ArrayList<String>();

        List<WebElement> headersElements = driver.findElements(By.xpath("//ul[@class = 'uui-navigation nav navbar-nav m-l8']/li"));
        for (WebElement header : headersElements) {
            actualHeaders.add(header.getText());
        }
        Assert.assertEquals(actualHeaders, expectedHeaders);


        //7 verification for page pictures
        List<WebElement> pictures = driver.findElements(By.xpath("//div[@class = 'benefit']/div[@class = 'benefit-icon']"));
        for (WebElement picture : pictures) {
            Assert.assertTrue(picture.isDisplayed());
        }


        //8 check text under pictures
        String firstPicture = driver.findElement(By.xpath("//span[@class ='icons-benefit icon-practise']/ancestor::div/span[@class='benefit-txt']")).getText();
        Assert.assertEquals(firstPicture,
                    "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project");

        String secondPicture = driver.findElement(By.xpath("//span[@class ='icons-benefit icon-custom']/ancestor::div/span[@class='benefit-txt']")).getText();
        Assert.assertEquals(secondPicture,
                    "To be flexible and\n" + "customizable");

        String thirdPicture = driver.findElement(By.xpath("//span[@class ='icons-benefit icon-multi']/ancestor::div/span[@class='benefit-txt']")).getText();
        Assert.assertEquals(thirdPicture,
                    "To be multiplatform");

        String fourthPicture = driver.findElement(By.xpath("//span[@class ='icons-benefit icon-base']/ancestor::div/span[@class='benefit-txt']")).getText();
        Assert.assertEquals(fourthPicture,
                    "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…");


        //9 check text of main header
        Assert.assertEquals(driver.findElement(By.xpath("//h3[@name = 'main-title']")).getText(),"EPAM FRAMEWORK WISHES…");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@name = 'jdi-text']")).getText(),"LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING " +
                "ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS " +
                "NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN " +
                "REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 check sub header text
        Assert.assertEquals(driver.findElement(By.xpath("//a[contains(text(),'JDI Github')]")).getText(),"JDI GITHUB");

        //11 verification for JDI GITHUB link
        String linkAtrribute = driver.findElement(By.xpath("//a[contains(text(),'JDI Github')]")).getAttribute("href");
        Assert.assertEquals(linkAtrribute, "https://github.com/epam/JDI");

        //12 verification that left panel is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id = 'mCSB_1_container']")).isDisplayed());

        //13 verification that footer is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'footer-content overflow']")).isDisplayed());

        //14 close browser
        driver.close();

    }
}


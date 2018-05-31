package base;

import static java.lang.System.setProperty;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    @BeforeSuite
    public void beforeSuit() {
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(System.currentTimeMillis());
    }

}

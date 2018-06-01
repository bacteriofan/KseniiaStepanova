package base;

import static java.lang.System.setProperty;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    private long initTime;


    @AfterSuite
    public void afterSuite() {
        System.out.println(System.currentTimeMillis());
    }

    @BeforeSuite
    public void beforeSuite() {
        initTime = System.currentTimeMillis();

        Configuration.browser = "chrome";
        Configuration.screenshots = false;
        Configuration.timeout = 10000;
        Configuration.pollingInterval = 200;
        Configuration.collectionsPollingInterval = 350;
    }
}

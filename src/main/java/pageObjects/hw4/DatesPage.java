package pageObjects.hw4;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.Formatter;
import java.util.List;
import static com.codeborne.selenide.Selenide.actions;
import static org.testng.Assert.*;


public class DatesPage extends MainPage {

    @FindBy(css = "a.ui-slider-handle.ui-state-default.ui-corner-all")
    private List<SelenideElement> sliderTracks;

    @FindBy(css = ".panel-body-list>li")
    private List<SelenideElement> logRow;

    @Step
    public void setSliderRange(int from, int to) {
        actions().dragAndDropBy(sliderTracks.get(0), -2000, 0).build().perform();
        actions().dragAndDropBy(sliderTracks.get(1), 2000, 0).build().perform();

        double scrollPanelLength = sliderTracks.get(1).getLocation().getX() - sliderTracks.get(0).getLocation().getX();
        double step = scrollPanelLength / 100;

        actions().dragAndDropBy(sliderTracks.get(0), (int) (from * step - ((from > 0) ? 0.5 * step : step)), 0).build()
                .perform();
        actions().dragAndDropBy(sliderTracks.get(1), (int) (-((100 - to) * step + step)), 0).build().perform();

        assertEquals(Integer.parseInt(sliderTracks.get(0).getText()), from);
        assertEquals(Integer.parseInt(sliderTracks.get(1).getText()), to);

    }


    @Step
    public void checkLog(int fromValue, int toValue) {
        String fromValueString = String.valueOf(fromValue);
        String toValueString = String.valueOf(toValue);

        String actualTextTo = logRow.get(0).getText().substring(9, logRow.get(0).getText().length());
        Formatter f = new Formatter();
        f.format("Range 2(To):" + "%s" + " link clicked", toValueString);
        String expectedTo = f.toString();

        assertEquals(actualTextTo, expectedTo);

        Formatter f2 = new Formatter();
        String actualTextFrom = logRow.get(1).getText().substring(9, logRow.get(1).getText().length());
        f2.format("Range 2(From):" + "%s" + " link clicked", fromValueString);
        String expectedFrom = f2.toString();

        assertEquals(actualTextFrom, expectedFrom);
    }
}

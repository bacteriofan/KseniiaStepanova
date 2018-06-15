package pageObjects.hw4;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.util.Formatter;
import java.util.List;
import static com.codeborne.selenide.Selenide.actions;


public class DatesPage extends MainPage {

    @FindBy(css = "a.ui-slider-handle.ui-state-default.ui-corner-all")
    private List<SelenideElement> sliderTracks;

    @FindBy(css = ".panel-body-list>li")
    private List<SelenideElement> logRow;

    public void setSliderRange(int from, int to) {
        actions().dragAndDropBy(sliderTracks.get(0), -2000, 0).build().perform();
        actions().dragAndDropBy(sliderTracks.get(1), 2000, 0).build().perform();

        double scrollPanelLength = sliderTracks.get(1).getLocation().getX() - sliderTracks.get(0).getLocation().getX();
        double step = scrollPanelLength / 100;

        actions().dragAndDropBy(sliderTracks.get(0), (int) (from * step - ((from > 0) ? 0.5 * step : step)), 0).build()
                .perform();
        actions().dragAndDropBy(sliderTracks.get(1), (int) (-((100 - to) * step + step)), 0).build().perform();

        Assert.assertEquals(Integer.parseInt(sliderTracks.get(0).getText()), from);
        Assert.assertEquals(Integer.parseInt(sliderTracks.get(1).getText()), to);

    }

    public void checkLog(String fromValue, String toValue) {
        String actualTextTo = logRow.get(0).getText().substring(9, logRow.get(0).getText().length());
        Formatter f = new Formatter();
        f.format("Range 2(To):" + "%s" + " link clicked", toValue);
        String expectedTo = f.toString();

        Assert.assertEquals(actualTextTo, expectedTo);

        Formatter f2 = new Formatter();
        String actualTextFrom = logRow.get(1).getText().substring(9, logRow.get(1).getText().length());
        f2.format("Range 2(From):" + "%s" + " link clicked", fromValue);
        String expectedFrom = f2.toString();

        Assert.assertEquals(actualTextFrom, expectedFrom);
    }
}

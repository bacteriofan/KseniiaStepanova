import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;



    @FindBy(xpath = "//li[@class = 'dropdown uui-profile-menu']")
    private WebElement loginButton;

    @FindBy(id = "Name")
    private WebElement usernameField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement submitCredentials;

    @FindBy(xpath = "//span[@ui = 'label']")
    private WebElement userNameLabel;

    @FindBy(xpath = "//h3[@name = 'main-title']")
    private WebElement mainHeader;

    @FindBy(xpath = "//p[@name = 'jdi-text']")
    private WebElement mainText;

    @FindBy(xpath = "//a[contains(text(),'JDI Github')]")
    private WebElement subHeader;

    @FindBy(xpath = "//div[@id = 'mCSB_1_container']")
    private WebElement leftPanel;

    @FindBy(xpath = "//div[@class = 'footer-content overflow']")
    private WebElement footer;


    // main page top panel sections
    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement topPanelSectionHome;

    @FindBy(xpath = "//a[contains(text(),'Contact form')]")
    private WebElement topPanelSectionContactForm;

    @FindBy(xpath = "//a[contains(text(),'Service')]")
    private WebElement topPanelSectionService;

    @FindBy(xpath = "//a[contains(text(),'Metals & Colors')]")
    private WebElement topPanelSectionMetalsAndColors;



    // main page pictures
    @FindBy(xpath = "//span[@class ='icons-benefit icon-practise']")
    private WebElement iconBenefit;

    @FindBy(xpath = "//span[@class ='icons-benefit icon-custom']")
    private WebElement iconCustomizible;

    @FindBy(xpath = "//span[@class ='icons-benefit icon-multi']")
    private WebElement iconMultiplatform;

    @FindBy(xpath = "//span[@class ='icons-benefit icon-base']")
    private WebElement iconGoodBase;



    // text under page pictures
    @FindBy(xpath = "//span[@class ='icons-benefit icon-practise']/ancestor::div/span[@class='benefit-txt']")
    private WebElement textBenefit;

    @FindBy(xpath = "//span[@class ='icons-benefit icon-custom']/ancestor::div/span[@class='benefit-txt']")
    private WebElement textCustomizible;

    @FindBy(xpath = "//span[@class ='icons-benefit icon-multi']/ancestor::div/span[@class='benefit-txt']")
    private WebElement textMultiplatform;

    @FindBy(xpath = "//span[@class ='icons-benefit icon-base']/ancestor::div/span[@class='benefit-txt']")
    private WebElement textGoodBase;

    //---------------------------------------------------------------------------------------------------------------------

    public void openLoginForm () {
        loginButton.click();
    }
    public void enterCredentials (String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitCredentials.click();
    }
    public WebElement userNameLabel() {
        return userNameLabel;
    }
    public WebElement mainHeader() {
        return mainHeader;
    }
    public WebElement subHeader() {
        return subHeader;
    }
    public WebElement mainText() {
        return mainText;
    }
    public WebElement leftPanel() {
        return  leftPanel;
    }
    public WebElement footer() {
        return  footer;
    }


    // top panel sections
    public WebElement topPanelSectionHome() {
        return topPanelSectionHome;
    }
    public WebElement topPanelSectionContactForm() {
        return topPanelSectionContactForm;
    }
    public WebElement topPanelSectionService() {
        return topPanelSectionService;
    }
    public WebElement topPanelSectionMetalsAndColors() {
        return topPanelSectionMetalsAndColors;
    }

    // pictures
    public WebElement iconPrictice() {
        return iconBenefit;
    }
    public WebElement iconCustomizible() {
        return iconCustomizible;
    }
    public WebElement iconMultiplatform() {
        return iconMultiplatform;
    }
    public WebElement iconGoodBase() {
        return iconGoodBase;
    }



    // text under pictures
    public WebElement textBenefit() {
        return textBenefit;
    }
    public WebElement textCustomizible() {
        return textCustomizible;
    }
    public WebElement textMultiplatform() {
        return textMultiplatform;
    }
    public WebElement textGoodBase() {
        return textGoodBase;
    }


}

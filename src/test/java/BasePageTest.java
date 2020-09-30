import common.DriverProvider;
import common.ErrorMessages;
import constants.CommonConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;

/**
 * This is an example test class with test method
 * For each functionality a method from SoftAssert class (assertTrue(), assertEquals() etc.)
 *
 */
public class BasePageTest {
    private WebDriver driver;
    private DriverProvider driverProvider = new DriverProvider();
    private String driverType = "chrome";
    private BasePage basePage;

    @BeforeClass
    public void setup() {
        this.driver = driverProvider.getDriver(driverType);
        this.basePage = new BasePage(this.driver);
        this.driver.get("https://4elephdm8mixik1a-15688443.shopifypreview.com/");
        this.basePage.waitUntilPageLoaded();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test()
    public void verifyPopupSectionHasCorrectFunctionality() {
        //After execution, for each failed assertion, in terminal will shown an error message, where engineer
        //can find expected and actual results
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(this.basePage.getPopupSection().isDisplayed(), ErrorMessages.POPUP_SECTION_ERROR);
        softAssert.assertTrue(this.basePage.getPopupCloseIcon().isDisplayed(), ErrorMessages.POPUP_CLOSE_ICON_ERROR);
        softAssert.assertTrue(this.basePage.getPopupEmailInput().isDisplayed(), ErrorMessages.EMAIL_INPUT_VISIBILITY_ERROR);
        softAssert.assertTrue(this.basePage.getSendMeACouponButton().isDisplayed(), ErrorMessages.SEND_ME_A_COUPON_BUTTON_ERROR);
        softAssert.assertTrue(this.basePage.getNoThanksLink().isDisplayed(), ErrorMessages.NO_THANKS_LINK_ERROR);
        softAssert.assertEquals(this.basePage.getNoThanksLink().getText(), CommonConstants.NO_THANKS_I_DON_T_LIKE_DISCOUNTS,
                ErrorMessages.TEXT_ERROR);
        this.basePage.setEmail(CommonConstants.EMAIL);
        boolean isRedirected = this.basePage.clickOnSendCouponButton();
        softAssert.assertTrue(isRedirected, ErrorMessages.REDIRECTION_ERROR);
        softAssert.assertAll();
    }


}

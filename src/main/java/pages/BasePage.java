package pages;

import common.Helper;
import constants.BasePageConstants;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This is a page class example, where implemented page functionality (elements, clicks, inputs etc.)
 */
public class BasePage extends Helper {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WebElement getPopupSection() {
        WebElement popupSection = findElementByCssSelector(BasePageConstants.POPUP_SECTION);
        waitTillElementIsVisible(popupSection);
        return popupSection;
    }

    public WebElement getPopupCloseIcon() {
        WebElement popupCloseIcon = findElementByCssSelector(BasePageConstants.POPUP_CLOSE_ICON);
        waitTillElementIsVisible(popupCloseIcon);
        return popupCloseIcon;
    }

    public WebElement getPopupEmailInput() {
        WebElement popupEmailInput = findElementByCssSelector(BasePageConstants.POPUP_EMAIL_INPUT);
        waitTillElementIsVisible(popupEmailInput);
        return popupEmailInput;
    }

    public WebElement getSendMeACouponButton() {
        WebElement sendMeACouponButton = findElementByCssSelector(BasePageConstants.SEND_ME_A_COUPON_BUTTON);
        waitTillElementIsVisible(sendMeACouponButton);
        return sendMeACouponButton;
    }

    public WebElement getNoThanksLink() {
        WebElement noThanksLink = findElementByCssSelector(BasePageConstants.NO_THANKS);
        waitTillElementIsVisible(noThanksLink);
        return noThanksLink;
    }

    public WebElement getDesktopLogo(){
        WebElement desktopLogo = findElementByCssSelector(BasePageConstants.DESKTOP_LOGO);
        waitTillElementIsVisible(desktopLogo);
        return desktopLogo;
    }

    public boolean clickOnSendCouponButton() {
        try {
            getSendMeACouponButton().click();
            waitTillElementIsInvisible(getSendMeACouponButton());
            return true;
        } catch (TimeoutException | NoSuchElementException ex) {
            return false;
        }
    }

    public void setEmail(String email) {
        getPopupEmailInput().click();
        getPopupEmailInput().sendKeys(email);
    }
}

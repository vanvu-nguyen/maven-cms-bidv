package pageObjects.adminSite;

import PageUIs.adminSite.LoginPUI;
import commons.BaseAction;
import commons.GlobalConstants;
import pageGenerator.AdminPageGeneratorManager;
import org.openqa.selenium.WebDriver;

public class LoginPO extends BaseAction {
    private WebDriver driver;

    public LoginPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }



    public void userLogin(String userName, String passWord) {
        waitForElementVisible(driver, LoginPUI.USER_ID_TEXTBOX);
        senkeyToElement(driver, LoginPUI.USER_ID_TEXTBOX, userName);
        waitForElementVisible(driver, LoginPUI.PASSWORD_TEXTBOX);
        senkeyToElement(driver, LoginPUI.PASSWORD_TEXTBOX, passWord);
        waitForElementClickable(driver, LoginPUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPUI.LOGIN_BUTTON);
    }

    public DashboardPO resetPassword() {
        waitForElementVisible(driver, LoginPUI.NEW_PASSWORD_TEXTBOX);
        senkeyToElement(driver, LoginPUI.NEW_PASSWORD_TEXTBOX, GlobalConstants.getGlobalConstants().getCommon_password());
        waitForElementVisible(driver, LoginPUI.CONFIRM_PASSWORD_TEXTBOX);
        senkeyToElement(driver, LoginPUI.CONFIRM_PASSWORD_TEXTBOX, GlobalConstants.getGlobalConstants().getCommon_password());
        waitForElementClickable(driver, LoginPUI.APPLY_BUTTON);
        clickToElement(driver, LoginPUI.APPLY_BUTTON);
        return AdminPageGeneratorManager.getAdminDashboardPage(driver);
    }

    public void selectEnglishLanguage() {
        selectItemInCustomDropdown(driver, LoginPUI.LANGUAGE_DROPDOWN_PARENT_LOCATOR, LoginPUI.LANGUAGE_DROPDOWN_CHILD_LOCATOR, "English");
    }
}

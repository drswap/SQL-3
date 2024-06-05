package ru.netology.bank.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.bank.data.DataHelper;

import java.util.Objects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");
    private SelenideElement errorNotification = $("[data-test-id=error-notification]");

    public void verifyErrorNotificationVisibility() {
        errorNotification.shouldBe(visible);
    }

    public void verifyPageVisible() {
        loginField.shouldBe(visible);
    }

    public ru.netology.bank.page.AuthorizationCodePage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new ru.netology.bank.page.AuthorizationCodePage();
    }

    public void login(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
    }
    public void clearForm() {
        loginField.click();
        while(!Objects.equals(loginField.getValue(), "")){
            loginField.sendKeys(Keys.BACK_SPACE);
        }
        loginField.sendKeys(Keys.BACK_SPACE);
        passwordField.click();
        while(!Objects.equals(passwordField.getValue(), "")){
            passwordField.sendKeys(Keys.BACK_SPACE);
        }
    }
    public void clearFormPassword() {
        passwordField.click();
        passwordField.sendKeys(Keys.SHIFT, Keys.HOME, Keys.BACK_SPACE);// можно удалить данные из поля таким способом
//        while(!Objects.equals(passwordField.getValue(), "")){  // или таким, с помощью цикла while
//            passwordField.sendKeys(Keys.BACK_SPACE);
//        }
    }
}

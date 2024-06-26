package ru.netology.bank.page;


import com.codeborne.selenide.SelenideElement;
import ru.netology.bank.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizationCodePage {
    private SelenideElement codeField = $("[data-test-id=code] input");
    private SelenideElement verifyButton = $("[data-test-id=action-verify]");
    private SelenideElement errorNotification = $("[data-test-id=error-notification]");

    public AuthorizationCodePage() {
    }

    public void verifyPageVisible() {
        codeField.shouldBe(visible);
    }

    public void verifyErrorNotificationVisibility() {
        errorNotification.shouldBe(visible);
    }

    public PersonalAccountPage validVerify(DataHelper.VerificationCode verificationCode) {
        codeField.setValue(verificationCode.getCode());
        verifyButton.click();
        return new PersonalAccountPage();
    }

    public void verify(DataHelper.VerificationCode verificationCode) {
        codeField.shouldBe(visible);
        codeField.setValue(verificationCode.getCode());
        verifyButton.click();
    }
}


package ru.netology.bank.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PersonalAccountPage {
    private final SelenideElement heading = $("[data-test-id=dashboard]");

    public PersonalAccountPage() {
        heading.shouldBe(visible);
    }
}

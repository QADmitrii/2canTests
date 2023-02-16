package ui.pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    //Elements
    private SelenideElement

            username = $("#username"),
            myInteresting = $(".vue-treeselect__placeholder").find("vue-treeselect__arrow"),
            phone = $("#phone"),
            email = $("#email"),
            emailVerify = $("#emailVerify"),
            password = $("#password"),
            country = $(byText("Выберите страну")),
            hourzone = $(byText("Выберите часовой пояс")),
            promo = $("#promo"),
            checkagree = $(byText("Я ознакомился и согласен с условиями"));


    public RegistrationPage openPage() {
        open("https://dev02.my2can.com/admin/sign-up#stepA");

        $(".onboarding__box").shouldHave(text("Создайте свой аккаунт"));

        return this;
    }

    public RegistrationPage setUsername(String value) {
        username.setValue(value);

        return this;
    }

    public RegistrationPage setMyInteresting() {
        myInteresting.click();
//        $(byText("Касса")).click();


        return this;
    }

    public RegistrationPage setPhone(String value) {
        phone.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        email.setValue(value);

        return this;
    }

    public RegistrationPage setEmailVerify(String value) {
        emailVerify.setValue(value);

        return this;
    }

    public RegistrationPage setPassword(String value) {
        password.setValue(value);

        return this;
    }

    public RegistrationPage setCountry(String value) {
        country.setValue(value);

        return this;
    }

    public RegistrationPage setHourZone(String value) {
        hourzone.setValue(value);

        return this;
    }

    public RegistrationPage setPromo(String value) {
        promo.setValue(value);

        return this;
    }

    public RegistrationPage clickCheckAgree() {
        checkagree.click();

        return this;
    }

    public RegistrationPage clickReg() {
        $("#formStorageSubmit").click();

        return this;
    }
}


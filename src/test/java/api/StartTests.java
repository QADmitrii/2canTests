package api;

import api.registration.PassRecoveryTest;
import api.registration.RegistrationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.pageobject.RegistrationPage;


import static api.data.userdata.UserData.*;

public class StartTests {
    static PassRecoveryTest passRecoveryTest = new PassRecoveryTest();
    static RegistrationTest registrationTest = new RegistrationTest();
    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    @DisplayName("Registration new account. Positive")
    public void registrationTestsPositive() {

        registrationTest.registrationTestSuccessful();

    }

    @Test
    @DisplayName("Registration new account. Negative")
    public void registrationTestsNegative() {

        registrationTest.registrationTestIncorrectData();
        registrationTest.registrationTestUsedEmail();
        registrationTest.registrationTestWithoutPass();
        registrationTest.registrationTestWithoutUsername();
        registrationTest.registrationTestWithoutEmail();

    }

    @Test
    @DisplayName("Recovery password")
    public void recoveryTests() {
        passRecoveryTest.recoveryTestSuccessful();
        passRecoveryTest.recoveryTestNotExist();
    }


    @Test
    @DisplayName("UI Registration")
    public void uiRegistration() {
        registrationPage.openPage()
                .setUsername(username)
//        .setMyInteresting()
                .setPhone(phone)
                .setEmail(email)
                .setEmailVerify(emailVerify)
                .setPassword(password)
//        .setCountry(country)
//        .setHourZone(hourzone)
                .setPromo(promo)
                .clickCheckAgree()
                .clickReg();
    }

}

package api;

import api.registration.PassRecoveryTest;
import api.registration.RegistrationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StartTests {
    static PassRecoveryTest passRecoveryTest = new PassRecoveryTest();
    static RegistrationTest registrationTest = new RegistrationTest();

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

}

package api.registration;

import api.data.userdata.UserData;
import api.models.LombokBody;
import api.models.LombokResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static api.specs.ErrorsSpecs.errorResponseEmail;
import static api.specs.RegSpecs.regRequestSpec;
import static api.specs.RegSpecs.regResponseSpec;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationTest {

    UserData userData = new UserData();

    @Test
    @DisplayName("Positive. Registration account")
    public void registrationTestSuccessful() {
        LombokBody body = new LombokBody();

        body.setEmail(userData.email);
        body.setPassword(userData.password);
        body.setUsername(userData.username);
//        body.setPhone("");
//        body.setConfig("4");
//        body.setLocale("ru_RU");
//        body.setC_code("RU");
//        body.setTimezone("Europe/Moscow");
//        body.setCurrency_code("RUB");

        given()
                .spec(regRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                .spec(regResponseSpec)
                .extract()
                .as(LombokResponse.class);
    }

    @Test
    @DisplayName("Negative. Registration without email")
    public void registrationTestWithoutEmail() {
        LombokBody body = new LombokBody();

        body.setPassword(userData.password);
        body.setUsername(userData.username);

        LombokResponse response = given()
                .spec(regRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                .spec(errorResponseEmail)
                .extract()
                .as(LombokResponse.class);

        }

    @Test
    @DisplayName("Negative. Registration without pass")
    public void registrationTestWithoutPass() {
        LombokBody body = new LombokBody();

        body.setEmail(userData.email);
        body.setUsername(userData.username);

        LombokResponse response = given()
                .spec(regRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                .spec(regResponseSpec)
                .extract()
                .as(LombokResponse.class);

    }

    @Test
    @DisplayName("Negative. Registration without username")
    public void registrationTestWithoutUsername() {
        LombokBody body = new LombokBody();

        body.setEmail(userData.email);
        body.setPassword(userData.password);

        LombokResponse response = given()
                .spec(regRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                .spec(regResponseSpec)
                .extract()
                .as(LombokResponse.class);

    }
}

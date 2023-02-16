package api.registration;

import api.data.userdata.UserData;
import api.models.LombokBody;
import api.models.LombokResponse;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static api.specs.ErrorsSpecs.errorRegResponse;
import static api.specs.ErrorsSpecs.errorRegResponseEmail;
import static api.specs.RegSpecs.regRequestSpec;
import static api.specs.RegSpecs.regResponseSpec;
import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationTest {

//    @Test
//    public void test(){
//        post("https://dev01.my2can.com/rest/rest_auth.json/0?action=getToken").getBody().print();
//    }
    @Test
    @DisplayName("Positive. Registration account")
    public void registrationTestSuccessful() {
        UserData userData = new UserData();
        LombokBody body = new LombokBody();

        body.setEmail(userData.email);
        body.setPassword(userData.password);
        body.setUsername(userData.username);
        body.setPhone("+79168587588");
        body.setConfig("4");
        body.setLocale("ru_RU");
        body.setC_code("RU");
        body.setTimezone("Europe/Moscow");
        body.setCurrency_code("RUB");

        given()
                .spec(regRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                .spec(regResponseSpec)
                .extract()
                .as(LombokResponse.class);


        open("https://dev01.my2can.com/admin/sign-in");
        $("#email").setValue(userData.email);
        $("#password").setValue(userData.password);
        $("[type=button]").click();
        sleep(5000);
        $("#sidebar").shouldBe(Condition.visible);

//        post("https://dev01.my2can.com/rest/rest_auth.json/0?action=getToken").getBody().print();

    }

    @Test
    @DisplayName("Negative. Registration without email")
    public void registrationTestWithoutEmail() {
        UserData userData = new UserData();
        LombokBody body = new LombokBody();

        body.setPassword(userData.password);
        body.setUsername(userData.username);

        LombokResponse response = given()
                .spec(regRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                .spec(errorRegResponseEmail)
                .extract()
                .as(LombokResponse.class);

    }

    @Test
    @DisplayName("Negative. Registration used email")
    public void registrationTestUsedEmail() {
        LombokBody body = new LombokBody();

        body.setEmail("d.butov@smart-fin.ru");

        LombokResponse response = given()
                .spec(regRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                .spec(errorRegResponse)
                .extract()
                .as(LombokResponse.class);

    }

    @Test
    @DisplayName("Negative. Registration without pass")
    public void registrationTestWithoutPass() {
        UserData userData = new UserData();
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
        UserData userData = new UserData();
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

    @Test
    @DisplayName("Negative. Registration incorrect data")
    public void registrationTestIncorrectData() {
        LombokBody body = new LombokBody();

        body.setEmail("#$#$!@22@ff.@ff");
        body.setPassword("@%^%$&$^#$%@");
        body.setUsername("$!@!$1@$^$&$5345");
        body.setPhone("%^$%&#$%!@#%");
        body.setConfig("1");
        body.setLocale("ru_RUUUU");
        body.setC_code("RUKrt");
        body.setTimezone("Europer/Moscowic");
        body.setCurrency_code("RUBER");

        LombokResponse response = given()
                .spec(regRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                .spec(errorRegResponse)
                .extract()
                .as(LombokResponse.class);

    }
}

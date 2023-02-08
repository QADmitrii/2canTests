package api.registration;

import api.models.LombokBody;
import api.models.LombokResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static api.specs.RegSpecs.regRequestSpec;
import static api.specs.RegSpecs.regResponseSpec;
import static io.restassured.RestAssured.given;

public class RegistrationTest {

    @Test
    @DisplayName("Positive. Registration account")
    public void registrationTest() {
        LombokBody body = new LombokBody();

        body.setEmail("eveholt@reqres.com");
        body.setPassword("123456");
        body.setUsername("gog");
        body.setPhone("");
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


    }
}

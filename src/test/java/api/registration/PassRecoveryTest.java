package api.registration;

import api.models.LombokBody;
import api.models.LombokResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static api.specs.ErrorsSpecs.errorRecoveryResponse;
import static api.specs.RecoverSpecs.recoverRequestSpec;
import static api.specs.RecoverSpecs.recoverResponseSpec;
import static io.restassured.RestAssured.given;

public class PassRecoveryTest {

    @Test
    @DisplayName("Positive. Success recovery")
    public void recoveryTestSuccessful() {
        LombokBody body = new LombokBody();

        body.setEmail("d.butov+16@smart-fin.ru");
        given()
                .spec(recoverRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                .spec(recoverResponseSpec)
                .extract()
                .as(LombokResponse.class);
    }
    @Test
    @DisplayName("Negative. User does not exist")
    public void recoveryTestNotExist() {
        LombokBody body = new LombokBody();

        body.setEmail("d.butov000@smart-fin.ru");


        given()
                .spec(recoverRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                .spec(errorRecoveryResponse)
                .extract()
                .as(LombokResponse.class);
    }

}

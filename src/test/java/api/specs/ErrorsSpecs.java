package api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.CoreMatchers.*;

public class ErrorsSpecs {
    public static ResponseSpecification errorRegResponseEmail = new ResponseSpecBuilder()

            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectBody("status", containsString("fail"))
            .expectBody("errors", notNullValue())
            .expectBody("message", containsString("Required parameter was not given email"))
            .build();
    public static ResponseSpecification errorRegResponse = new ResponseSpecBuilder()

            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectBody("status", containsString("fail"))
            .expectBody("errors", notNullValue())
            .expectBody("base_id", nullValue())
            .build();
    public static ResponseSpecification errorRecoveryResponse = new ResponseSpecBuilder()

            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectBody("status", containsString("error"))
            .expectBody("errors", notNullValue())
            .expectBody("base_id", nullValue())
            .build();

}

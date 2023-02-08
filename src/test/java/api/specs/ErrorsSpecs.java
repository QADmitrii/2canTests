package api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.notNullValue;

public class ErrorsSpecs {
    public static ResponseSpecification errorResponseEmail = new ResponseSpecBuilder()

            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectBody("errors", notNullValue())
            .expectBody("message", containsString("Required parameter was not given email"))
            .build();


}

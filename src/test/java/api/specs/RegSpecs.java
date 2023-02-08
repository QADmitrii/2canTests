package api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

public class RegSpecs {

    public static RequestSpecification regRequestSpec = with()
            .baseUri("https://dev01.my2can.com")
            .basePath("/api/v1_register")
            .contentType(ContentType.JSON)
            .log().uri()
            .log().body();

    public static ResponseSpecification regResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectBody("errors",nullValue())
            .expectBody("base_id", notNullValue())
            .build();
}
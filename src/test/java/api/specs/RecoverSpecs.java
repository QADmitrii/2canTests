package api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

public class RecoverSpecs {

    public static RequestSpecification recoverRequestSpec = with()
            .baseUri("https://dev01.my2can.com")
            .basePath("/api/v1_forgot")
            .contentType(ContentType.JSON)
            .log().uri()
            .log().body();

    public static ResponseSpecification recoverResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectBody("status", containsString("success"))
            .expectBody("base_id", notNullValue())
            .build();
}

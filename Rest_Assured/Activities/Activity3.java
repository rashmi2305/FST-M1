import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity3 {
    // Set base URL
    final static String URL = "https://petstore.swagger.io/v2/pet";
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    String reqBody;

    @BeforeClass
    public void setUp() throws IOException {
        //The RequestSpecification should build with:
        //Content type set to JSON
        //Base URL set to https://petstore.swagger.io/v2/pet
        requestSpec = new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri(URL).build();
        //The ResponseSpecification should build with:
        //Status code should be 200
        //Content type should be JSON
        //The response body should have an item "status" whose value must be "alive"
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .expectBody("status", equalTo("alive"))
                .build();
    }

    @DataProvider
    public Object[][] petInfoProvider() {
        // Setting parameters to pass to test case
        Object[][] testData = new Object[][] {
                { 77232, "Riley", "alive" },
                { 77233, "Hansel", "alive" }
        };
        return testData;
    }

    @Test(priority=1)
    public void postUserInfo() {
        reqBody = "{\"id\": 77232, \"name\": \"Riley\", \"status\": \"alive\"}";
        Response response = given().spec(requestSpec).body(reqBody).when().post();
        reqBody = "{\"id\": 77233, \"name\": \"Hansel\", \"status\": \"alive\"}";
        response = given().spec(requestSpec).body(reqBody).when().post();
        //Assertions
        response.then().spec(responseSpec);
    }

    @Test(dataProvider = "petInfoProvider", priority=2)
    public void getUserInfo(int id, String name, String status) {
        //Send a GET request using the details from the DataProvider and Use the RequestSpecification and the ResponseSpecification with this test case. Also add additional assertions for the pet details.
        Response response = given().spec(requestSpec).pathParam("petId", id).when().get("/{petId}");
        System.out.println("Request: "+response.asPrettyString());
        //Assertion
        response.then().body("name", equalTo(name));
    }

    @Test(dataProvider = "petInfoProvider", priority=3)
    public void deleteUser(int id, String name, String status) throws IOException {
        Response response = given().spec(requestSpec).pathParam("petId", id).when().delete("/{petId}");
        response.then().body("code", equalTo(200));
    }
}
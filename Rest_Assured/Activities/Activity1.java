import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity1 {
    String URL = "https://petstore.swagger.io/v2/pet";  //Define URL
    String reqBody;
    String body;

    @Test(priority = 1)
    public void sendPOSTrequest(){
        System.out.println("Post Begins");
        reqBody = "{\n" +                            //Define Body
                "  \"id\": 77233,\n" +
                "  \"name\": \"Riley\",\n" +
                "  \"status\": \"alive\"\n" +
                "}";
        Response response = given().contentType(ContentType.JSON)
                .body(reqBody).when().post(URL);
        body = response.getBody().asPrettyString();      //Print response of Post request
        System.out.println(body);
        //Add assertions to ensure that the response contains id, name, and status items and their values must match the values sent with the request.
        response.then().body("id", equalTo(77233));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
        System.out.println("Post Ends");
    }

    @Test(priority = 2)
    public void sendGETrequest(){
        System.out.println("Get Begins");
        Response response = given().contentType(ContentType.JSON).when().pathParam("petId", "77233")
                .get(URL + "/{petId}");
        //Assertions
        response.then().body("id", equalTo(77233));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
        System.out.println("Get ends");
    }

    @Test(priority = 3)
    public void sendDELETErequest(){
        System.out.println("Delete Begins");
        Response response = given().contentType(ContentType.JSON).when().pathParam("petId","77233")
                .delete(URL + "/{petId}");
        //Assertions
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("77233"));
    }

}

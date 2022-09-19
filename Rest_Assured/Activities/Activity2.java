import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity2 {
    final static String URL = "https://petstore.swagger.io/v2/user";  //Define URL
    //String reqBody;
    String body;

    @Test(priority = 1)
    public void POSTrequest() throws IOException{
        System.out.println("Post Begins");
        FileInputStream inputJson = new FileInputStream("src/test/userinfo.json");
        String reqBody = new String(inputJson.readAllBytes());
        Response response =
                given().contentType(ContentType.JSON).body(reqBody).when().post(URL);
        //body = response.getBody().asPrettyString();
        inputJson.close();
        //System.out.println(body);
        //Assertions
        //response.then().body("code", equalTo("200"));
        //response.then().body("username", equalTo("4645"));
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("4645"));
        System.out.println("Post ends");
    }

    @Test(priority = 2)
    public void GETrequest() {
        File outputJson = new File("src/test/userGETResponse.json");
        Response response =
                given().contentType(ContentType.JSON).pathParam("username", "Test4645").when().get(URL + "/{username}");
        body = response.getBody().asPrettyString();
        System.out.println(body);
        try {
            outputJson.createNewFile();
            FileWriter writer = new FileWriter(outputJson.getPath());
            writer.write(body);
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void DELETErequest() throws IOException{
        System.out.println("Delete Begins");
        Response response =
                given().contentType(ContentType.JSON).when().pathParam("username", "Test4645").delete(URL + "/{username}");
        //Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("Test4645"));
        System.out.println("Delete ends");
    }
}

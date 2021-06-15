package WebTest;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;




public class RESTExample
{
    @Test
    public void test2()
    {
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 200);
    }
    @Test
    public void test3()
    {
        baseURI= "https://reqres.in/api";
        given().get("/users?page=2").then().statusCode(200).
                body("data[1].id",equalTo(8)).
                log().all()

        ;

    }
}

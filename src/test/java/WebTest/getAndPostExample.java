package WebTest;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class getAndPostExample
{
    @Test
    public void testGet()
    {
        baseURI = "https://reqres.in/api/";
        given().
                get("/users?page=2").
        then().
                statusCode(200).
                body("data[4].first_name", equalTo("George")).
                body("data.first_name", hasItems("George","Rachel"));
    }

    @Test
    public void testPost()
    {
        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("name","Prakash");
//        map.put("job","Teacher");
//        System.out.println(map);
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name","Prakash");
        jsonObject.put("job","Teacher");

        System.out.println(jsonObject.toJSONString());

        baseURI = "https://reqres.in/api/";
        given().
            header("Content-Type","application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
            body(jsonObject.toJSONString()).
        when().
            post("/users").
        then().
            statusCode(201).
            log().all();
    }
}

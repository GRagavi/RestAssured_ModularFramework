package Utility;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utility {
	
	//////////////////change the value based on requirement////////////////////
	//Enter the path
	public static String postPath="/id";
	public static String getPath="/id";
	public static String deletePath="/id";
	public static String query1="user_id",value1="96479162",query2,value2;
	public static String jsonPath = "vcbshdhdvchevbhfbvfhvbjdshbhjv.json";
	
	//RequestSpec
	public static RequestSpecification reqSpec = new RequestSpecBuilder().setContentType("application/json").addHeader("X-RapidAPI-Key", "24a04746afmsh53ee5e7eeef1571p12b467jsn4d8d4ae0729b"
			).addHeader("X-RapidAPI-Host", "twitter154.p.rapidapi.com").build();
	
	//ResponseSpec
	public static ResponseSpecification resSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
	
	//
	
	public String generateStringFromResource(String path) throws IOException {

	    return new String(Files.readAllBytes(Paths.get(jsonPath)));

	}
	
/********************************utility methods- Not to change*******************************************/	
	//HTTP POST method
	public static Response postMethod() {
		
		Response response = given().spec(Utility.reqSpec).body(Payload.payload()).when().post(postPath).then().extract().response();
		System.out.println(response.asPrettyString());
		return response;
		
	}
	
	
	//HTTP GET method
	public static Response getMethod() {
		
		Response response = given().spec(Utility.reqSpec).queryParam(query1,value1).when().get(getPath).then().extract().response();
		System.out.println(response.asPrettyString());
		return response;
		
	}
	
	//HTTP DELETE method
	public static Response deleteMethod() {
		
		Response response = given().spec(Utility.reqSpec).queryParam(query1,value1).when().delete(deletePath).then().extract().response();
		System.out.println(response.asPrettyString());
		return response;
		
	}
	
	//Fetch the response element from response body
	public static String fetchResponse(Response response, String query) {
		
		JsonPath js = new JsonPath(response.asString());
		String resValue = js.get(query);
		System.out.println(resValue);
		return resValue;
		
	}
	

}

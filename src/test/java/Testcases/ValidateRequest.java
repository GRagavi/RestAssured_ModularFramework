package Testcases;
import io.restassured.*;
import io.restassured.response.Response;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Utility.Utility;

public class ValidateRequest {
	
	public String path="/id";
	
	@BeforeClass
	public void setUp() {
		
		RestAssured.baseURI="https://twitter154.p.rapidapi.com";
		RestAssured.basePath="/user";
	}
	
	@Test
	public void testCase() {
		
		Utility.postMethod();
		Response response = Utility.getMethod();
		Utility.fetchResponse(response, "user_id");
		
	}
	
	
	
	

}

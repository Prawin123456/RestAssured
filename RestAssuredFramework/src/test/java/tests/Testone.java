package tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class Testone {
	
	private String baseURL;
	private String baseURI;
	@Test
	public void test_01() {
		
		Response response=RestAssured.get("https://reqres.in/api/users/2");//regress website
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
	    System.out.println(response.getBody());
	    System.out.println(response.getStatusLine());
	    System.out.println(response.getHeader("content-type"));
	    
	    int statusCode=response.getStatusCode();
	    
	    Assert.assertEquals(statusCode,200 );
	
	
	}
    @Test
	public void test_02() {
		
    	
    //	baseURI = "https://reqres.in/api";  // Updated the variable name to baseURI for clarity

        given().
            get("https://reqres.in/api/users?page=2").
        then().
            statusCode(200).
            body("data[1].id", equalTo(8))  // Corrected the JSON path and matcher
            .log().all();
    }
}
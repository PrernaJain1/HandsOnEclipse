import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import Files.payLoad;
import Files.reusableMethods;

public class Basics {

	public static void main(String[] args) {
		//given - all inputs details
		//when - submit the API (resource and http method will go under it)
		//then - to validate response
		
		//To validate add place API working as expected and checking status code
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		//If body is not recognizing back slash then go to ->window-> preferences -> search editor -> Typing ->select check box 'escape text when parsing into a string literal'
		
String response =given()
			.log().all()
			.queryParam("key", "qaclick123")
			.header("Content-Type","application/json")
			.body(payLoad.addPlace()) 	//Placing the body code in separate class
		.when()
			.post("maps/api/place/add/json")
		.then()
			.log().all()
			.assertThat().statusCode(200) //verifying add api is working as expected
			.body("scope",equalTo("APP"))  //To validate that in response body scope value is APP  //equal to method is from hamcrest package. Import it
			.header("Server","Apache/2.4.52 (Ubuntu)")	//To validate the headers response. Validating server response, to check response is coming from expected server		
							//Requirement add place (POST) -> then update place (PUT) with new address -> Get place (GET) to validate if new address is present in response
							//After adding place we will get place id from response -> For that place id need to update the address -> in get place response validate new address
			.extract().response().asString(); //To extract the response in string format
						//Store the response in a string variable

			System.out.println(response); //Response we got

			//To extract json from response we will use JSON Path. It takes string as input and convert that into JSON.
			JsonPath js = new JsonPath(response);		//It will help to parse the JSON
			String placeId = js.getString("place_id");
			
			System.out.println(placeId);   //Place id we extracted from response
			
		//Now Update place (PUT) API
		String newAddress = "ABC";  //"+abc+" write in this form to update with variable
		given()
			.log().all()
			.queryParam("key", "qaclick123")
			.header("Content-Type","application/json")
			.body("{\r\n"
					+ "\"place_id\":\""+placeId+"\",\r\n"
					+ "\"address\":\""+newAddress+"\",\r\n"
					+ "\"key\":\"qaclick123\"\r\n"
					+ "}") 	
		.when()
			.put("maps/api/place/update/json")
		.then()
			.log().all()
			.assertThat().statusCode(200) //verifying add API is working as expected
			.body("msg",equalTo("Address successfully updated"));
		
		
		//Get Place API  //No need to give any header because we don't send any body
		String getResponse = given()
			.log().all()
			.queryParam("key", "qaclick123")
			.queryParam("place_id", placeId)
		.when()
			.get("maps/api/place/get/json")
		.then()
			.log().all()
			.assertThat().statusCode(200)
			.extract().response().asString();
		
		//JsonPath j= new JsonPath(getResponse);
		JsonPath j= reusableMethods.rawToJson(getResponse); //Created new file for jsonpath
		String actualAddress= j.getString("address");
		assertEquals(actualAddress, newAddress);

	}

}

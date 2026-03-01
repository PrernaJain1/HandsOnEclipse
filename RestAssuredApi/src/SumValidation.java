import org.testng.annotations.Test;

import Files.payLoad;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	
	@Test
	public void checkSum() {
		
		//6. Verify if Sum of all Course prices matches with Purchase Amount
		
		JsonPath js = new JsonPath(payLoad.CoursePrice());
		int noOfCourses = js.getInt("courses.size()");
		int purchaseAmount= js.getInt("dashboard.purchaseAmount");
		int sum=0;
		
		for(int i=0;i<noOfCourses;i++) {
			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			sum= sum+price*copies;
//			System.out.println(sum);
		}
		
		if(sum==purchaseAmount) {
			System.out.println("Sum of all Course prices matches with Purchase Amount");
		}
		
		//Dynamically build json with external data inputs
		//Parameterize the API Tests with multiple data sets
	}
}

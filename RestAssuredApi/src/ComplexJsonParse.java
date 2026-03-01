import Files.payLoad;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		//We are mocking the response .Here we are not getting response from API as API is not ready.
		//Here we are sending mock JSON. Once API will be ready we can connect to it.
		JsonPath js = new JsonPath(payLoad.CoursePrice());
		
		//1. Print No of courses returned by API
		int noOfCourses = js.getInt("courses.size()");
		System.out.println("Number of Courses are : "+noOfCourses);

		//2.Print Purchase Amount
		int purchaseAmount= js.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase amount is : "+ purchaseAmount);
		
		//3. Print Title of the first course
		String firstCourseTitle = js.get("courses[0].title");
		System.out.println("First course title is : "+ firstCourseTitle);

		//4. Print All course titles and their respective Prices
		for(int i=0;i<noOfCourses;i++) {
			String title = js.get("courses["+i+"].title");
			String price = js.get("courses["+i+"].price").toString();
			System.out.println("Title of "+i+ " course is "+  title+ " Price is : "+ price);
		}

		//5. Print no of copies sold by RPA Course
		for(int i=0;i<noOfCourses;i++) {
			String coursesTitle = js.get("courses["+i+"].title");
			if(coursesTitle.equalsIgnoreCase("RPA")) {
				String copies = js.get("courses["+i+"].copies").toString();
				System.out.println("Copies sold by RPA are : "+ copies);
				break;
			}
		}

	
	}
	
}

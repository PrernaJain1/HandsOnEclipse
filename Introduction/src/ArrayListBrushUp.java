import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListBrushUp {

	public static void main(String[] args) {
		
		//how to create an arraylist
		ArrayList<String> a= new ArrayList<String>();
		a.add("Prerna");//TO add elements in arraylist
		a.add("Aditi");
		a.add("Ajay");
		
		System.out.println("With normal for loop");
		//a.get(0);//To get value of particular index
		for(int i=0;i<a.size();i++) {
			System.out.println(a.get(i));
		}
			
		a.remove(2);//To remove value
		
		
		System.out.println("With for each loop");
		for(String s:a) {
			System.out.println(s);
		}
		
		System.out.println();
		
		//To check if arraylist contains a particular item or not---if there return true else false
		System.out.println(a.contains("Prerna"));
		
		//To Convert array into arraylist
		String[] arr= {"Happy","Birthday","To","You"};
		List<String> convert= Arrays.asList(arr);  //Converting array to arraylist
		System.out.println(convert.contains("Happy"));
		
		
		//*********************************
		//String is an object that represents the sequence of characters
		
		
		
	}

}

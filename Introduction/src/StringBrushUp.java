
public class StringBrushUp {

	public static void main(String[] args) {
		//String is an object that represents the sequence of characters
		
		//creating with string literal
		
		String s="Prerna Jain working hard";
		String s1="Prerna Jain working hard";//for this new object will not be created it will point to above one
		
		//creating string with new keyword
		String s2=new String("Jain");
		String s3=new String("Jain");//For this new object will be created
		
		System.out.println(s+ s1+ s2 +" "+s3);
		//To split a string
		String[] splittedarray=s.split(" ");
		System.out.println(splittedarray[0]);
		System.out.println(splittedarray[1]);
		System.out.println(splittedarray[2]);
		System.out.println(splittedarray[3]);
		
		//To remove the spaces
		String s5=" abdndj  ";
		System.out.println(s5);
		System.out.println(s5.trim());
		System.out.println(s5);
		
		//To print all characters of a string seprately
		for(int i=0;i<s.length();i++) {
			System.out.println(s.charAt(i));
		}
		
	}

}

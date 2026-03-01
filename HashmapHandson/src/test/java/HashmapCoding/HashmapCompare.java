package HashmapCoding;

import java.util.HashMap;

public class HashmapCompare {

	public static void main(String[] args) {
		
		//To compare two hashmaps
		HashMap<Object,Object> h1=new HashMap<> ();
		h1.put(1, "a");
		h1.put(2, "b");
		h1.put(3, "c");
		
		HashMap<Integer, String> h2=new HashMap<> ();
		h2.put(1, "a");
		h2.put(2, "b");
		h2.put(3, "c");
		
		System.out.println(h1.equals(h2)); //It will only check key value pair not the type of it
		
		
		
	}

}

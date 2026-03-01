package HashmapCoding;

import java.util.ArrayList;
import java.util.HashMap;

public class SortHashmap {

	public static void main(String[] args) {
		
		//sort the keys and print the value
		HashMap <Integer,String> h= new HashMap<> ();
		h.put(5, "a");
		h.put(4, "b");
		h.put(1, "e");
		h.put(3, "r");
		h.put(2, "w");
		
		ArrayList <Integer> a=new ArrayList<> ();
		
		//Storing values in arraylist
		for(int i:h.keySet()) {
			a.add(i);
		}
		
		//Sorting ArrayList
		a.sort(null);
		
		//Now fetching value of hashmap through arraylist 
		for(int j:a) {
		System.out.println(j +" "+h.get(j));
		}
		

	}

}

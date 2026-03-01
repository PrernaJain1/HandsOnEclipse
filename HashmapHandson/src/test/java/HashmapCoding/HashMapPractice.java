package HashmapCoding;

import java.util.HashMap;

public class HashMapPractice {

	public static void main(String[] args) {
		
		HashMap <Object,Object> h=new HashMap<> ();
		h.put(1,"Prerna");
		h.put(2, "Sid");
		h.put(3, "Sam");
		h.put(4, "Tanya");
		
		//Key can be null
		//If we try to again enter the value for a particular key it will not give error.
		//It will replace the old value
		h.put(null, "123");
		h.put(null, null);
		
		//printing key and value
		for(Object i:h.keySet()) {
			System.out.println(i+" "+h.get(i)); //get- it is used to get the value of key
		}
		
		//print hashmap
		System.out.println(h);
		
		//To check a particular key is available in hashmap or not
		System.out.println(h.containsKey(7));
		
		//To check a particular value is available in hashmap or not
		System.out.println(h.containsValue("Sa"));
		
		//To replace the value of particular key
		h.replace(3, "Tanvi");
		
		for(Object i:h.keySet()) {
			System.out.println(i+" "+h.get(i)); //get- it is used to get the value of key
		}
		
		//remove key
		h.remove(2);
		h.remove(3, "Tanvi");
		
		System.out.println(h);
		
		
	}

}

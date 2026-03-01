package HashmapCoding;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PracticeTwice {

	public static void main(String[] args) {
		HashMap<Integer,String> h= new HashMap<Integer, String> ();
		h.put(3,"abc");
		h.put(2, "dkld");
		h.put(1, "sdkj");
		h.put(5, "jjkl");
		/*
		//To print hashset
		System.out.println(h);
		
		//To return keys
		System.out.println(h.keySet());
		
		//To print individual keys and values
		for(int i:h.keySet()) {
			System.out.println(i+" "+h.get(i));
		}
		*/
		
		//print values in ascending order of keys
		/*
		 ArrayList<Integer> a=new ArrayList<Integer>();
		for(int j:h.keySet()) {
			a.add(j);
		}
		
		a.sort(null);
		
		for(int i:a) {
			System.out.println(i+" "+h.get(i));
		}
		*/
		
		//To print all the values of hashmap
		System.out.println(h.values());
		
		//how to print all values of hashmap through set
		/*Set<String> s= new HashSet<String> ();
		for(String s1:h.values()) {
			s.add(s1);
		}
		
		for(String k:s) {
			System.out.println(k);
		}*/
		
		
		
		
			
		/*
		//Autoboxing
		Integer m= 5;
		
		//Auto-unboxing
		int n=m;
		
		System.out.println(m+" "+n);*/
	}

}

package HashmapCoding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetPractice {

	public static void main(String[] args) {

		Set <Integer> s=new HashSet<> ();
		s.add(1);
		s.add(7);
		s.add(6);
		s.add(9);
		s.add(8);
		s.add(90);
		s.add(2);
		
		
		System.out.println(s);
		
		//Converting set to list
		List <Integer> l=new ArrayList<> (s); 
		System.out.println(l);
	}

}

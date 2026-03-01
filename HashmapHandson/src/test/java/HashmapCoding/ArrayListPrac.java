package HashmapCoding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayListPrac {

	public static void main(String[] args) {

		// List--> ordered and duplicate elements are allowed
		List<Integer> l = new ArrayList<>();
		l.add(3);
		l.add(4);
		l.add(35);
		l.add(3);
		System.out.println(l); // [3, 4, 35, 3]

		// add element at particular index
		l.add(2, 100); // first is index and second is value
		System.out.println(l); // [3, 4, 100, 35, 3]

		// Delete ele from particular index
		l.remove(3);
		System.out.println(l); // [3, 4, 100, 3]

		// Print the index value
		System.out.println(l.get(2)); // 100

		// iterate the list through for each
		for (int i : l) {
			System.out.println(i);
		}

		// iterate the list
		for (int j = 0; j < l.size(); j++) {
			System.out.println(l.get(j));
		}

		// To convert list to array
		Object[] a = l.toArray();
		for (Object i : a) {
			System.out.println(i);
		}

		// To convert list into string
		String b = l.toString();
		System.out.println(b);

		// To convert list into set
		// (in set we don't use methods related to indexing--> unordered)
		// In set duplicate elements are not allowed
		Set<Integer> s = new HashSet<>(l);
		System.out.println(s); // [3, 4, 100]

		// add value to set
		s.add(45);
		s.add(1);
		s.add(45);
		System.out.println(s); // [1, 3, 4, 100, 45]

		// remove value from set
		s.remove(1);
		System.out.println(s); // [3, 4, 100, 45]

		//to convert list to HashSet
		HashSet<Integer> s1 = new HashSet<>(l);
		System.out.println(s1);
		
		// Convert List to arrayList
		List<Integer> l3 = new ArrayList<>();
		ArrayList<Integer> a3 = new ArrayList<>(l3);
		System.out.println(a3);
		
		// Convert arrayList to List
		ArrayList<Integer> a2 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>(a2);
		System.out.println(l2);

	}

}

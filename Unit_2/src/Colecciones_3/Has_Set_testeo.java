package Colecciones_3;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class Has_Set_testeo {

	public static void main(String[] args) {
		Set<Character> s1 = new HashSet<Character>(8);
		s1.add('a');
		s1.add('b');
		s1.add('j');

		Iterator <Character> s3 = s1.iterator();

		while(s3.hasNext());
		System.out.println("jkdjdj");
			System.out.println(s3.next());
		
	}

}

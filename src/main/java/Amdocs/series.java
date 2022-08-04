package Amdocs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class series {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         List<Integer> list=Arrays.asList(1,5,3,6,9,7);
         //Stream<Integer> numbers= 
       
         List<Integer> res=list.stream().filter(n->n%2==0).map(m->m*m).collect(Collectors.toList());
         for(int out:res)
         {
        	 System.out.println(out);
        	 
         }
	}

}

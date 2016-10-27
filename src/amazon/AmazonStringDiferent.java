package amazon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

/**
 WE HAVE THE INPUT AS THE NUMBER OF WORDS.
 WE NEED TO PRINT ALL THE POSSIBLES VALUES IN 
 THE FIRST OUTPUT ALL THE STRINGS, IN THE SECOND
 ALL OF THEM MINUS THE FIRST ONE AND SO ON 
 INPUT:
 RED
WHITE
BLACK
OUTPUT:
  integers=RED  WHITE  BLACK integers=WHITE  BLACK integers=BLACK
 * */
public class AmazonStringDiferent {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        int totalOfNames = in.nextInt();
        
        List<String> listNames = new ArrayList<String>();
        
	     for (int total=0;total < totalOfNames;total++){
	    	 
	    	 listNames.add(in.next());
	    	 
	     }
        
        LinkedHashSet<String> setOfNames = new LinkedHashSet<String>(); 
        
        solution (setOfNames,  totalOfNames, listNames );
        
        //System.out.println("arrayofBites.size "+arrayofBites.size());
			
        Iterator<String> spacesofBites = setOfNames.iterator();
        
        totalOfNames = 0;
			
    	while ( spacesofBites.hasNext()){
    		
    		String listIntegers= spacesofBites.next();
    		
    		System.out.print(" integers="+listIntegers);
    	}

	}
	
	private static void solution (LinkedHashSet<String> setOfNames, int totalOfNames , List<String> listNames){
		
		int numberofStringInternal = 0, index =0,
				counterIndexBite=totalOfNames;
		
		while (numberofStringInternal < totalOfNames){
			
			//System.out.println("numberofBiteInternal "+numberofBiteInternal);
				//System.out.println("counterIndexBite "+counterIndexBite);
			numberofStringInternal++;	
			StringBuilder namesConcat = new StringBuilder(); 
			int auxIndex= index;
			
			while (counterIndexBite>0 ){
				
				System.out.println("1index "+index);
				
				namesConcat.append(" "+listNames.get(auxIndex)+" ");
				//System.out.println("auxIndex "+auxIndex);
				counterIndexBite--;
				auxIndex ++;
				
			}
				
			setOfNames.add(namesConcat.toString().trim());	
			counterIndexBite = totalOfNames-numberofStringInternal;
			index ++;
			
		}					
		
	}

}

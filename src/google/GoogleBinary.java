package google;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class GoogleBinary {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        int totalOfBites = in.nextInt();
        
        LinkedHashSet<String> arrayofBits = new LinkedHashSet<String>(); 
        
        solution (arrayofBits,  totalOfBites );
        
        //System.out.println("arrayofBites.size "+arrayofBites.size());
			
        Iterator<String> spacesofBits = arrayofBits.iterator();
        
    	while ( spacesofBits.hasNext()){
    		
    		String listIntegers= spacesofBits.next();
    		
    		System.out.println(listIntegers);
    		
    	}

	}
	
	private static void solution (LinkedHashSet<String> arrayofBits, int totalOfBits ){
		
		int numberofBitInternal = 0, lengthofNumberOfBits=0,
				counterIndexBite=totalOfBits;
		
		String binaryNumberofDecimal = new String();
		int totalofLines = (int) Math.pow(2, totalOfBits);
		
		while (numberofBitInternal <= (totalofLines-1) ){
			
			lengthofNumberOfBits = Integer.toBinaryString(numberofBitInternal).length();
			counterIndexBite = lengthofNumberOfBits;
			binaryNumberofDecimal = Integer.toBinaryString(numberofBitInternal);
			//System.out.println("toBinaryString "+ Integer.toBinaryString(numberofBitInternal));
			//System.out.println("numberofBiteInternal "+numberofBiteInternal);
			
			if (lengthofNumberOfBits == totalOfBits ){
				
				arrayofBits.add(binaryNumberofDecimal);
				
			}else{
				
				StringBuilder arrayWithBits = new StringBuilder();
				
				while (counterIndexBite < totalOfBits ){
					
						arrayWithBits.append(0);
						counterIndexBite++;
					
				}
				
				arrayWithBits.append(binaryNumberofDecimal);
				
				arrayofBits.add(arrayWithBits.toString());
				
			}
			
			numberofBitInternal++;
			
		}					
		
	}

}

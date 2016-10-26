package google;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class GoogleTest1 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        int totalOfBites = in.nextInt();
        
        LinkedHashSet<int[]> arrayofBites = new LinkedHashSet<int[]>(); 
        
        solution (arrayofBites,  totalOfBites );
        
        //System.out.println("arrayofBites.size "+arrayofBites.size());
			
        Iterator<int[]> spacesofBites = arrayofBites.iterator();
        
        totalOfBites = 0;
			
        	while ( spacesofBites.hasNext()){
        		
        		int[] listIntegers= spacesofBites.next();
        		
        		for (int integers: listIntegers){
        			System.out.print(" integers="+integers);
        		}
        		System.out.println("");
        	}
        	
        	

	}
	
	private static void solution (LinkedHashSet<int[]> arrayofBites, int totalOfBites ){
		
		int numberofBiteInternal = 0, index = totalOfBites-1,
				counterIndexBite=totalOfBites, countBiteArray=1;
		
		while (numberofBiteInternal <= totalOfBites){
			
			//System.out.println("numberofBiteInternal "+numberofBiteInternal);
			
			if (numberofBiteInternal == 0){
				
				int[] spacesofBites = new int[totalOfBites];
				
				for (int rec=0;rec<totalOfBites;rec++){
					
					spacesofBites[rec] = 0;
					
				}
				
				arrayofBites.add(spacesofBites);
				
				
			}else{
				
			
				//System.out.println("counterIndexBite "+counterIndexBite);
				
				while (counterIndexBite>0 ){
					
					int[] arrayWithBites = new int[totalOfBites];
					
					System.out.println("1index "+index);
					countBiteArray = numberofBiteInternal;
					int auxIndex= index;
					
					while (countBiteArray > 0){
						
						arrayWithBites[auxIndex] = 1;
						System.out.println("auxIndex "+auxIndex);
						countBiteArray--;
						auxIndex--;
						
					}
					
					counterIndexBite--;
					index --;
					arrayofBites.add(arrayWithBites);
				}
				
				counterIndexBite = totalOfBites-numberofBiteInternal;
				index = totalOfBites-1;
				
			}
			
			numberofBiteInternal++;
			
		}					
		
	}
	
	

}

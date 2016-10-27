package amazon;


/**
 * Amazon Interview Question for SDE-2s
 Write all jumbled number which is >0 && <N, 
 where N is provided by the user. 
A jumbled number is a number whose neighbour 
digit (either left or right) max differ by 1 value. 

e.g.: 
8987 is a jumbled number. 
13 is not a jumbled number. 
123456 is a jumbled number. 
287 is not jumbled number.
 * */
public class AmazonJumbledNumber {

	public static void main(String[] args) {
		
		String input = "123456789";
		
		System.out.println(process (input));

	}
	
	private static boolean process (String input){
		
		int index = 0;
		
		while (index < input.length()-1  ) {
			
			int number = Integer.valueOf(input.substring(index, index+1));
			int numberTwo = Integer.valueOf(input.substring(++index, index+1));
			
			if (number+1 != (numberTwo  ) &&  number-1 != (numberTwo ) ){
				
				return false;
				
			}
			
		}
		
		return true;
		
	}

}

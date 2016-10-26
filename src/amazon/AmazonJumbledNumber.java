package amazon;

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

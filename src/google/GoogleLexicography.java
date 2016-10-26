package google;

public class GoogleLexicography {
	
	
	public static void main(String[] args) {

		String stringOne = "mercurio", stringTwo =  "merced";
		
		boolean change =lexicography (stringOne, stringTwo);
		
		if (change){
			
			String aux = stringOne;
			stringOne = new String( stringTwo);
			stringTwo = new String( aux);
			//System.out.println("stringOne "+stringOne);
		}
		
		 System.out.println(stringOne);
		 System.out.println(stringTwo);
	}
	
	public static boolean lexicography (String stringOne, String stringTwo){
		
		boolean change = false;
		boolean wasDigraph = false;
		
		int iterations=0;
		
		int length = stringOne.length()> stringTwo.length() ? stringOne.length() : stringTwo.length();
		
		while (iterations>length || !change){
			
			if (wasDigraph){
				
				wasDigraph = false;
				
			}else{
				char charStrOne =  stringOne.charAt(iterations);
				char charStrTwo =  stringTwo.charAt(iterations);
				
				if (charStrOne+1>length){
					wasDigraph = true;
				}
				
				
				if (charStrTwo < charStrOne){
					
					change = true;
					
				}
			}
			
			iterations ++;
			
		}
		
		return change;
		
	}

}

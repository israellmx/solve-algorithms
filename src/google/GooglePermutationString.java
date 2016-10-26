package google;

public class GooglePermutationString {

	public static void main(String[] args) {
		
		String stringOne = "hey",  strTwo = "sa"; 
		
		solution( stringOne,  strTwo);
		StringBuilder out1=new StringBuilder();
	    out1.append(strTwo);
	    generateSolUtil(out1,strTwo.length(),stringOne,0,0);

	}
	
	static void generateSolUtil(StringBuilder out1,int strTwolength,String stringOne,int j,int start){
	    if(out1.length()==strTwolength+stringOne.length()){
	        System.out.println(out1);
	        return;
	    }
	    else
	        for(int i=start;i<1+out1.length();i++){
	            out1.insert(i,stringOne.charAt(j));
	            generateSolUtil(out1,strTwolength,stringOne,j+1,i+1);
	            out1.deleteCharAt(i);
	        }
	}
	
	private static void solution(String stringOne, String strTwo){
		
		int numberOfLoop= findNumberofLoop(stringOne.length(), strTwo.length());
		int indexPlus = stringOne.length() + strTwo.length();
		
		
		
		for (int index=0; index<numberOfLoop; index++){
			
			int counterCharacter = 0;
			
			while (indexPlus>counterCharacter){
				
				
				
				counterCharacter ++;
			}
			
		}
		
		System.out.println(numberOfLoop);
		
	}
	
	private static int findNumberofLoop(int lengthOne, int lengthTwo){
		
		int numerator = makeFactorial(lengthOne+lengthTwo);
		int denominator = makeFactorial(lengthOne)*makeFactorial(lengthTwo);
		
		System.out.println(numerator);
		System.out.println(denominator);
		
		return numerator/denominator;
		
	}
	
	private static int makeFactorial(int number){
		
		if (number == 0){
			return 1;
		}else {
			return number*makeFactorial(number-1);
		}
		
	}

}

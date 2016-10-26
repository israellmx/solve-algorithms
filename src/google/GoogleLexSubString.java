package google;


public class GoogleLexSubString {

	public static void main(String[] args) {
		
		String stringOne = "dztwbcdezfoptjklcd";
		
		lexicography (stringOne);
		
	}
	
public static void lexicography (String stringOne){

		StringBuilder builder =new StringBuilder ();
		String maxLexicography = new String();
		String auxLexicography = new String();
		boolean agregarAux=false;
		
		int iterations=0, iterationsplusOne = 1;
		
		int length = stringOne.length();
		
		while (iterations<length-1 ){
			
			char charStrOne =  stringOne.charAt(iterations);
			char charStrTwo =  stringOne.charAt((iterationsplusOne));
			
			if (charStrTwo < charStrOne){
				
				if (auxLexicography.isEmpty()){
					
					agregarAux = true;					
					maxLexicography = maxLexicography.concat(String.valueOf(charStrOne));
					
				}else{
					
					auxLexicography= auxLexicography.concat(String.valueOf(charStrOne));
					
					if (auxLexicography.length()>maxLexicography.length()){
						maxLexicography = new String( auxLexicography);
					}
					auxLexicography = new String();
				}
				
				builder.append(charStrOne);
				builder = new StringBuilder ();
				
				
			}else{
				
				
				if (agregarAux){
					auxLexicography= auxLexicography.concat(String.valueOf(charStrOne));
				}else{
					maxLexicography = maxLexicography.concat(String.valueOf(charStrOne));	
				}
				
				builder.append(charStrOne);
			}
			
			if (iterationsplusOne == length-1){
				builder.append(charStrTwo);
				
				if (auxLexicography.length()>maxLexicography.length()){
					maxLexicography = new String( auxLexicography);
				}
				
			}
			
			iterations ++;
			iterationsplusOne++;
			
		}
		
		System.out.println(maxLexicography);
		
	}

}

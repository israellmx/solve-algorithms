package amazon;

public class AmazonParseInt {

	public static void main(String[] args) {
		
		String strInput = new String (""+2356789);

		process (strInput);
		
	}
	
	public static void process (String str){
		
		int resultado = 0, maxDigits;
		int aux = 1;
		int auxMultiply = aux;
		
		for (int index=0; index<str.length(); index++){
			
			aux = aux * 10;
			
		}
		
		resultado = aux;
		maxDigits= aux;
		
		for (int index=0; index<str.length(); index++){
			
			aux = aux / 10;
			auxMultiply = (Integer.valueOf(str.substring(index, index+1)) ) *aux;
			
			resultado = resultado + auxMultiply ;
			
		}
		
		resultado = resultado -maxDigits  ;
			
		
		System.out.println(resultado);
		
		
	}
	

}

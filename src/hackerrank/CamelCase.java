package hackerrank;

import java.util.Scanner;


/**
 Alice wrote a sequence of words in CamelCase as a string of letters, s,
 having the following properties:

It is a concatenation of one or more words consisting of English letters.
All letters in the first word are lowercase.
For each of the subsequent words, 
the first letter is uppercase and rest of the letters are lowercase.
Given s, print the number of words in  on a new line.

Sample Input

saveChangesInTheEditor

Sample Output

5
 * */
public class CamelCase {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		solution ( str);
	}
	
	private static void solution (String str){
		
		int contador = 1;
		
		if (!str.isEmpty()){
			
			for (int i=0; i< str.length(); i++){
				
				char charOfStr = str.charAt(i);
				
				if (charOfStr >= 65 && charOfStr <= 90){
					contador++;
				}
			}
			
		}else{
			contador = 0;
		}
		
		System.out.println(contador);
	}
}

package hackerrank;

import java.util.Scanner;

/**
 Shil has a string, S, consisting of N lowercase English letters. 
 In one operation, he can delete any pair of adjacent letters with same value.
 For example, string "aabcc" would become either "aab" or "bcc" after 1 operation.
Shil wants to reduce S as much as possible.
 To do this, he will repeat the above operation as many times as it 
 can be performed. Help Shil out by finding and printing S's 
 non-reducible form!

Note: If the final string is empty, print .

Sample Input 0
aaabccddd
Sample Output 0
abd
 **/

public class SuperReducedString {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		solution ( str);
	}

	private static void solution (String str){
		
		int contador = 0;
		StringBuilder sb = new StringBuilder(str);
		
		for (; contador< sb.length()-1; ){
			
			char charOfStr = sb.charAt(contador);
			char charOfStrNext = sb.charAt(contador+1);
			if (charOfStr == charOfStrNext){
				sb.delete(contador, contador+1);
				sb.delete(contador, contador+1);
				if (contador>0){
					contador = contador-1;
				}
				
			}else
				contador++;
		}
		
		System.out.println(sb.toString().length()>0?sb:"Empty String");
	}
	
}

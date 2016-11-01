package hackerrank;

import java.util.Scanner;
import java.util.Stack;

/**
 String t  always consists of two distinct alternating characters. 
 For example, if string t's two distinct characters are x and y,
  then t could be xyxyx or yxyxy but not xxyy or xyyx.

You can convert some string s to string t by deleting characters from. 
When you delete a character from s, you must delete all occurrences of it in s. 
For example, if  s = abaacdabd and you delete the character a, 
then the string becomes bcdbd.

Given s, convert it to the longest possible string t. 
Then print the length of string t on a new line; 
if no string t can be formed from s, print 0 instead.

Input Format

The first line contains a single integer denoting the length of s. 
The second line contains string s.

Sample Input

10
beabeefeab

Sample Output

5
  */

public class TwoCharacters {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        solution ( s,  len);
    }
	
	 private static void solution (String str, int length){
			
		StringBuilder uniqueCharacters = getUniqueCharacters( str);
		Stack<Integer> stack = new Stack<>();
		
		int maximo = 0, auxMaximo = 0;
		
		if (uniqueCharacters.length() > 2){
			
			StringBuilder combination = new StringBuilder();
			
			for (int i=0; i< uniqueCharacters.length()-1; i++){
				
				char charOne = uniqueCharacters.charAt(i);
				
				for (int j=i+1; j< uniqueCharacters.length(); j++){
					char charTwo = uniqueCharacters.charAt(j);
					combination = new StringBuilder();
					combination.append(charTwo); 
					combination.append(charOne);
					
					String strNew = new String(str); 
					
					if (validarFormat(combination,  strNew,  uniqueCharacters, stack)){
						maximo = stack.pop();
						if (auxMaximo == -1){
							auxMaximo = maximo;
						}
						if (maximo > auxMaximo){
							auxMaximo = maximo;
						}
					}
				}
			}
		}else{
			if (uniqueCharacters.length() == 1){
				auxMaximo = 0;
			}else{
				if (validarFormatTwoUniqueCharacters( str, uniqueCharacters, stack)){
					maximo = stack.pop();
					if (auxMaximo == 0){
						auxMaximo = maximo;
					}
					if (maximo > auxMaximo){
						auxMaximo = maximo;
					}
				}
			}
			
		}
		
		System.out.println(auxMaximo);
		
	}
		
	private static boolean validarFormat(StringBuilder combination, String str,
			StringBuilder uniqueCharacters, Stack<Integer> stack) {
		
		boolean valido = true;
		
		StringBuilder sbToDelete = getUniqueCharactersToDelete( combination,  uniqueCharacters);
		
		for (int r=0; r<sbToDelete.length(); r++){
			String strIndex= sbToDelete.substring(r, r+1);
			str = str.replace(strIndex, "");
		}
		
		if (str.length()>= 2 ){
			
			char charOne = str.charAt(0);
			char charTwo = str.charAt(1);
			
			if ( str.length()== 2){
				if (charOne == charTwo){
					valido = true;
				}else
					valido = false;
			}
			
			for (int r=2; r<str.length(); r++){
				char charIn = str.charAt(r);
				
				if (r % 2 == 0){
					if (charOne != charIn ){
						valido = false;
						break;
					}
				}else{
					if (charTwo != charIn ){
						valido = false;
						break;
					}
				}
				
			}
			
		}else{
			valido = false;
		}
		
		stack.push(str.length());
		
		return valido;
	}
	
	private static boolean validarFormatTwoUniqueCharacters( String str, StringBuilder uniqueCharacters, Stack<Integer> stack) {
		
		boolean valido = true;
		
		char charOne = uniqueCharacters.charAt(0);
		char charTwo = uniqueCharacters.charAt(1);
		
		for (int r=0; r<str.length(); r++){
			
			char charIn = str.charAt(r);
			
			if (r % 2 == 0){
				if (charOne != charIn ){
					valido = false;
					break;
				}
			}else{
				if (charTwo != charIn ){
					valido = false;
					break;
				}
			}
			
		}
		
		stack.push(str.length());
		
		return valido;
	}
	
	private static StringBuilder getUniqueCharacters(String str){
		
		StringBuilder combination = new StringBuilder();
		boolean finded = true;
		
		for (int r=0; r<str.length(); r++){
			
			char charOne = str.charAt(r);
			
			if (r == 0){
				combination.append(charOne);
			}else{
				finded = true;
				for (int j=0;j<combination.length(); j++){
					char charTwo = combination.charAt(j);
					if (charOne ==  charTwo ){
						finded = false;
						break;
					}
				}
				if (finded)
					combination.append(charOne);
			}
			
		}
		
		return combination;
	}
	
	private static StringBuilder getUniqueCharactersToDelete(StringBuilder combinationIn, StringBuilder uniqueCharacters){
		
		StringBuilder combinationToDelete = new StringBuilder();
		
		for (int r=0; r<uniqueCharacters.length(); r++){
			
			String charOne = uniqueCharacters.substring(r, r+1);
			
			if (!combinationIn.toString().contains(charOne)){
				combinationToDelete.append(charOne);
			}
			
		}
		
		return combinationToDelete;
	}

}

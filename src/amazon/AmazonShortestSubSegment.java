package amazon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
Given a paragraph of text, write a program to find the first shortest sub-segment that contains each of the given k words at least once. A segment is said to be shorter than other if it contains less number of words.

Ignore characters other than [a-z][A-Z] in the text. Comparison between the strings should be case-insensitive. 

If no sub-segment is found, then the program should display �NO SUBSEGMENT FOUND�.

Input format :

First line of the input contains the text.

Next line contains k , the number of words to be searched.

Each of the next k lines contains a word.

Output format :

Print first shortest sub-segment that contains given k words ,
ignore special characters, numbers. 
If no sub-segment is found, print �NO SUBSEGMENT FOUND�

Sample Input :

This is a test. This is a programming test. This is a programming test in any language.

4

this

a

test

programming

Sample Output :

a programming test This 
 * */
public class AmazonShortestSubSegment {
	
	private static final String PATTERN_WORD = "[a-zA-Z0-9]+";

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
	    String strText = in.nextLine();
		int t = in.nextInt();
		Queue<String> queueString = new LinkedList<>();
		
        for (int r=0; r<t; r++){
        	 String k = in.next();
        	 queueString.add(k.toLowerCase());        	                 
        }
        
	    process (clearStringOfCharactersSpecials(strText), queueString);
	}
	
	private static Queue<String> clearStringOfCharactersSpecials(String strInput){
		
		Queue<String> listWords = new LinkedList<>(); 
		Pattern pattern = Pattern.compile(PATTERN_WORD);
		
		Matcher matcher = pattern.matcher(strInput);
		
		while (matcher.find()) {
			listWords.add(matcher.group());
		}
		
		return listWords;
		
	}
	
	static void process (Queue<String> listWords, Queue<String> queueString) {
		
		ArrayList<String> list = new ArrayList<>();
		StringBuilder builderShortest = new StringBuilder();
		StringBuilder builderPrevious = new StringBuilder();
		
		while (!listWords.isEmpty()){
			
			String stringTextInner = listWords.peek();
			Queue<String> queueinner = new LinkedList<>();
			queueinner.addAll(queueString);
			builderShortest = new StringBuilder();
			
			while (!queueinner.isEmpty()){
				
				if (queueinner.contains(stringTextInner.toLowerCase())){
					
					queueinner.remove(stringTextInner.toLowerCase());
					Iterator<String> iteratorWords = listWords.iterator();
					while(iteratorWords.hasNext() ){
						String stringTextIterator = iteratorWords.next();
						builderShortest.append(stringTextIterator+" ");	
						if (queueinner.contains(stringTextIterator.toLowerCase())){
							queueinner.remove(stringTextIterator.toLowerCase());
						}
						if (queueinner.isEmpty()){
							
							break;
						}
						
					}
					if (!queueinner.isEmpty()){
						builderShortest = new StringBuilder();
						queueinner.clear();
					}else{
						list.add(builderShortest.toString().trim());
					}
					
				}else{
					queueinner.clear();
				}
				
			}
			
			listWords.poll();
			
			if (  builderShortest.length()>0 && builderShortest.length() < builderPrevious.length() &&  builderPrevious.length()>0 ){
				builderPrevious = new StringBuilder();
				builderPrevious.append(builderShortest);
			}
			if (builderPrevious.toString().isEmpty() && builderShortest.length()>0 ){
				builderPrevious.append(builderShortest);
				builderShortest = new StringBuilder();
			}
			
		}
		
		//System.out.println(list);
		System.out.println(builderPrevious.toString().length()>0?builderPrevious:"NO SUBSEGMENT FOUND");
	
	}

}

package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Amazon Interview Question for Software Engineers
 Given a set of random strings, 
 write a function that returns a set that groups all the anagrams together. 
Ex: star, dog, car, rats, ars - > {(star, rats), (src,car), dog)
 * */
public class AmazonSetAnagrams {

	NodeAnagram[] buckets = new NodeAnagram[8];
	
	public static void main(String[] args) {

		Set<String> setAnagrams = new HashSet<String>();
		setAnagrams.add("star");
		setAnagrams.add("dogs");
		setAnagrams.add("rats");
		setAnagrams.add("car");
		setAnagrams.add("rac");
		setAnagrams.add("rtsa");
		
		AmazonSetAnagrams amazonSetAnagrams = new AmazonSetAnagrams();
		
		process (setAnagrams, amazonSetAnagrams);
		
		Set<ArrayList<String>> setList = new HashSet<ArrayList<String>>();
		
		for (int index =0;index<amazonSetAnagrams.buckets.length;index++){
			
			ArrayList<String> listStrings = new ArrayList<String>();
			NodeAnagram base= amazonSetAnagrams.buckets[index];
			
			while (base != null){
				listStrings.add(base.value);
				base = base.next;
			}
			
			if (!listStrings.isEmpty()){
				setList.add(listStrings);	
			}
			
			
		}
		
		for (ArrayList<String> arrayList:setList){
			 System.out.print("(");
			for (int index =0;index<arrayList.size();index++){
				
				String base= arrayList.get(index);
				
				System.out.print(base +" ");				
				
			}
			
			 System.out.println(")");
			
		}
		
		
	}
	
	private static class NodeAnagram {
		
		String value;
		NodeAnagram next = null;
		
		public NodeAnagram (String value){
			this.value = value;
			
		}
		
		public String toString(){
			return value;
		}
		
	}
	
	public void addNodeAnagram(String word){
		
		int position = hash(word);
		NodeAnagram node = buckets[position];
		
		NodeAnagram newNode =   new NodeAnagram(word);
		
		if (node == null){						
			buckets[position] = newNode;
			
		}else{			
			newNode.next = buckets[position];
			buckets[position] = newNode;
		}
		
		
	}

	private int hash(String word) {
		
		int result = 0;
		
		for (int index=0; index<word.length(); index++){
			
			result = result+word.charAt(index);
			
		}
		
		
		NodeAnagram previoBucket  = buckets[result % buckets.length];
		
		if (previoBucket!=null){
			
			while (previoBucket != null){
				
				if (reviewAnagram(word, previoBucket.value))
				previoBucket = previoBucket.next;
				
			}
			
		}
		
		return result % buckets.length;
	}
	
	private  boolean reviewAnagram(String newString, String strPrevioBucket){
		
		char ch1[] = newString.toCharArray();
		char ch2[] = strPrevioBucket.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		
		if (ch1.length != ch2.length){
			return false;			
		}
		
		return Arrays.equals(ch1, ch2);
		
	}
	
	public static void process (Set<String> setAnagrams, AmazonSetAnagrams amazonSetAnagrams){
		
		Iterator<String> iterator = setAnagrams.iterator();
		
		while (iterator.hasNext()){
			
			String word = iterator.next();
			
			checkAnagram ( word, amazonSetAnagrams ) ;
			
		}
		
	}
	
	private static void checkAnagram (String word, AmazonSetAnagrams amazonSetAnagrams ){
		
		amazonSetAnagrams.addNodeAnagram( word);
		
	}
	
	

}

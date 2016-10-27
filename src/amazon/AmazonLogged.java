package amazon;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 There are different users, in a set of users
 return the 2 users with more logged register 
 in the system
 * */
public class AmazonLogged {

	public static void main(String[] args) {
		
		String input = "user1, user4, user2, user1, user3, user1, user2, user3";
		int key = 2;
		
		process ( input, key );

	}
	
	public static  void process (String input, int key ){
		
		HashMap<String, Integer> hashMap = new HashMap<>();
		
		for (String strSplit : input.split(",")  ){
			
			strSplit = strSplit.trim();
			
			if (hashMap.containsKey(strSplit)){
				hashMap.put(strSplit, hashMap.get(strSplit).intValue()+1);
			}else{
				hashMap.put(strSplit, 1);
			}
			
			
		}
		
		Iterator<Entry<String, Integer>> iterator= hashMap.entrySet().iterator();
		
		while (iterator.hasNext()){
			
			Entry<String, Integer> entry= iterator.next();
			
			if (entry.getValue() !=key)
			{
				iterator.remove();
			}else			
			System.out.println(entry.getKey() + " "+key);
			
		}
		
	}
	

}

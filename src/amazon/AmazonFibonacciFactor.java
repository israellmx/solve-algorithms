package amazon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AmazonFibonacciFactor {

public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
       
        for (int r=0; r<t; r++){
        	 int k = in.nextInt();
        	 process (k);                
        }
        
    }

	static void process ( int k) {
		
		long value1=0, value2=1;
		long smallest = 1, counter = 1, result = 0;
		Queue<Long> queue = new LinkedList<Long>();
		boolean encontro = false;
		
		while (result <= k){			
			result = value1 + value2;
			value1 = value2;
			value2 = result;
			if (result > 1 && result <= k ){
				queue.add(result);				
			}
		}
		
		while (!queue.isEmpty()){
			
			long integer = queue.poll();
			
			for (int n = 2; n<=k ; n++){
				if (k % n == 0 && 
						integer % n == 0){
					smallest = integer;
					counter = n;
					queue.clear();
					break;
				}	
			}
			
		}	
		
		if (smallest > 1){
			System.out.println(smallest+ " "+counter);
		}else{
			
			while (!encontro ){			
				result = value1 + value2;
				value1 = value2;
				value2 = result;
				if ( result>1 && ( k % result == 0 || result % k == 0) ){
					queue.add(result);
					encontro = true;
				}	
			}
			
			while (!queue.isEmpty()){
				
				long integer = queue.poll();
				
				for (int n = 2; n<=k ; n++){
					if (k % n == 0 && 
							integer % n == 0){
						smallest = integer;
						counter = n;
						queue.clear();
						break;
					}	
				}
				
			}
			
			if (smallest > 1){
				System.out.println(smallest+ " "+counter);
			}
			
		}
		
	}
	
	
}

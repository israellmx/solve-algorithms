package amazon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 Given a number K, find the smallest Fibonacci number that shares
  a common factor( other than 1 ) with it. 
  A number is said to be a common factor of two numbers
   if it exactly divides both of them. 
Output two separate numbers, F and D, where F 
is the smallest fibonacci number and D is the smallest 
number other than 1 which divides K and F.
Input Format 
First line of the input contains an integer T, the number of testcases.
Then follows T lines, each containing an integer K.
Output Format
Output T lines, each containing the required answer
 for each corresponding testcase.
 
 Sample Input 
3
3
5
161
Sample Output
3 3
5 5
21 7

 * **/
public class AmazonFibonacciFactor {

public static void main(String[] args) {
        
        @SuppressWarnings("resource")
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

package hackerrank;

import java.util.Scanner;

public class DivisibleSumPairs {
	
//Print the number of(i,j)  pairs where i>j  and  a(i) + a(j)  is evenly divisible by k
/*
6 3
1 3 2 6 1 2
5
 * */	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        process (k, a);
        
	}
	
	static void process ( int k,  int a[]  ){
        
		int counter=0;
		
		for (int outer =0; outer<a.length; outer++){			
			
			for (int inner =outer+1; inner<a.length; inner++){
				
				if ( (a[outer] + a[inner]) % k == 0){
					counter ++;
				}	
			}
			
			
		}		
		
        if (counter>0){
        	System.out.println(counter);	
        }
        
    }

}

package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*You are given N sticks, where the length of each stick is a positive integer. 
 * A cut operation is performed on the sticks such that all of them are reduced
 *  by the length of the smallest stick.
Suppose we have six sticks of the following lengths:

5 4 4 2 2 8
Then, in one cut operation we make a cut of length 2 from each of the six sticks. 
For the next cut operation four sticks are left (of non-zero length), whose lengths are the following: 
3 2 2 6
*/

public class CutTheSticks {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
	    int n = in.nextInt();
	    int arr[] = new int[n];
	   
	    for(int arr_i=0; arr_i < n; arr_i++){
	           arr[arr_i] = in.nextInt();
	    }
	   
        process (n, arr);
        
	}
	
	static void process ( int n,  int arr[]  ){
        
		ArrayList<Integer> listOutput = new ArrayList<>();
		Arrays.sort(arr);
		listOutput.add(arr.length);
		
		int counter = 0;
		
		for (int outer =0; outer<arr.length; outer++){
			
			counter = 0;
			
			if (arr[outer] > -1){
				
				for (int inner =outer+1; inner<arr.length; inner++){
					
					int product = arr[inner] - arr[outer] ;
					if ( product == 0){
						arr[inner] = -1;
					}else{
						counter++;
						arr[inner] = product;
					}	
				}
				
			}
			
			arr[outer] = -1;
			if (counter>0){
				listOutput.add(counter);
			}
			
		}		
		
		for (Integer integer : listOutput) {
			System.out.println(integer);	
		}
        	
        
    }
	
}

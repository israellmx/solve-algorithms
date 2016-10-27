package amazon;

import java.util.Arrays;

/**
Reverse an array in subset of N. Example: 
input: Array = [1,2,3,4,5,6,7,8,9], N = 3 
output: [3,2,1,6,5,4,9,8,7]
 * */
public class AmazonReverseSubSet {
	
	public static void main(String[] args) {
		int[] x = { 9, 2, 4, 7, 3, 7, 12, 15, 10 };
		int n = 4;

		process (x, n);
		
	}
	
	public static void process (int[] array, int n){
		
		int indexRight=n-1;
		
		int totalIterations= (n/2);
		
		for (int left=0,rigth=totalIterations; rigth>0 && left<array.length;left++,rigth-- ){
			
			int aux= array[indexRight];
			array[indexRight] =  array[left];
			array[left] = aux;	
			indexRight--;
			
		}
		
		
		System.out.println(Arrays.toString(array));
	}

}

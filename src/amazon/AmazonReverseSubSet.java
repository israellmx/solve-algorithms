package amazon;

import java.util.Arrays;

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

package hackerrank;

import java.util.Scanner;

/**
 Consider a zero-indexed matrix with  rows and  columns,
  where each row is filled gradually. Given the first row of the matrix, you can generate the elements in the subsequent rows using the following formula:
 Each row is generated one by one, from the second row through the last row. Given the first row of the matrix, find and print the elements
  of the last row as a single line of space-separated integers.
  
  Sample Input

4 2
6 7 1 3
Sample Output

1 6 2 5
 * */
public class XorMatrix {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
	    int n = in.nextInt();
	    long m = in.nextLong();
	    
	    if (m>10000){
	    	int div=0, mod = 0;
	    	
	    	for (int r = 0; r<div; r++){
	    		long[][] matrix = new long[10000 ][n]; 	    
			    for(int a0 = 0; a0 < n; a0++){
			    		matrix[0][a0] =  in.nextLong();
			    }	    
			    process (matrix,  n,  m);
	    	}
	    	
	    	for (int r = 0; r<mod; r++){
	    		long[][] matrix = new long[mod ][n]; 	    
			    for(int a0 = 0; a0 < n; a0++){
			    		matrix[0][a0] =  in.nextLong();
			    }	    
			    process (matrix,  n,  m);
	    	}
	    	
	    }
	    else{
	    	long[][] matrix = new long[(int) m  ][n]; 	    
		    for(int a0 = 0; a0 < n; a0++){
		    		matrix[0][a0] =  in.nextLong();
		    }	    
		    process (matrix,  n,  m);	
	    }
	    
		
	}
	
	//TODO
	//EN EL SIGUIENTE METODO
	//PASAR EL ULTIMO RENGLON COMO PARAMETRO
	//ANIDADO Y ESE SEA LA BASE PARA EL FOR
	static void process (long[][] matrix, int n, long m){
		
		long value = 0, valueTwo = 0;
		
		for (int r=0; r<m-1; r++){
			for (int c=0;c<n;c++){
				value = matrix[r][c];
				if (c <= (n-2) ){
					valueTwo = matrix[r][c+1];
					
				}else{
					valueTwo = matrix[r][0];	
				}
				matrix[r+1][c] = processXor( value,  valueTwo);
			}
		}
		
		for (int c=0;c<n;c++){
			 System.out.print(matrix[(int) (m-1)][c]);
			 if (c < n-1 ){
				 System.out.print(" ");
			 }
		}		
		
	}
	
	static long processXor(long one, long two){		
		
		return one ^ two;
		
	}

}

package hackerrank;

import java.util.Scanner;

/**
 * The first line contains an integer, m, denoting the size of array . 
The second line contains n space-separated integers describing the respective elements in array A.
6
7 1 3 4 1 7
3
Find the minimum distance between two equals integers 
 * */
public class MinimumDistances {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        int A[] = new int[n];
        for(int A_i=0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        
        process (  A );

	}
	
	static void process ( int array[] ){
		
		int aux = -1, minimun = 0;
		
		for (int outer =0; outer<array.length; outer++){			
			
			minimun = -1;
			
			for (int inner =outer+1; inner<array.length; inner++){
								
				if ( array[outer] == array[inner]){
					minimun = outer - inner ;
					if (minimun < 0){
						minimun = minimun *(-1);
					}
					break;
				}	
			}
			
			if (aux == -1){
				aux = minimun;
			}
			if (minimun>-1 && minimun < aux){
				aux = minimun;
			}
			
		}		
		
		System.out.println(aux);	
        
    }

}

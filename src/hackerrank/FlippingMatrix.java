package hackerrank;

import java.util.Scanner;

/**
 
 Sean invented a game involving a 2n * 2n matrix where each cell of the matrix contains an integer. 
 He can reverse any of its rows or columns any number of times,
 and the goal of the game is to maximize the sum of the elements
 in the n x n submatrix located in the upper-left corner of the 2n * 2n matrix 
 (i.e., its upper-left quadrant).
 You must print q lines of output. For each query (i.e., matrix),
 print the maximum possible sum of the elements in the matrix's upper-left quadrant.
 
  i.e.
1
2
112 42 83 119
56 125 56 49
15 78 101 43
62 98 114 108

414  
  
 */
 
public class FlippingMatrix {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        
        int q = in.nextInt();
		
		for(int A_i=0; A_i < q; A_i++){
			int n = in.nextInt();
			int total = n * 2;
			long A[][] = new long[total][total];	
			for(int A_i1=0; A_i1 < total; A_i1++){
				for (int j=0; j < total; j++){
					A[A_i1][j] = in.nextInt();
				}				
			}
	        process( A, n);
	    }
	}
	
	static void process(long matrix[][], int n) {
		
		n = n*2;
		long maximo =0, auxiliarOne = 0, auxTwo=0, valor = 0;
		int contador = 0;
		boolean reverte= true;
		
		while (contador < n){
			
			for (int j=0; j < n; j++){
				
				for(int initRow=0, lastRow = n-1; lastRow>0 && initRow<n && initRow<lastRow; initRow++, lastRow--){
					
					auxiliarOne = matrix[initRow][j];
					auxTwo = matrix[lastRow][j];					
					
					if ( (auxiliarOne ) < (auxTwo ) ){
						reverte = true;
					}else{
						reverte = false;
					}
					
					if ( reverte ){
						valor = matrix[initRow][j];
						matrix[initRow][j] = matrix[lastRow][j];
						matrix[lastRow] [j]= valor;
					}
					
				}
				
				valor  =  sumaValorPrimerCuadro( matrix, n/2) ;					
				if (valor > maximo){					
					maximo = valor;
					break;
				}
				
			}
			
			for(int i=0; i < n; i++){
				
				for (int initCol=0, lastCol = n-1; lastCol>0 && initCol<n && initCol<lastCol; initCol++, lastCol--){
					
					if (matrix[i][lastCol] > matrix[i][initCol]  ){
						reverte = true;
					}else{
						reverte = false;
					}
					
					if (reverte){
						valor = matrix[i][initCol];
						matrix[i][initCol] = matrix[i][lastCol];
						matrix[i] [lastCol]= valor;
					}	
				}
				
				valor =  sumaValorPrimerCuadro( matrix, n/2);
						
				if (valor > maximo){					
					maximo = valor;	
					break;
				}					
			}			
			
			contador ++;
		}
		
		System.out.println(maximo);	
	
	}
    
    private static long sumaValorPrimerCuadro(long matrix[][], int n){
		
		long resultado = 0;
		
		for(int A_i1=0; A_i1 < n; A_i1++){
			for (int j=0; j < n; j++){
				resultado = resultado + matrix[A_i1][j];
			}				
		}
		
		return resultado;
		
	}

}

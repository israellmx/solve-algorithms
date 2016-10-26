package hackerrank;

import java.util.Scanner;

/**
 Given a grid of size M x N, each cell in the grid is either good or bad.

A valid plus is defined here as the crossing of two segments (horizontal and vertical)
 of equal lengths. These lengths must be odd, 
and the middle cell of its horizontal segment must cross the middle cell of its vertical segment.
The first line contains two space-separated integers, N and M.
The N subsequent lines contains M characters,
 where each character is either G (good) or B (bad).
 Find 2 pluses that can be drawn on good cells of the grid,
 and print maximum the product of their areas as an integer. 
6 6
BGBBGB
GGGGGG
BGBBGB
GGGGGG
BGBBGB
BGBBGB
25
 * */
public class EmaSupercomputer {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		String A[] = new String[n];
		for(int A_i=0; A_i < n; A_i++){
	            A[A_i] = in.next();
	    }
	        
        process (m, n, A );

	}
	
	 static void process (  int m, int n, String array[]  ){
			
			int maximo, medio, contador = 1, contadorInterno=0, contadorIzq=0, contadorDer=0, resultado = 1, ciclos=0, dos = 0;
			String strInner = new String();
			String str = new String();
			StringBuilder sbReemplazar = new StringBuilder();
			boolean continuar =true, pase = false;
			
			if (n % 2 ==0){
				maximo = n-1;
			}else
				maximo = n;
			
			while (maximo > 1){
				
				if (maximo == 3){
					medio = maximo -1;
				}else
				medio =( maximo / 2) + 1;
				
				for (int outer = 0; outer < n-1; outer ++){
					
					for(int inner = 1; inner < m-1; inner ++){
						
						str = array[outer].substring(inner, inner+1);
						
						if (str.equalsIgnoreCase("G")){
							
							pase = true;
							
							for (contadorInterno = outer+1; contadorInterno<n; contadorInterno++){
								
								if (continuar){
									try{
										
										strInner = array[contadorInterno].substring(inner, inner+1);
										if (strInner.equalsIgnoreCase("G")){
											contador ++;
										}else{
											continuar = false;
											break;
										}
											
									}catch(IndexOutOfBoundsException e){
										continuar = false;
										break;
									}
									if (contador == medio){
										
										continuar = true;
										contadorDer = inner;
										
										for (int contadorDerecha = contadorInterno; contadorDerecha<(medio-1+contadorInterno); contadorDerecha++){
											try{
												contadorDer ++;
												strInner = array[contadorInterno].substring(contadorDer, contadorDer+1);
												if (strInner.equalsIgnoreCase("G")){
												}else{
													continuar = false;
													break;
												}
													
											}catch(IndexOutOfBoundsException e){
												continuar = false;
												break;
											}
											
										}
										if (continuar){
											contadorIzq = inner;
											for (int contadorIzquierda =contadorInterno; contadorIzquierda<(medio-1+contadorInterno); contadorIzquierda++){
												
												try{
													strInner = array[contadorInterno].substring(contadorIzq-1, contadorIzq-- );
													if (strInner.equalsIgnoreCase("G")){
														
													}else{
														continuar = false;
														break;
													}
														
												}catch(IndexOutOfBoundsException e){
													continuar = false;
													break;
												}
											}
										}
										
									}
								}
								
								if (maximo == contador){
									
									resultado = resultado * (maximo + (medio-1) + (medio-1));
	                                ciclos = maximo == 3?medio+outer+1:medio+1+(outer+1);
									
									for (int r= outer; r<ciclos; r++){
										sbReemplazar.append(array[r]);
										sbReemplazar.replace(inner, inner+1, "B");
										array[r] = sbReemplazar.toString();
										sbReemplazar = new StringBuilder();
									}
									 
	                                
	                                if (++dos == 2){
										maximo = 0;
										inner = m;
										outer = n;
										break;
									}
	                                
								}
								
							}
							
							
						}
						
						continuar = true;	
						contador = 1;
					}
						
				}
				
				strInner = new String();
				maximo =maximo - 2;
				
			}
			
			System.out.println(pase==true?resultado:0);
			//System.out.println(sb.toString());
			
			
	    }

}

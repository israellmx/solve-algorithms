package hackerrank;

import java.util.Scanner;

/**
 You are given a square map of size m x n. Each cell of the map has a value denoting its depth. 
 We will call a cell of the map a cavity if and only if this cell is not on the border 
 of the map and each cell adjacent to it has strictly smaller depth.
 Two cells are adjacent if they have a common side (edge).
You need to find all the cavities on the map and depict them with the uppercase character X.
 4
1112
1912
1892
1234

1112
1X12
18X2
1234

 * */

public class CavityMap {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        String grid[] = new String[n];
        for(int grid_i=0; grid_i < n; grid_i++){
            grid[grid_i] = in.next();
        }
        
        process (   grid );

	}
	
	static void process (  String grid[]  ){
		
		int number, numberMasUno, numberMenosUno, numberUp, numberDown;
		StringBuilder sb = new StringBuilder();
		
		for (int outer =1; outer<grid.length-1;outer++){
			
			sb = new StringBuilder(grid[outer]);
			 
			for (int i=1; i<grid.length-1;i++){
				
				number = Integer.valueOf(grid[outer].substring(i, i+1));
				numberUp = Integer.valueOf(grid[outer-1].substring(i, i+1).contains("X")?"9":grid[outer-1].substring(i, i+1));
				numberDown = Integer.valueOf(grid[outer+1].substring(i, i+1).contains("X")?"9":grid[outer+1].substring(i, i+1));
				if (i+1 == grid.length-1){
					numberMasUno = Integer.valueOf(grid[outer].substring(i+1)
							.contains("X")?"9":grid[outer].substring(i+1));	
				}else{
					numberMasUno = Integer.valueOf(grid[outer].substring(i+1, i+2)
							.contains("X")?"9":grid[outer].substring(i+1, i+2));
				}				
				numberMenosUno = Integer.valueOf(grid[outer].substring(i-1, i)
						.contains("X")?"9":grid[outer].substring(i-1, i));
				if (number > numberMasUno && number > numberMenosUno && 
						number > numberUp && number > numberDown ){
					sb.replace(i, i+1, "X") ;
					grid[outer] = sb.toString();
				}
				
			}	
		}
		
		for (String string : grid) {
			System.out.println(string);			
		}
		
    }

}

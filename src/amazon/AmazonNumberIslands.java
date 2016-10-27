package amazon;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

/**
 A group of connected 1s forms an island. For example, the below matrix 
 contains 5 islands

	                {1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1}
A cell in 2D matrix can be connected to 8 neighbors.
 So, unlike standard DFS(), where we recursively call for 
 all adjacent vertices, here we can recursive call for 8 neighbors only. 
 We keep track of the visited 1s so that they are not visited again. 
 Output:

Number of islands is: 5
 * */
public class AmazonNumberIslands {

	public static void main(String[] args) {
		
		int[][] ar;
	    int count = 0;
	    int n = 4;
	    ar = new int[n][n];
	    boolean[][] arrayVisited = new boolean[n][n];
	    GraphIsland graphIsland = new GraphIsland();
	    
	    
		 for (int  rows= 0; rows<n;rows++){
			 for (int cols = 0; cols<n;cols++){
				 if (rows == 0 && cols == 0  ||
						 rows == 0 && cols == 1 ||
								 //rows == 0 && cols == 2 ||
										 rows == 1 && cols == 0 ||		    			  		    			  
												 //rows == 1 && cols == 2 ||
														 rows == 1 && cols == 1 ||
																 rows == 3 && cols == 3 ||
																		 rows == 3 && cols == 0 
		    	   ){
					 ar[rows][cols] = 1;
		    	  }else{
		    		  ar[rows][cols] = 0;
		    	  }			 
			 arrayVisited[rows][cols] = false; 
			 }
		 }
	    	  
		 	
		/*for(int i=0; i<n ; i++) {
			 
	         for(int j=0; j<n; j++){
	        	 
	             if(ar[i][j] == 1 && !arrayVisited[i][j]){
	                    count++;
	                    visit(ar,arrayVisited,i,j);
	             }
	        }
	   }
	   System.out.println(count); 	  
	   */
		 
	   for(int i=0; i<n ; i++) {
			 
	         for(int j=0; j<n; j++){
	        	 
	             if(ar[i][j] == 1 ){
	            	 graphIsland.addVertex(i, j);
	             }
	        }
	   }
	   
	   for(int i=0; i<n ; i++) {
			 
	         for(int j=0; j<n; j++){
	        	 
	             if(ar[i][j] == 1 ){
	            	
	            	 if (i>0 && ar[i-1][j] == 1 ){
	            		 graphIsland.addNeighbor(i, j, i-1, j);
	            	 }
	            	 if (i<n-1 && ar[i+1][j] == 1 ){
	            		 graphIsland.addNeighbor(i, j, i+1, j);
	            	 }
	            	 if (j>0 && ar[i][j-1] == 1 ){
	            		 graphIsland.addNeighbor(i, j, i, j-1);
	            	 }
	            	 if (j < n-1 && ar[i][j+1] == 1){
	            		 graphIsland.addNeighbor(i, j, i, j+1);
	            	 }	            	 
	            	 
	             }
	        }
	   }
	   
	   
	   graphIsland.dfs();
	   
	}
	
	 public static void visit(int[][] ar, boolean[][] arrayVisited,int i, int j){
		 
	        int size = ar.length;
	        if(ar[i][j] == 1){
	        	arrayVisited[i][j] = true;
	            if(j>0 && i<size-1){
	                visit(ar,arrayVisited,i+1,j-1); // SouthWest
	            }
	            if(i<size-1){
	                visit(ar,arrayVisited,i+1,j); // South
	                if(j < size-1)
	                    visit(ar,arrayVisited,i+1,j+1); // SouthEast
	            }
	            if(j<size-1)
	                visit(ar,arrayVisited,i,j+1); // East
	        }
	}

}

class VertexIsland
{
	public int i, j;
	public boolean wasVisited;
	int counter =0;
	
	public VertexIsland(int i, int j)   
	{
		this.i = i;
		this.j = j;
		wasVisited = false;
	}
	  
	public String toString(){
	  return "i "+i+" j "+j;
	}
	
} 

class GraphIsland
{
	private Stack<VertexIsland> theStack;
	Map<VertexIsland, LinkedList<VertexIsland>> adjList;
	
	public GraphIsland()               
	{
		
	    theStack = new Stack<VertexIsland>();
	    adjList = new HashMap<VertexIsland, LinkedList<VertexIsland>>();
	}  
	
	public void addVertex(int i, int j)
    {
		
		VertexIsland vertex = new VertexIsland(i, j);
		adjList.put(vertex, new LinkedList<VertexIsland>());
    }
	
	public void addNeighbor(int i, int j, int iNeighbor, int jNeighbor) {
		
		Iterator<Entry<VertexIsland, LinkedList<VertexIsland>>>iterator= adjList.entrySet().iterator();
		VertexIsland vertexIsland = null;
		VertexIsland vertex = null;
		VertexIsland vertexNeighbor = null;
		
		while (iterator.hasNext()){
			
			vertexIsland = iterator.next().getKey();
			
			if (vertexIsland.i == i && vertexIsland.j ==  j){
				vertex= vertexIsland;
				break;
			}
			
					
		}
		
		iterator= adjList.entrySet().iterator();
		
		while (iterator.hasNext()){
			
			vertexIsland = iterator.next().getKey();			
			
			if (vertexIsland.i == iNeighbor && vertexIsland.j ==  jNeighbor){
				vertexNeighbor= vertexIsland;
				break;
			}
					
		}
		
		if (vertex!=null && vertexNeighbor!=null )
			adjList.get(vertex).add(vertexNeighbor);
		
	}
	
	public void dfs()  
	{                  
		
		Iterator<Entry<VertexIsland, LinkedList<VertexIsland>>>iterator= adjList.entrySet().iterator();
		Entry<VertexIsland, LinkedList<VertexIsland>> first =  iterator.next();  
		VertexIsland vertexIsland = first.getKey();
		vertexIsland.wasVisited = true;
		theStack.push(vertexIsland);
		int contador =0;
		StringBuilder sb = new StringBuilder();
		sb.append(vertexIsland);
		System.out.println(contador); 
		
	    while(!theStack.isEmpty() )
        {
         
	    	
	    	VertexIsland vertexUnvisited = getAdjUnvisitedVertex( theStack.peek() );
	    	if(vertexUnvisited == null)    {
	    		theStack.pop();
	    		
	    	}                
	    		
	    	else                           
	    	{
	    		vertexUnvisited.wasVisited = true;  
	    		sb.append(" ");
	    		sb.append(vertexUnvisited);
	    		theStack.push(vertexUnvisited); 
	    		contador++;
	    	}
	    	
	    	if (theStack.isEmpty() ){
	    		
	    		while (iterator.hasNext()){
	    			
	    			
	    			VertexIsland vertexNext = iterator.next().getKey();
	    			vertexNext.wasVisited = true;
	    			theStack.push(vertexNext);
	    			VertexIsland vertexUnvisitedNext = getAdjUnvisitedVertex( theStack.peek() );
	    			
	    			
	    			if(vertexUnvisitedNext == null)  {
	    				theStack.pop();
	    				
	    			}                  
	    	    		
	    	    	else                           
	    	    	{
	    	    		vertexUnvisitedNext.wasVisited = true;  
	    	    		sb.append(" ");
	    	    		sb.append(vertexUnvisitedNext);
	    	    		theStack.push(vertexUnvisitedNext); 
	    	    		contador++;
	    	    		break;
	    	    	}
	    	    	
	    		}
	    		
	    	}
	    	
	    	
        } 
	    
	    System.out.println(adjList); 	
	    System.out.println(sb); 	
	    System.out.println(contador);
	    
	}
	
	public VertexIsland getAdjUnvisitedVertex(VertexIsland vertex)
	{
		if (adjList.containsKey(vertex)){
		
			Iterator<VertexIsland> iterator  = adjList.get(vertex).iterator();
			
			while (iterator.hasNext()){
				
				VertexIsland vertexIsland = iterator.next();
				
				if (!vertexIsland.wasVisited){
					return vertexIsland;
				}
				
			}			
			
		}
		
		return null;
	}
	
	
}



	
	




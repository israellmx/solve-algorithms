package amazon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AmazonExistsPath {

	public static void main(String[] args) {
		
		GraphExistentPath graphExistentPath = new GraphExistentPath();
		
		int [][] matriz = new int[5][4];

		for (int cols=0;cols<4;cols++){
			for (int rows=0;rows<5;rows++){
				if ( (cols==1 && rows ==1) || (rows==2 && cols ==1) || (rows==4 && cols ==2) )
				{
					matriz[rows][cols]=1;
					graphExistentPath.addVertex(""+rows+cols, false);
				}else
				{
					matriz[rows][cols]=0;
					graphExistentPath.addVertex(""+rows+cols, true);
				}   
			}
		}
		
		for (int indexVetex=0;indexVetex<20;indexVetex++){
			
			System.out.println(graphExistentPath.getVextex(indexVetex));
		}
		
		
		int starti = 3, startj=1, finj=2, fini=0; 
		
		addNeighbor( graphExistentPath);
		
		System.out.println(graphExistentPath.reviewPathExists(new String(""+starti+startj), new String(""+finj+fini)));
		
	}
	
	
	private static void addNeighbor(GraphExistentPath graphExistentPath){
		
		for (int indexVetex=0;indexVetex<20;indexVetex++){
			
			try{
			graphExistentPath.addNeighbor(indexVetex, graphExistentPath.getVextex(indexVetex-1));
			}catch(Exception e){
				
			}
			try{
			graphExistentPath.addNeighbor(indexVetex, graphExistentPath.getVextex(indexVetex+1));
			}catch(Exception e){
				
			}
			try{
				graphExistentPath.addNeighbor(indexVetex, graphExistentPath.getVextex(indexVetex+5));	
			}catch(Exception e){
				
			}
			try{
				graphExistentPath.addNeighbor(indexVetex, graphExistentPath.getVextex(indexVetex-5));	
			}catch(Exception e){
				
			}
			
			
		}
		
		 System.out.println("graphExistentPath "+graphExistentPath.adjList);
		
	} 

}


class StackExistentPath
{
	private final int SIZE = 20;
	private int[] stack;
	private int top;
	
	public StackExistentPath()          
	{
	   stack = new int[SIZE];    // make array
	   top = -1;
	}
	
	public void push(int j)   // put item on stack
	{
		stack[++top] = j; }
	
	public int pop()          // take item off stack
	{ 
		stack[top] = -1;
		return stack[top--]; }
	
	public int peek()         // peek at top of stack
	{ 
		return stack[top]; 
	}
	
	public boolean isEmpty()  // true if nothing on stack
	{
		return (top == -1); }

}  

	class VertexExistentPath
	{
		public String label;        // label (e.g. 'A')
		public boolean active;
		public boolean wasVisited;

		public VertexExistentPath(String lab, boolean active)
		
	    {
			label = lab;
			this.active = active;
			wasVisited = false;
	    }
		
		public String toString(){
			
			return label+" "+active;
		}
	
	} 

	class GraphExistentPath
	{
		private final int MAX_VERTS = 20;
		private VertexExistentPath vertexList[]; 
		private int numberVerts;          
		private int indexListAdjacent;          
		private StackExistentPath theStack;
	    Map<Integer, LinkedList<VertexExistentPath>> adjList;
	    TreeMap<String, Integer> shortestPath = new TreeMap<String, Integer>();
		
		public GraphExistentPath()              
		{
			
			vertexList = new VertexExistentPath[MAX_VERTS];
		    numberVerts = 0;
		    indexListAdjacent = 0;
		    theStack = new StackExistentPath();
		    adjList = new HashMap<Integer, LinkedList<VertexExistentPath>>();
		} 
	
		public void addVertex(String lab, boolean active)
	   {
			VertexExistentPath vertexExistentPath=new VertexExistentPath(lab, active);
			vertexList[numberVerts++] = vertexExistentPath;
			adjList.put(indexListAdjacent++, new LinkedList<VertexExistentPath>());
	   }
		
	   public void addNeighbor(int v1, VertexExistentPath v2) {
		   if (v2!=null)
		   adjList.get(v1).add(v2);
	   }
	   
	   public List<VertexExistentPath> getNeighbors(int v1) {
	        return adjList.get(v1);
	   }
	   
	   public VertexExistentPath getVextex(int index)
	   {
		   return vertexList[index].active?vertexList[index]:null;
	   }
	   
		public void displayVertex(int v)
	    {
			System.out.print(vertexList[v].label);
	    }
		
		public boolean reviewPathExists(String vertixBase, String vertixToFind)  // depth-first search
		{                               
			
			int indexVertixBase = findIndexVertex(vertixBase);
			int indexVertixToFind = findIndexVertex(vertixToFind);
			int counterDepth = 0;
			int vertexUnvisited = -1;
			StringBuilder chainCharofGrahp = new StringBuilder();
			
			if (indexVertixBase > -1){
				
		    	vertexList[indexVertixBase].wasVisited = true;  
			    theStack.push(indexVertixBase); 
			    counterDepth++;
			    chainCharofGrahp.append(vertixBase+"-");

			    while( !theStack.isEmpty()  )     
		        {
		         
			    	vertexUnvisited = getUnvisitedNeighbor( theStack.peek() );
			    	
			    	if(vertexUnvisited == -1) 
			    		theStack.pop();
			    	else                        
			    	{
			    		
			    		counterDepth++;
			    		chainCharofGrahp.append(vertexList[vertexUnvisited].label+"-");
			    		 
			    		//System.out.println("label "+vertexList[vertexUnvisited].label);
			    		
			    		if (vertexUnvisited == indexVertixToFind){
			    			
			    			shortestPath.put(chainCharofGrahp.toString(), counterDepth);	
			    			chainCharofGrahp = new StringBuilder();
			    			counterDepth = 0;
			    			break;
			    		}
			    		
			    		vertexList[vertexUnvisited].wasVisited = true;  // mark it
			    		theStack.push(vertexUnvisited);                 // push it
			    	}
		        } 
				    
			    
			    for(int j=0; j<numberVerts; j++)          
			    	vertexList[j].wasVisited = false;
				
				
			}
			
			
			return !shortestPath.isEmpty();
		    
		}
		
		private int findIndexVertex(String labelVertex){
			
		 	for (int i=0; i<vertexList.length;i++){
		 		
		 		if( vertexList[i].label.equalsIgnoreCase(labelVertex) ){
		 			return i;
		 		}
		 		
		 	}
		 	
		 	return -1;
		}
		
		public int getUnvisitedNeighbor(int v1) {
			
			String key = null;
			
			for ( VertexExistentPath vertexExistentPath:  adjList.get(v1) ){
				
				if (vertexExistentPath.active &&   !vertexList[findIndexVertex(vertexExistentPath.label)].wasVisited){
					key = vertexExistentPath.label;
					break;
				}
					
			}
				
				
	        return findIndexVertex(key);
	   }
		
	}  
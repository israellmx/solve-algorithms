package google;

import java.util.Map.Entry;
import java.util.TreeMap;

/**
FIND THE SHORTEST PATH OF A ORIGIN TO DESTINATION
 ORIGIN A, FIND C
 shortestPath {ABC=3, ADC=3}
  */
public class GoogleShortestPaths {

	public static void main(String[] args) {
		
		GraphDFS theGraph = new GraphDFS();
	      theGraph.addVertex('A');    // 0  (start for dfs)
	      theGraph.addVertex('B');    // 1
	      theGraph.addVertex('C');    // 2
	      theGraph.addVertex('D');    // 3
	      theGraph.addVertex('E');    // 4
	      theGraph.addVertex('R');    // 5
	      theGraph.addVertex('S');    // 6

	      theGraph.addEdge(0, 1);     // AB
	      theGraph.addEdge(1, 2);     // BC
	      theGraph.addEdge(0, 3);     // AD
	      theGraph.addEdge(3, 4);     // DE
	      theGraph.addEdge(3, 2);     // DC
	      theGraph.addEdge(5, 0);     // RB
	      theGraph.addEdge(5, 6);     // RS
	      theGraph.addEdge(6, 2);     // SC
	     

	      theGraph.dfs('A', 'C');   // depth-first search
	      theGraph.deleteMaxPathOfMap();
	      System.out.println("shortestPath "+theGraph.shortestPath);

	}
	
}
	
	class StackDFS
	{
		private final int SIZE = 20;
		private int[] stack;
		private int top;
		// ------------------------------------------------------------
		public StackDFS()           // constructor
		{
		   stack = new int[SIZE];    // make array
		   top = -1;
		}
		// ------------------------------------------------------------
		public void push(int j)   // put item on stack
		{
			stack[++top] = j; }
		// ------------------------------------------------------------
		public int pop()          // take item off stack
		{ 
			stack[top] = -1;
			return stack[top--]; }
		// ------------------------------------------------------------
		public int peek()         // peek at top of stack
		{ 
			return stack[top]; 
		}
		// ------------------------------------------------------------
		public boolean isEmpty()  // true if nothing on stack
		{
			return (top == -1); }
	// ------------------------------------------------------------
	}  // end class StackX
	////////////////////////////////////////////////////////////////
	class VertexDFS
	{
		public char label;        // label (e.g. 'A')
		public boolean wasVisited;
		// ------------------------------------------------------------
		public VertexDFS(char lab)   // constructor
	   {
	   label = lab;
	   wasVisited = false;
	   }
	// ------------------------------------------------------------
	}  // end class Vertex
	////////////////////////////////////////////////////////////////
	class GraphDFS
	{
		private final int MAX_VERTS = 20;
		private VertexDFS vertexList[]; // list of vertices
		private int adjacencyMatrix[][];      // adjacency matrix
		private int numberVerts;          // current number of vertices
		private StackDFS theStack;
		TreeMap<String, Integer> shortestPath = new TreeMap<String, Integer>();
		
		public GraphDFS()               // constructor
		{
			
			vertexList = new VertexDFS[MAX_VERTS];
		                                       // adjacency matrix
		    adjacencyMatrix = new int[MAX_VERTS][MAX_VERTS];
		    numberVerts = 0;
		    for(int y=0; y<MAX_VERTS; y++)      // set adjacency
		      for(int x=0; x<MAX_VERTS; x++)   //    matrix to 0
		         adjacencyMatrix[x][y] = 0;
		    theStack = new StackDFS();
		}  // end constructor
		
		public void addVertex(char lab)
	   {
			vertexList[numberVerts++] = new VertexDFS(lab);
	   }
		
		public void addEdge(int start, int end)
	   {
			adjacencyMatrix[start][end] = 1;
			adjacencyMatrix[end][start] = 1;
	   }
		
		
		public void dfs(char vertixBase, char vertixToFind)  // depth-first search
		{                               
			
			int indexVertixBase = findIndexVertex(vertixBase);
			int indexVertixToFind = findIndexVertex(vertixToFind);
			int counterDepth = 0, vertexUnvisited = -1;
			StringBuilder chainCharofGrahp = new StringBuilder();
			
			if (indexVertixBase > -1){
				
			    while (getIndexAdjUnvisitedVertex( indexVertixBase ) > -1  ){
			    	
			    	vertexList[indexVertixBase].wasVisited = true;  
				    theStack.push(indexVertixBase); 
				    counterDepth++;
				    chainCharofGrahp.append(vertixBase);

				    while( !theStack.isEmpty()  )      // until stack empty,
			        {
			         // get an unvisited vertex adjacent to stack top
				    	vertexUnvisited = getIndexAdjUnvisitedVertex( theStack.peek() );
				    	
				    	if(vertexUnvisited == -1)                    // if no such vertex,
				    		theStack.pop();
				    	else                           // if it exists,
				    	{
				    		
				    		counterDepth++;
				    		chainCharofGrahp.append(vertexList[vertexUnvisited].label);
				    		 
				    		System.out.println("label "+vertexList[vertexUnvisited].label);
				    		
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
				    
			    }
			    
			    // stack is empty, so we're done
			    for(int j=0; j<numberVerts; j++)          // reset flags
			    	vertexList[j].wasVisited = false;
				
				
			}
			
		    
		}  
		// returns an unvisited vertex adj to v
		public int getIndexAdjUnvisitedVertex(int peekStack)
		{
		   for(int j=0; j<numberVerts; j++)
		      if(adjacencyMatrix[peekStack][j]==1 && vertexList[j].wasVisited==false)
		         return j;
		   return -1;
		}  
		
		private int findIndexVertex(char vertixBase){
			
		 	for (int i=0; i<vertexList.length;i++){
		 		
		 		if( vertexList[i].label == vertixBase){
		 			return i;
		 		}
		 		
		 	}
		 	
		 	return -1;
		}
		
		public void deleteMaxPathOfMap(){
			
			Entry<String, Integer> entry= shortestPath.firstEntry();
			
			int keyMinumun =  entry.getValue();
			
			for (Entry<String, Integer> entryMap: shortestPath.entrySet()){
				
				int value=entryMap.getValue();
				
				if (value > keyMinumun)
					shortestPath.remove(entryMap.getKey());
				
			}
			
		}
		
	}  // end class Graph



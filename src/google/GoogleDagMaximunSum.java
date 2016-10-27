package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import google.DAG.Node;

/**
Given a specific type of DAG that forms a pyramid 
(the links have up-down direction),
 in which the node labels are integer, 
 find the path that has the maximum sum of node values. 
 what is the time/space complexity of the algorithm? 

e.g: 
3 
/ \ 
9 4 
/ \ / \ 
1 8 2 
/ \ / \ / \ 
4 5 8 2 
answer: <3,9,8,8>, sum = 3+9+8+8=28
 * */

public class GoogleDagMaximunSum {

	public static void main(String[] args) {
		
		DAG dag = new DAG();
		
		dag.root = new Node();
		
		dag.root.value = 3;
		
		Node node1 = new Node(); 
		node1.value = 1;
		//node1.successors.add(null);
		
		Node node2 = new Node(); 
		node2.value = 2;
		//node2.successors.add(null);
		
		Node node8 = new Node(); 
		node8.value = 8;
		//node8.successors.add(null);
		
		Node node9 = new Node(); 
		node9.value = 9;
		node9.successors.add(node1);
		node9.successors.add(node8);
		
		Node node4 = new Node(); 
		node4.value = 4;
		node4.successors.add(node2);
		node4.successors.add(node8);
		
		dag.root.successors.add(node9);
		dag.root.successors.add(node4);
		
		//https://www.careercup.com/question?id=5732736959512576

	}

}

class DAG {
	
	   Node root; 

	   public static class Node{
		   
	      List<Node> successors = new ArrayList<>();
	      int value;
	      
	   }
	   
	   public int getMaximunSumOfNodes(){
		   
		   Node node = root;
		   int sum = 0;
		   Map<Integer, String > listSumNodes = new HashMap<Integer, String>();
		   StringBuilder pathSb = new StringBuilder();
		   pathSb.append(root.value);
		   
		   while (!node.successors.isEmpty()){
			   
			   for (Node innerNode: node.successors)
			   {
				   
				   listSumNodes.put(sum, pathSb.toString());
				   node = innerNode;
				   break;
			   }
				   
				   
				   
		   }
		   
		   return 0;
		   
	   }
	   
}

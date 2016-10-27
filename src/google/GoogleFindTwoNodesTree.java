package google;

/**
Given an arbitrary tree starting at “root” where each node
 contains a pair of values (x, y), write a boolean function 
 find(Node root, int x, int y) that returns true iff 
* x is equal to a value "x" of any node n1 in the tree 
* and y is equal to a value "y" of any node n2 in the tree 
* and both n1 and n2 are at the same level in the tree 

boolean find(Node root, int x, int y) 

Example: 

(1,120) 
/ | \ 
/ | \ 
/ | \ 
(5,15) (30,70) (80,110) 
/ | \ | 
/ | \ | 
/ | \ | 
(35, 40) (45,50) (55, 65) (90, 100) 

boo == true 
find(root, 45, 100) == true 
find(root, 30, 100) == false 
find(root, 30, 70) == true 
find(root, 70, 30) == false
 * */

public class GoogleFindTwoNodesTree {

	Node root;
	int size = 0;
	
	private class Node {

		int key;
		String name;

		Node leftChild;
		Node rightChild;

		Node(int key, String name) {

			this.key = key;
			this.name = name;

		}

		public String toString() {

			return name + " has the key " + key;

		}

	}
	
	public void addNode(int key, String name){
		
		Node node = root;
		Node newNode = new Node(key, name);

		// If there is no root this becomes root

		if (root == null) {

			root = newNode;
			size++;

		} else {
			
			while (true){
				
				
				if (node.key > newNode.key){
					
				
					if (node.leftChild !=null){
						
						node = node.leftChild;
						
					}else{
						
						node.leftChild = newNode;
						size++;
						return;
					}
					
					
				}else{
					
					if (node.rightChild !=null){
						
						node = node.rightChild;
						
					}
					else{
						
						node.rightChild = newNode;
						size++;
						return;
					}
					
				}
				
			}
			
		}
		
	}
	
	
	public boolean FindDeephNodesIfExists(Node root, int keyOne, int keyTwo){
		
		int nodeOne = findTwoNodes(root, keyOne, true);
		int nodeTwo = findTwoNodes(root, keyTwo, false);
		
		return nodeOne==nodeTwo?true:false;
	}
	
	public int findTwoNodes (Node root, int key, boolean isLeftNodeToFind) {
		
		Node node = root;
		int depth = -1; 
		boolean isRigth = false;
		
		if (root == null) {

			return -1;

		} else {
			
			while (node.key != key){
				
				if (node.key > key){
				
						node = node.leftChild;
						isRigth = false;
				}else{
						node = node.rightChild;
						isRigth = true;
					
				}
				
				if (node == null)
					return -1;
				
				++depth;
			}
			
			if (isRigth && isLeftNodeToFind){
				
				depth = -1;
				
			}
				
			
			return ++depth;
		}
		
	}
	
	public Node findNode(int key) {
		
		Node node = root;
		
		if (root == null) {

			return null;

		} else {
			
			while (node.key != key){
				
				if (node.key > key){
				
						node = node.leftChild;
					
				}else{
						node = node.rightChild;
					
				}
				
				if (node == null)
					return null;
			}
			
			return node;
		}
		
	}
	
	public static void main(String[] args) {
		
		GoogleFindTwoNodesTree theTree = new GoogleFindTwoNodesTree();

		theTree.addNode(50, "Boss");

		theTree.addNode(25, "Vice President");

		theTree.addNode(15, "Office Manager");

		theTree.addNode(30, "Secretary");

		theTree.addNode(75, "Sales Manager");

		theTree.addNode(85, "Salesman 1");
		
		// System.out.println(theTree.findNode(75));
		
		Node rootForSearch =  theTree.findNode(50);
		
		System.out.println(theTree.FindDeephNodesIfExists(rootForSearch, 25, 75));

	}

}

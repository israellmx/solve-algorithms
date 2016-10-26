package google;

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

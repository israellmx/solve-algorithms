package amazon;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 ONLY PRINT ALL THE ELEMENTS OF A MAP 
 * */
public class AmazonUniqueRows {
	
	Node[] buckets = new Node[2];
	int numberBuckets, size;

	private static class Node {
		
		int value;
		Node next = null;
		
		public Node (int value, int key){
			this.value = value;
			
		}
		
	}
	
	public void add (int key, int value ){
		
		int indexHash = hash( key);
		Node node = buckets[indexHash];
		Node newNode = new Node(value, key);
		
		if (node == null){
			buckets[indexHash] = newNode;
			numberBuckets ++;
			size ++;
		}else{
			
			while (node.next!=null){
				node = node.next;
			}
			node.next = newNode;
			size ++;
		}
		
		if (numberBuckets == buckets.length){
			rehash();
		}
		
	}
	
	private void rehash() {
		
		Node[] bucketsResize = new Node[numberBuckets*2];
		int counter = 0;
		
		for (Node node:buckets ){			
			bucketsResize[counter++] =  node;			
		}
		
		buckets = bucketsResize;
		
	}

	void dump() {
		
		int[] finalMatriz = new int[size];
		int counterMatriz =0;
		
		for (int i = 0; i < numberBuckets; i++) {
			
			Node list = buckets[i];
			while (list != null) {
				finalMatriz[counterMatriz++] = list.value;
				list = list.next;
				
			}
		}
		
		System.out.println(Arrays.toString(finalMatriz));
		
	} 
	
	public int hash(int key){
		return key;
	}
	
	
	public static void main(String[] args) {
		
		process();

	}
	
	
	private static void process (){
		
		LinkedHashSet<int[]> set = new LinkedHashSet<int[]>();
		
		int[] arrayOne = new int[3];
		int[] arrayTwo = new int[3];
		int[] arrayThree = new int[4];
		int[] arrayFive = new int[2];
		
		arrayOne[0]=  1;
		arrayOne[1] = 3;
		arrayOne[2] = 4;
		
		arrayTwo[0]=  20;
		arrayTwo[1] = 12;
		arrayTwo[2] = 14;
		
		arrayThree[0]=  19;
		arrayThree[1] = 35;
		arrayThree[2] = 46;
		arrayThree[3] = 27;
		
		arrayFive[0]=  50;
		arrayFive[1] = 16;		
		
		set.add(arrayOne);
		set.add(arrayTwo);
		set.add(arrayThree);
		set.add(arrayFive);
		
		Iterator<int[]> iterator = set.iterator();
		
		int counter = 0;
		AmazonUniqueRows amazonUniqueRows = new AmazonUniqueRows();
		
		while (iterator.hasNext()){
			int[] arrayIt = iterator.next();
			
			for (int number: arrayIt){
				amazonUniqueRows.add(counter, number);
			}
			counter++;
		}
		
		amazonUniqueRows.dump();
		
	}

}

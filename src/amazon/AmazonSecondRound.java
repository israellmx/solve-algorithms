package amazon;

import java.util.ArrayList;

//Given a list of unique and unordered integers, A
//Given a subset of A in random order, B
//
//Write a function that return B in the order its members appear in A
//
//e.g. for input:
//    A = { 2, 9, 4, 7, 3, 19 }
//    B = { 19, 9, 3 }
//
//   output is:
//        { 9, 3, 19 }
public class AmazonSecondRound {

	public static void main(String[] args) {

		    ArrayList<Integer> list = new ArrayList<Integer>();
		    
		    list.add(2);
		    list.add(9);
		    list.add(4);
		    list.add(7);
		    list.add(3);
		    list.add(19);
		    
		    ArrayList<Integer> subList = new ArrayList<Integer>();
		    
		    subList.add(19);
		    subList.add(9);
		    subList.add(3);
		    
		    Integer[] array = subList.toArray(new Integer[subList.size()]);
		    
		    int low = 0;
		    int high = array.length - 1;
		    
		    quickSort(  array, low, high);    
		    
		    
		    for (int index = 0; index<list.size(); index++){
		    
		        int intList = list.get(index);
		        
		        if (binarySearch(  array, intList ) > -1)
		            System.out.println(intList);
		        
		    }

	}
	
	private static void quickSort(Integer[] array, int lo, int hi){
	        
         if (lo < hi  ){
            
            int pivot =  partition (array, lo, hi );  
            
            quickSort( array, lo, pivot-1);                  
            
            quickSort( array, pivot+1, hi);
            
         }
        
    
    }
    
    
    static int partition (Integer[] array, int lo, int hi ){
        
        int pivot = array[hi];
        
        int index = lo ; 
        
        for (int j = lo; j<hi; j++){
            
            if ( array[j] <= pivot ){                               
                
                int aux =  array[j];
                array[j] =  array[index];
                array[index] = aux;                
                index = index +1;
                
            }
            
        }
        
        int aux2 =  array[hi];
        array[hi] =  array[index];
        array[index] = aux2;            
        
        return index;
    }
    
    
    private static int binarySearch( Integer[] array, int key ){
    
        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi) {          
            int middle = lo + (hi - lo) / 2;
            
            if      (key < array[middle])
                     hi = middle - 1;
                     
            else if (key > array[middle])
                     lo = middle + 1;
                     
            else 
                return middle;
        }
        
        return -1;        
    }



}

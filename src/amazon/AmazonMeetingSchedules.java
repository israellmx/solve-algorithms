package amazon;

import java.util.*;

public class AmazonMeetingSchedules {

	public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int k = in.nextInt();
        
        Set<String> set = new TreeSet<String>();
        
        for (int r=0; r<m; r++){
            
            StringBuilder strBuilder = new StringBuilder("");
            
            for (int n=0;n<=3;n++){                
                strBuilder.append(in.next());                
            }                        
            
            set.add(strBuilder.toString());           
        }
        
        process (set,  k, m);        
        
    }
    
   
    static void process (Set<String> set, int k, int m) {
    	
        double minutes = k;
        StringBuilder builderResult = new StringBuilder("");        
        Iterator<String> iterator = set.iterator();               
   
        String strInit = iterator.next();
        int initialPreviousValue = Integer.valueOf(strInit.substring(0,4));
        int majorPreviousValue = Integer.valueOf(strInit.substring(4,8));
        String majorPreviousValueStr = strInit.substring(4,8);
        String initialPreviousValueStr = strInit.substring(0,4);
        
        int counter = 1;
        
        if ( initialPreviousValue >= minutes){
        	builderResult.append("00 00 ");
        	builderResult.append(String.valueOf(strInit).substring(0, 2));
        	builderResult.append(" ");
        	builderResult.append(String.valueOf(strInit).substring(2, 4));
        	builderResult.append("\n");
        }
        
        while (iterator.hasNext()){
        
            String strIterator = iterator.next();
           // System.out.println(strIterator); 
            counter ++;
            int initialValueSet = Integer.valueOf(strIterator.substring(0,4));
            int majorValueSet = Integer.valueOf(strIterator.substring(4,8));
            initialPreviousValueStr = strIterator.substring(0,4);
            Double operation = (double) (initialValueSet - majorPreviousValue)*60d/100d;
            System.out.println("operation "+operation); 
            System.out.println("initialValueSet "+initialValueSet); 
            System.out.println("majorPreviousValue "+majorPreviousValue); 
            
            if ( operation >= minutes && 
            		initialValueSet > majorPreviousValue ){
            	//System.out.println("1encontre " +(initialValueSet - initialPreviousValue > k ));
            	builderResult.append(majorPreviousValueStr.substring(0, 2));
            	builderResult.append(" ");
            	builderResult.append(majorPreviousValueStr.substring(2, 4));
            	builderResult.append(" ");
            	builderResult.append(initialPreviousValueStr.substring(0, 2));
            	builderResult.append(" ");
            	builderResult.append(initialPreviousValueStr.substring(2, 4));
            	builderResult.append("\n");
            }
            
            else if ( counter == m &&  (2400 - majorValueSet) > minutes ){
            	builderResult.append(String.valueOf(majorValueSet).substring(0, 2));
            	builderResult.append(" ");
            	builderResult.append(String.valueOf(majorValueSet).substring(2, 4));
            	builderResult.append(" ");
            	builderResult.append("00 00 ");
            	builderResult.append("\n");
            }
            
            majorPreviousValueStr = strIterator.substring(4,8);         
            majorPreviousValue = majorValueSet;
            initialPreviousValue = initialValueSet;
            
        }
        
        System.out.println(builderResult.toString());
        
    }
	
	
}

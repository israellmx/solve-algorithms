package amazon;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/**
 Amazon Hacker Rank
 in a airplane there are four directions valid L, R, U, D and delete
 with a string of directions print the coordinates of the airplane.
 If the input is not valid print (999, 999)
 
 Example:
 Input: 8U8U
 Output: (0, 16)
 * */
public class AmazonAirPlane {

	static final String FAILURE = "(999, 999)";
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
        String _command;
        String res;
        try {
            _command = in.nextLine();
        } catch (Exception e) {
            _command = null;
        }
        
        try{
        	res = movePlane(_command);	
        }catch (RuntimeException ex){
        	res = "(999, 999)";
        }
        
        System.out.println(res);
	}
	
	
	static String movePlane(String command) {

		String movesValid  = "UDLRX";
		Stack<Commands> stack = new Stack<>();
		String move = null;
		
		for (int r=0; r<command.length(); r++){
			
			move = command.substring(r, r+1);
			
			if (movesValid .contains(move)){
				
				if (move.equals("X")){
					if (!stack.isEmpty()){
						stack.pop();	
					}					
				}else{
					Commands com = new Commands(move, 1);
					stack.add(com);	
				}								
				
			}else{
				
				if (movesValid .contains(command.substring(r+1, r+2))){
					try{
						
						if (command.substring(r+1, r+2).equals("X")){
							if (!stack.isEmpty()){
								stack.pop();	
							}
						}else{
							Commands comm = new Commands(command.substring(r+1, r+2), 
									Integer.valueOf(move));
							stack.add(comm);
							r++;	
						}
						
					}catch(NumberFormatException e){
						return FAILURE;
					}
					
				}else{
					return FAILURE;
				}
				
			}
			
		}
		
		System.out.println(stack);
		
		return execute(stack);

    }
	
	private static String execute(Stack<Commands> stack){
		
		int x =0, y =0;
		Commands comm=null;
		
		while (!stack.isEmpty()){
			
			comm = stack.pop();
			
			switch (comm.commands) {
			case "U":
				y = y + comm.moves;
				break;
			case "D":
				y = y - comm.moves;
				break;
			case "L":
				x = x - comm.moves;
				break;
			case "R":
				x = x + comm.moves;
				break;

			default:
				break;
			}
			
		}
		
		return "("+x +", "+y+")";
	}
	
	
	static class Commands {
		
		String commands;
		int moves;
		
		Commands (String commands,int moves){
			this.commands = commands;
			this.moves = moves;
		}
		
		public String toString(){
			return moves +" "+commands;
		} 
		
	}

}

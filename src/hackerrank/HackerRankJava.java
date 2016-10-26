package hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerRankJava {
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
	    int g = in.nextInt();
	    for(int a0 = 0; a0 < g; a0++){
	    	
	        int white = in.nextInt();
	        int black = in.nextInt();
	        int moves = in.nextInt();
	        Piece[] arrayBlack = new Piece[black];
	        Piece[] arrayWhite = new Piece[white];
			
	        for (int r =0; r<white; r++){
	        	char t =  in.next().charAt(0);
	        	char c =  in.next().charAt(0);
	        	int  ro= in.nextInt();	        	
	        	Piece piece = new Piece(t, c, ro);
	        	arrayWhite[r] = piece;	        	
	        }
			
	        for (int r =0; r<black; r++){
	        	char t =  in.next().charAt(0);
	        	char c =  in.next().charAt(0);
	        	int  ro= in.nextInt();	        	
	        	Piece piece = new Piece(t, c, ro);
	        	arrayBlack[r] = piece;	        	
	        }
	        process (arrayBlack,arrayWhite,  moves );
	    }
	    
    }
	
	static void process (Piece[] arrayBlack,Piece[] arrayWhite, int moves ){
		
		int counterMoves=0;
		
		while (counterMoves < moves){
			
			
			
			
			counterMoves++;
		}
		
		
		
	}
	

	static class Piece{
		
		char type;
		char column;
		int row;
		
		Piece(char type,char column, int row ){
			this.type = type;
			this.column = column;
			this.row = row;
		}
		
		public String toString(){
			return type+" "+column+" "+row;
		}		
	}
	
	
	
}

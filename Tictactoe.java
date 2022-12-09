import java.io.*;
import java.math.*;
import java.util.Scanner;

public class Tictactoe
{
	public int board[][]={{0,0,0},{0,0,0},{0,0,0}};
	public int Ai=1;
	public int User=2;
	public int round=0;
	
	public static void main(String args[])
	{
		Tictactoe m=new Tictactoe();
		Scanner scan=new Scanner(System.in);
		m.printBoard();
		
		//Check If All SpacES Are Depleted 
		for(int sp=0;sp<3;sp++){
		    
		if(m.checkWin() !=0)
		{
			System.out.println("someone won");
			break;
		}else
		{   
		    if(m.play() == 1)
		    {
		       System.out.println("Play.Enter Digit Twice ");
				int x=scan.nextInt();
				int y=scan.nextInt();
				
				if(x >=3 || x <0|| y >=3 || y<0){
				    System.out.println("try Again");
				}else{
				  m.choice(x,y,1);
				}
				
			}else{
			    System.out.println("Thinking");
				m.AiChoose();
			}
		}
			if(m.checkSpace() == 1){
		      sp=0;
		    }else{
		        sp=10;
		        System.out.println("draw");
		    }
	   	}
		
	}
	
	public  int checkSpace(){
	    for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(board[i][j]==0){
				    return 1;
				}
			}
		}
		return 0;
	}
	
	//show board
	public void printBoard(){
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println("\n");
		}
	}
	
	//whose turn
	public int play(){
		return round;
	}
	
	//empty space ai chooses
	public int AiChoose(){
	    ifWin();
	    return 0;
	}
	
	public int ifWin(){
	    //can Also Be Used AS Help For User ie(Last choice(i,j,*); *=1)
	    //If Rows Col1 Can Result To A Win
	    for(int i=0;i<3;i++){
			if(board[i][0] == 0 && board[i][1] == board[i][2] && board[i][1] !=0){
				return choice(i,0,0);
			}
		}
		//Row Col2
		for(int i=0;i<3;i++){
			if(board[i][0] == board[i][2] && board[i][1] == 0 && board[i][2] !=0){
				return choice(i,1,0);
			}
		}
         //row Col3
         for(int i=0;i<3;i++){
			if(board[i][2] == 0 && board[i][1] == board[i][0] && board[i][1] !=0){
				return choice(i,2,0);
			}
		}
		
		
		//col Row1
		for(int j=0;j<3;j++){
			if(board[0][j]== 0 && board[1][j] == board[2][j] && board[1][j] !=0){
				return choice(0,j,0);
			}
		}
		//Col Row2
		for(int j=0;j<3;j++){
			if(board[1][j]== 0 && board[0][j] == board[2][j] && board[0][j] !=0){
				return choice(1,j,0);
			}
		}
		//Col Row3
        for(int j=0;j<3;j++){
			if(board[2][j]== 0 && board[1][j] == board[0][j] && board[1][j] !=0 ){
				return choice(2,j,0);
			}
		}
		
		//side '\'
		  if(board[0][0]==0 && board[1][1]==board[2][2] && board[1][1] !=0 ){
		    	return choice(0,0,0);
	     	}else
	      if(board[1][1]==0 && board[0][0]==board[2][2] && board[0][0] !=0){
		    	return choice(1,1,0);
	     	}else
          if(board[2][2]==0 && board[1][1]==board[0][0] && board[1][1] !=0){
		    	return choice(2,2,0);
	     	}
	     	
        //side '/'
		if(board[0][2]==0 && board[1][1] == board[2][0] && board[1][1] !=0){
			return choice(0,2,0);
		}else
		if(board[1][1]==0 && board[0][2] == board[2][0] && board[0][2] !=0){
			return choice(1,1,0);
		}else
        if(board[2][0]==0 && board[1][1] == board[0][2] && board[1][1] !=0){
			return choice(2,0,0);
		}
		
		System.out.println("Random");
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(board[i][j]==0){
				    return choice(i,j,0);
				}
			}
		}
		System.out.println("ERROR UNKNOWN");
		return 0;
	}
	
	//places choice to board
	public int choice(int a,int b,int c){
		if(c==0){
		    board[a][b]=1;
	 	    round=1;
	 	    System.out.println("Ai Choice ["+a+"]["+b+"]");
		}else
		{
	      if(board[a][b] !=0){
		   System.out.println("choose SOmething Else ");
		    }else{
		   board[a][b]=2;
		   round=0;
		    }
		}
		printBoard();
		return 0;
	}
	
	//check wins  return 1 if win 0 no win
	public int checkWin()
	{
		for(int i=0;i<3;i++){
			if(board[i][0] == board[i][1] && board[i][2] == board[i][0] && board[i][0] !=0){
				return 1;
			}
		}
		//col1
		for(int j=0;j<3;j++){
			if(board[0][j]== board[1][j] && board[2][j] == board[0][j] && board[0][j] !=0){
				return 1;
			}
		}
		//side '\'
		if(board[0][0]==board[1][1] && board[0][0]==board[2][2] && board[0][0] !=0){
			return 1;
		}
//side '/'
		if(board[0][2]==board[1][1] && board[2][0] == board[0][2] && board[0][2] !=0){
			return 1;
		}
		return 0;
	}
	
}
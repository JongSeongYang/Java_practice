package bj2447;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
	
	public static void star(int x, int y, int n, char[][] b) {
		int next = n/3;
		if(n==1) {
			b[y][x]='*';
			return;
		}
		else {
			star(x,y,next, b);
			star(x+next,y,next,b);
			star(x+2*next,y,next,b);
			star(x,y+next,next, b);
			star(x+2*next,y+next,next, b);
			star(x,y+2*next,next, b);
			star(x+next,y+2*next,next, b);
			star(x+2*next,y+2*next,next, b);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = scanner.nextInt();
		char[][] board = new char [n][n];
		
		// init array
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				board[i][j]=' ';
			}
		}
		star(0,0,n,board);
		
		// print array
		/*
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		*/
		for(int i=0;i<n;i++) {
			bw.write(board[i]);
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}

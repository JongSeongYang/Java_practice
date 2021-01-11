package bj2580;

import java.io.*;

public class Main {
	
	public static int [] board = new int[81];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void sudoku(int n) throws Exception {
		if(n==81) {
			for(int i=0;i<81;i++) {
				bw.write(board[i]+" ");
				if(i%9==8)
					bw.write("\n");
			}
			bw.flush();
			bw.close();	
			System.exit(0);
		}
		
		if(board[n]==0) {
			for(int j=1;j<=9;j++) {
				if(check(j,n)) {
					board[n]=j;
					sudoku(n+1);
					board[n]=0;
				}
			}
			board[n]=0;
			return;
		}
		else sudoku(n+1);
	}
	
	public static boolean check(int in, int now) {
		int y = now/9;
		int x = now%9;
		int sec_y = (y/3)*3;
		int sec_x = (x/3)*3;
		for(int i=0;i<9;i++) {
			if(board[y*9+i]==in) return false;
		}
		for(int i=0;i<9;i++) {
			if(board[i*9+x]==in) return false;
		}
		for(int i=sec_y;i<sec_y+3;i++) {
			for(int j=sec_x;j<sec_x+3;j++) {
				if(board[i*9+j]==in) return false;
			}
		}
		return true;
	}
		
	public static void main(String[] args) throws Exception {

		for(int i=0;i<9;i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j=0;j<9;j++) {
				board[i*9+j] = Integer.parseInt(tmp[j]);
			}
		}	
		sudoku(0);
	}

}

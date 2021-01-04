package bj1018;
import java.io.*;

public class Main {

	public static int result=64;
	
	public static int chess(char[][] board, int x, int y) {
		char [][] black = new char[8][8];
		char [][] white = new char[8][8];
		
		int b=0;
		int w=0;
		
		for (int i = y;i < y+8;i++) {
			for (int j = x;j < x + 8;j++)
			{
				black[i - y][j - x] = board[i][j];
				white[i - y][j - x] = board[i][j];
			}
		}
		
		for (int n = 0;n < 8;n++) {
			if (black[n][n] == 'W')
				b++;
			int s = 1;
			for (int i = n + 1;i < 8;i++)
			{
				if (s % 2 == 0)
				{
					if (black[n][i] == 'W')
						b++;
					if (black[i][n] == 'W')
						b++;
				}
				else
				{
					if (black[n][i] == 'B')
						b++;
					if (black[i][n] == 'B')
						b++;
				}
				s++;
			}
		}
		// Ã¹Ä­ÀÌ WÀÏ°Ï¿ì
		for (int n = 0;n < 8;n++)
		{
			if (white[n][n] == 'B')
				w++;
			int s = 1;
			for (int i = n + 1;i < 8;i++)
			{
				if (s % 2 == 0)
				{
					if (white[n][i] == 'B')
						w++;
					if (white[i][n] == 'B')
						w++;
				}
				else
				{
					if (white[n][i] == 'W')
						w++;
					if (white[i][n] == 'W')
						w++;
				}
				s++;
			}
		}

		
		return Math.min(b,w);
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String [] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		char [][] board = new char[N][M];
		
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<M;j++)
				board[i][j] = tmp.charAt(j);
		}
		
		for(int i=0;i+8 <= N;i++) {
			for(int j=0;j+8<=M;j++) {
				result = Math.min(result,chess(board, j, i));
			}
		}
		System.out.print(result);
	}

}

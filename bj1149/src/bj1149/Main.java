package bj1149;

import java.io.*;
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[][] cost = new int [1001][3];
	static int[][] dp = new int [1001][3];
	
	static int RGB(int n, int color) {
		if(n==1) {
			return dp[1][color]=cost[1][color];
		}
		if(dp[n][color]!=0) return dp[n][color];
		else {
			int tmp=2147483647;
			for(int i=0;i<3;i++) {
				if(i!=color)
				{
					tmp = Math.min(tmp, RGB(n-1,i)+cost[n][color]);
				}
			}
			return dp[n][color] = tmp;
		}
	}
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		for(int i=1;i<=N;i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j= 0; j<3;j++)
				cost[i][j]=Integer.parseInt(tmp[j]);
		}
		for(int i=0;i<3;i++)
			RGB(N,i);
		
		int result =Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]);

		System.out.println(result);
	}

}

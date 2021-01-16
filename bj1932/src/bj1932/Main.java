package bj1932;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[][] tri = new int [501][501];
	static int[][] dp = new int [501][501];
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=1;j<=i;j++)
				tri[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=N;i++) {
			intTriangle(N,i);
		}

		System.out.println(findMax(N));
	}
	
	static int intTriangle(int h, int w) {
		if(h ==1) return dp[1][1] = tri[1][1];
		if(dp[h][w] !=0) return dp[h][w];
		else {
			if(w==1) dp[h][w] = intTriangle(h-1,w)+tri[h][w];
			else if(w==h) dp[h][w] = intTriangle(h-1,w-1)+tri[h][w];
			else dp[h][w] = Math.max(intTriangle(h-1,w-1)+tri[h][w], intTriangle(h-1,w)+tri[h][w]);
		}
		return dp[h][w];
	}
	
	static int findMax(int n) {
		int Max = 0;
		for(int i=1;i<=n;i++)
			Max = Math.max(Max, dp[n][i]);
		return Max;
	}
}

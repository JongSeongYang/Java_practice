package bj2579;

import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] stair = new int[301];
	static int[]dp = new int[301];
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		for(int i=1;i<=N;i++)
			stair[i] = Integer.parseInt(br.readLine());
		System.out.println(comeUp(N));
	}
	
	public static int comeUp(int n) {
		if(n==1) return dp[1] = stair[1];
		if(n==2) return dp[2] = stair[1]+stair[2];
		if(n==3) return dp[3] = Math.max(stair[3]+stair[1], stair[2]+stair[3]);
		else if(dp[n]!=0) return dp[n];
		else {
			return dp[n] = Math.max(stair[n]+comeUp(n-2), stair[n]+ stair[n-1] +comeUp(n-3));
		}
	}

}

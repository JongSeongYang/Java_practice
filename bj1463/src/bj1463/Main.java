package bj1463;

import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] dp = new int[1000001];
	
	public static void main(String[] args) throws IOException{
		
		N = Integer.parseInt(br.readLine());
		System.out.println(makeOne(N));
	}
	
	static int makeOne(int n) {
		dp[0] = 0;
		dp[1] = 0;
		for (int i = 2;i <= n;i++){
			dp[i] = dp[i - 1] + 1;
			if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
		}
		return dp[n];
	}
}

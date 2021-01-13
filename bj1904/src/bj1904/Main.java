package bj1904;

import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] dp = new int[1000001];
	
	static int tailes(int n) {
		if(dp[n]!=0)
			return dp[n];
		else
			return dp[n] = (tailes(n-1) + tailes(n-2))%15746;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		N = Integer.parseInt(br.readLine());
		dp[1] = 1;
		dp[2] = 2;
		tailes(N);
		
		System.out.println(dp[N]);
	}

}

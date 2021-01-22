package bj11503;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] arr = new int[1001];
	static int[] dp = new int[1001];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer( br.readLine(), " ");
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			//dp[i] = 1;
		}
		for(int i=1;i<=N;i++)
			LIS(i);
		int result=0;
		for(int i=1;i<=N;i++)
			result = Math.max(result, dp[i]);
		System.out.println(result);
		
	}
	
	static int LIS(int n) {
		if(n==0) return 0;
		if(dp[n]!=1) return dp[n];
		else {
			for(int i=n;i>0;i--) {
				if(arr[i]<arr[n])
					dp[n] = Math.max(dp[n], 1 + LIS(i));
			}
			return dp[n];
		}
	}

}

package bj1912;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] arr = new int[100001];
	static int[] dp = new int[100001];
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[N] = arr[N];
		int result = -1000;
		for(int i = 1;i<=N;i++) {
			result = Math.max(result,sum(i));
		}
		System.out.println(result);
	}
	
	static int sum(int n) {
		if(n==N+1) return 0;
		if(dp[n]!=0) return dp[n];
		else {
			dp[n] = arr[n];
			return dp[n] = Math.max(dp[n], sum(n+1)+arr[n]);
		}
	}

}

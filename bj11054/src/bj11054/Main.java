package bj11054;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] arr = new int[1001];
	static int[] I_dp = new int[1001];
	static int[] D_dp = new int[1001];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer( br.readLine(), " ");
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			I_dp[i] = 1;
			D_dp[i] = 1;
		}
		for(int i=1;i<=N;i++) {
			LIS(i);
			LDS(i);
		}
		int result=0;
		for(int i=1;i<=N;i++)
			result = Math.max(result, I_dp[i]+D_dp[i]);
		System.out.println(result-1);
		
	}
	
	static int LIS(int n) {
		if(n==0) return 0;
		if(I_dp[n]!=1) return I_dp[n];
		else {
			for(int i=n;i>0;i--) {
				if(arr[i]<arr[n])
					I_dp[n] = Math.max(I_dp[n], 1 + LIS(i));
			}
			
			return I_dp[n];
		}
	}
	
	static int LDS(int n) {
		if(n==N+1) return 0;
		if(D_dp[n]!=1) return D_dp[n];
		else {
			for(int i =n+1;i<=N;i++) {
				if(arr[i]<arr[n])
					D_dp[n] = Math.max(D_dp[n], 1 + LDS(i));
			}
			
			return D_dp[n];
		}
	}


}
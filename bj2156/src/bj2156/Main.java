package bj2156;

import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] arr = new int[10001];
	static int[] dp = new int[10001];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		N = Integer.parseInt(br.readLine());
		for(int i=1;i<=N;i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		dp[1] = arr[1];
		dp[2] = arr[1]+arr[2];
		dp[3] =Math.max(Math.max(arr[1]+arr[3], arr[2]+arr[3]), dp[2]);
		
		for(int i=4;i<=N;i++)
			 drink(i);
			
		System.out.println(dp[N]);
	}
	
	static int drink(int n) {
		if(dp[n]!=0) return dp[n];
		else {
			return dp[n] = Math.max(Math.max(arr[n]+drink(n-2), arr[n]+ arr[n-1] +drink(n-3)), dp[n-1]);
		}
	}

}

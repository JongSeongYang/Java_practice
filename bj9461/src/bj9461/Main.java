package bj9461;

import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int testCase;
	static int N;
	static long [] dp = new long [101];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		testCase = Integer.parseInt(br.readLine());
		dp[1]=1;
		dp[2]=1;
		dp[3]=1;
		dp[4]=2;
		for(int i=0;i<testCase;i++) {
			N = Integer.parseInt(br.readLine());
			waveClass(N);
			bw.write(dp[N]+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	static long waveClass(int n) {
		if(dp[n]!=0) return dp[n];
		else
			return dp[n]= waveClass(n-2)+waveClass(n-3);
	}

}

package bj2565;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[][] w;
	static int[] dp = new int[100];

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		w = new int[N][2];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			w[i][0] = Integer.parseInt(st.nextToken());
			w[i][1] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		
		Arrays.sort(w, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		int result=0;
		for(int i=0;i<N;i++) {
			LIS(i);
			result = Math.max(result, dp[i]);
			
		}
		System.out.println(N-result);
		
	}
	
	static int LIS(int n) {
		if(n==N) return 0;
		if(dp[n]!=1) return dp[n];
		else {
			for(int i=n+1;i<N;i++) {
				if(w[n][1] < w[i][1])
					dp[n] = Math.max(dp[n], 1 + LIS(i));
			}
			
			return dp[n];
		}
	}

}




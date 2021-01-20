package bj10844;

import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[][] dp = new int[10][101];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		N = Integer.parseInt(br.readLine());
		int result = 0;
		for(int i=0;i<10;i++) {
			stairNum(i,N);
			result+=dp[i][N];
			result %= 1000000000;
		}
		System.out.println(result);
	}
	
	static int stairNum(int num, int n) {
		if(n==0) return 0;
		if(dp[num][n]!=0) return dp[num][n];
		if(n==1 && num!=0) return dp[num][n]=1;
		else {
			if(num==0) return dp[num][n] = stairNum(num+1,n-1) % 1000000000;
			else if(num == 9) return dp[num][n] = stairNum(num-1,n-1) % 1000000000;
			else return dp[num][n] = (stairNum(num+1,n-1) + stairNum(num-1,n-1)) % 1000000000;
		}
	}

}

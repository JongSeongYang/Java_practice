package bj1003;

import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int testCase;
	static int[] arr;
	static int[] dp = new int[41];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		testCase = Integer.parseInt(br.readLine());
		arr = new int[testCase];
		for(int i=0;i<testCase;i++) {
			arr[i] = Integer.parseInt(br.readLine());	
		}
		for(int i=0;i<testCase;i++) {
			if(arr[i]==0) {
				bw.write("1 0"+"\n");
			}
			else if(arr[i]==1) {
				bw.write("0 1"+"\n");
			}
			else {
				fibonacci(arr[i]);
				bw.write(dp[arr[i]-1]+" "+dp[arr[i]]+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
	
	static int fibonacci(int n) {
		if (n == 0)
		{
			dp[n] = 0;
			return 0;
		}
		else if (n == 1)
		{
			dp[n] = 1;
			return 1;
		}
		if (dp[n] != 0)
			return dp[n];
		else
			return dp[n]= fibonacci(n - 1) + fibonacci(n - 2);
	}

}

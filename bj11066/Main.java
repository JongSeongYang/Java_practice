package bj11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    static int K;;
    static int[] cost;
    static int[] cumulativeSum;
    static int[][] dp = new int[501][501];

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for(int i = 0;i<T;i++){
            K = Integer.parseInt(br.readLine());
            cost = new int[K+1];
            cumulativeSum = new int[K+1];

            String[] tmp = br.readLine().split(" ");
            for (int j = 1; j <= K; j++) {
                cost[j] = Integer.parseInt(tmp[j-1]);
                cumulativeSum[j] = cumulativeSum[j-1]+cost[j];
            }
            System.out.println(merge());
        }
    }
    static int merge(){
        for (int i = 1; i <= K; i++) {
            for (int start = 1; start + i <= K; start++) {
                int end = start + i;
                dp[start][end] = Integer.MAX_VALUE;
                for (int divide = start; divide < end; divide++) {
                    dp[start][end] = Math.min(dp[start][end], dp[start][divide] + dp[divide + 1][end] + cumulativeSum[end] - cumulativeSum[start - 1]);
                }
            }
        }
        return dp[1][K];
    }
}

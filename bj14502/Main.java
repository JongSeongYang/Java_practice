package bj14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int twoNum = 0;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[N][M];
        int oneNum = 0;
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
                if(arr[i][j] == 1) oneNum++;
            }
        }
        System.out.println(N*M-(wall(3, 0, 0)+oneNum+3));
    }

    static void bfs(int[] start){
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        twoNum++;
        check[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for(int i=0;i<4;i++){
                int[] next = {now[0]+dy[i], now[1]+dx[i]};
                if(next[0]>=0 && next[0]<N && next[1]>=0 && next[1]<M){
                    if(arr[next[0]][next[1]] == 0 && !check[next[0]][next[1]]){
                        q.offer(next);
                        check[next[0]][next[1]] = true;
                        twoNum++;
                    }
                }
            }
        }
    }

    static int wall(int num, int y, int x){
        if(num == 0){
            twoNum =0;
            check = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(arr[i][j] == 2) {
                        int[] start = {i,j};
                        bfs(start);
                    }
                }
            }
            return twoNum;
        }
        int result = N*M;

        for (int i = y; i < N; i++) {
             for (int j = 0; j < M; j++) {
                 if(arr[i][j] == 0) {
                     arr[i][j] = 1;
                     result = Math.min(wall(num-1, i, j), result);
                     arr[i][j] = 0;
                 }
             }
        }
        return result;
    }
}

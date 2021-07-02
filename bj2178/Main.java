package bj2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static int result;
    static int[][] arr;
    static boolean[][] check;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        String[] tmp1 = br.readLine().split(" ");
        N = Integer.parseInt(tmp1[0]);
        M = Integer.parseInt(tmp1[1]);
        arr = new int[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }
        /*
        dfs로 할 때 필요
         */
        // result = M*N;
        // check[0][0] = true;
        // dfs(1,0,0);
        // System.out.println(result);
        bfs(0,0);
        System.out.println(arr[N-1][M-1]);
    }

    public static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        int[] p = {y,x};
        q.offer(p);
        check[y][x] = true;

        while (!q.isEmpty()) {
            int[] v = q.poll();
            //System.out.println("pixel : "+v[0] + " " + v[1]);
            for(int i = 0;i<4;i++) {
                int ny = v[0] + dy[i];
                int nx = v[1] + dx[i];
                if (ny < 0 || nx < 0 || ny >= N || nx >= M || arr[ny][nx] == 0 || check[ny][nx])
                    continue;
                check[ny][nx] = true;
                int[] nv = {ny, nx};
                q.offer(nv);
                arr[ny][nx] = arr[v[0]][v[1]] + 1;
            }
        }
    }

    public static void dfs(int cnt, int y, int x){
        //System.out.println("pixel : "+y + " " + x);
        if(y == N-1 && x == M-1){
            result = Math.min(cnt, result);
            return;
        }
        for(int i = 0;i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny<0 || nx<0 || ny>=N || nx>=M || arr[ny][nx] ==0 || check[ny][nx])
                continue;
            check[ny][nx] = true;
            dfs(cnt + 1, ny, nx);
            check[ny][nx] = false;
        }
    }
}

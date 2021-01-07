package bj15650;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int M;
	
	public static void backtracking(int num, int[] arr, int pre) throws Exception {
		if(num==M) {
			for(int i = 0;i<M;i++) {
				bw.write(arr[i]+ " ");
			}
			bw.write("\n");
			return;
		}
		for(int i=pre+1;i<=N;i++) {
			int check = 0;
			for(int j = 0;j<num;j++) {
				if(arr[j]==i) {
					check = 1;
					break;
				}
			}
			if(check == 1) continue;
			arr[num] = i;
			backtracking(num+1, arr, i);
			arr[num]=0;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		int[] arr = new int[M]; 
		backtracking(0, arr, 0);
		
		bw.flush();
		bw.close();
	}
}

package bj7568;

import java.io.*;

public class Main {
	
	public static int check_weight_height(int N, int index, int[][] arr) {
		int result=1;
		
		for(int i=0;i<N;i++) {
			if(i==index) continue;
			else {
				if(arr[index][0]<arr[i][0] && arr[index][1] < arr[i][1])
					result++;
			}
		}
		
		return result;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int [][] arr = new int [N][2];
		
		for(int i=0;i<N;i++) {
			String[] tmp = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(tmp[0]);
			arr[i][1] = Integer.parseInt(tmp[1]);
		}
		for(int i=0;i<N;i++) {
			bw.write(check_weight_height(N,i, arr)+" ");
		}
		bw.flush();
		bw.close();
	}

}

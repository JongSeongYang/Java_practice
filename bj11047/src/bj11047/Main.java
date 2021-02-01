package bj11047;

import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int K;
	static int[] coin = new int[10];
	static int result=0;
	
	public static void main(String[] args) throws IOException {

		String [] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		K = Integer.parseInt(tmp[1]);
		for(int i=0;i<N;i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		coinZero();
		System.out.println(result);
	}
	
	static public void coinZero() {
		while(true) {
			if(K==0) return;
			for(int i=0;i<N;i++){
				if(i==N-1){
					if(K>=coin[i]) {
						int cnt = K/coin[i];
						result += cnt;
						K = K-cnt*coin[i];
						break;
					}
				}
				else {
					if(K<coin[i+1] && K>=coin[i]) {
						int cnt = K/coin[i];
						result += cnt;
						K = K-cnt*coin[i];
						break;
					}
				}
			}	
		}
	}

}

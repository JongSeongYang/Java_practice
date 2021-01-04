package bj2798;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static int result =0;
	public static int min = 0;
	
	public static void blackJack(int[] card, int N, int M) {
		for (int i = 0;i < N;i++) {
			for (int j = i + 1;j < N;j++) {
				for (int k = j + 1;k < N;k++) {
					int Add = card[i]+card[j]+card[k];
					if(Add<=M && (M-Add)<min) {
						min=M-Add;
						result=Add;
					}
				}
			}
		}

	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);
		String[] tmp_card = br.readLine().split(" ");
		min=M;
		int[] card = new int[N];
		
		for(int i=0;i<N;i++) {
			card[i] = Integer.parseInt(tmp_card[i]);
		}
		blackJack(card,N,M);
		System.out.print(result);
	}

}

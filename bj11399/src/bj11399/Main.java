package bj11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static Integer[] p;
	static int result=0;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		p = new Integer[N];
		String [] tmp = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			p[i] = Integer.parseInt(tmp[i]);
		}
		
		Arrays.sort(p, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
					return o1 - o2;
			}
		});

		ATM();
		System.out.println(result);
	}
	
	static public void ATM() {
		for(int i=0;i<N;i++) {
			result += (N-i)*p[i]; 
		}
	}
}

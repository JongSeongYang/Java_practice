package bj9663;
import java.io.*;

public class Main {

	public static int N;
	public static int[] arr;
	public static int cnt=0;
	
	public static void N_Queen(int x) {
		if(x==N) {
			cnt++;
			return;
		}
		for(int i=0;i<N;i++) {
			arr[x]=i;
			if(check(x) == 1) N_Queen(x+1);
		}
	}
	
	public static int check(int x) {
		for(int i=0;i<x;i++) { 
			if(arr[x] == arr[i]) return -1;
			else if(Math.abs(x-i) == Math.abs(arr[x]-arr[i])) return -1;
		}
		return 1;
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		N_Queen(0);
		
		System.out.println(cnt);
	}

}

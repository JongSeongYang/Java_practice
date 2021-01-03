package bj11729;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	/*
	public static void print(StringBuilder s) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(s);
		
	}
	*/
	public static StringBuilder sb = new StringBuilder();
	public static void hanoi(int n, char s, char t, char e) {
		
		if(n==1) {
			sb.append(s+" "+ e+"\n");
			return;
		}
		else {
			hanoi(n-1,s,e,t);
			sb.append(s+" "+ e+"\n");
			hanoi(n-1,t,s,e);
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int N = Integer.parseInt(s);
		sb.append((int) (Math.pow(2, N) - 1)).append('\n');
		hanoi(N,'1','2','3');
		System.out.println(sb);
	}
}

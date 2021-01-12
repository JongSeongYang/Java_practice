package bj14889;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][]arr;
	static int Min = Integer.MAX_VALUE;
	static boolean[] team;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		team = new boolean[N];
	
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		makeTeam(0,0);
		System.out.println(Min);
	}
	
	static void makeTeam(int num, int member) {
		if(num ==N/2) {
			calDiff();
			return;
		}
		for(int i=member;i<N;i++) {
			if(!team[i]) {
				team[i]=true;
				makeTeam(num+1,i+1);
				team[i]=false;
			}
		}
	}
	
	static void calDiff() {
		int S_start=0;
		int S_link=0;
		
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				if(team[i]==true &&  team[j]==true) {
					S_start+=arr[i][j];
					S_start+=arr[j][i];
				}
				else if(team[i]==false &&  team[j]==false) {
					S_link+=arr[i][j];
					S_link+=arr[j][i];
				}
			}
		}
		int gap = Math.abs(S_start-S_link);
		if(gap==0) {
			System.out.println(gap);
			System.exit(0);
		}
		Min = Math.min(gap, Min);
	}
	
	
}

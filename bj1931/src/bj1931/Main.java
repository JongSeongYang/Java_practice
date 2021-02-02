package bj1931;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[][] room;
	static int result = 0;
	
	public static void main(String[] args) throws IOException{
		
		N = Integer.parseInt(br.readLine());
		room = new int[N][2];
		for(int i=0;i<N;i++) {
			String[] tmp = br.readLine().split(" ");
			room[i][0] = Integer.parseInt(tmp[0]);
			room[i][1] = Integer.parseInt(tmp[1]);
		}
		
		Arrays.sort(room, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[]o2) {
				if(o1[1]==o2[1]) 
					return o1[0] - o2[0];
				else
					return o1[1] - o2[1];
			}
		});
		selectRoom();
		System.out.println(result);
		

	}
	
	public static void selectRoom() {
		int now_t = 0;
		for (int i = 0;i < N;i++)
		{
			if (now_t <= room[i][0])
			{
				now_t = room[i][1];
				result++;
			}
		}
	}

}

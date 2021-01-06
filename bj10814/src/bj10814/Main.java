package bj10814;

import java.io.*;
import java.util.Arrays; 
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int N = Integer.parseInt(br.readLine());
		
		String[][] name = new String[N][3];
		
		for(int i=0;i<N;i++) {
			String[] tmp = br.readLine().split(" ");
			name[i][1] = tmp[0];
			name[i][2] = tmp[1];
			name[i][0] = ""+i;
		}
		
		Arrays.sort(name, new Comparator<String[]>(){
			@Override
			public int compare(String[] o1, String[] o2) {
				if(Integer.parseInt(o1[1])==Integer.parseInt(o2[1])) 
					return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
				else
					return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
			}
		});
		for(int i=0;i<N;i++) {
			bw.write(name[i][1] + " " + name[i][2]+ "\n");
		}
		bw.flush();
		bw.close();
	}

}

package bj1436;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int i = 666;
		while(true) {
			String s = ""+i;
			if(s.contains("666")) {
				cnt++;
			}
			if(cnt==N) {
				break;
			}
			i++;
		}
		System.out.print(i);
	}
}

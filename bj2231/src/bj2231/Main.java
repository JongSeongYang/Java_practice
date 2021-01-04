package bj2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int tmp = 1;
		int result=0;
		while (true)
		{
	        // 범위별로 앞에서부터 탐색
			if (tmp < 10) result = tmp + tmp;
			else if (10 <= tmp && tmp < 100) result = tmp + tmp / 10 + tmp % 10;
			else if (100 <= tmp && tmp < 1000) result = tmp + tmp / 100 + (tmp % 100) / 10 + (tmp % 10);
			else if (1000 <= tmp && tmp < 10000) result = tmp + tmp / 1000 + (tmp % 1000) / 100 + (tmp % 100) / 10 + tmp % 10;
			else if (10000 <= tmp && tmp < 100000) result = tmp + tmp / 10000 + (tmp % 10000) / 1000 + (tmp % 1000) / 100 + (tmp % 100) / 10 + tmp % 10;
			else result = tmp + tmp / 100000 + (tmp % 100000) / 10000 + (tmp % 10000) / 1000 + (tmp % 1000) / 100 + (tmp % 100) / 10 + tmp % 10;
			// M 과 N이 같다면 반복문 탈출
	        if (result == N)
			{
	        	result = tmp;
				break;
			}
	        // 값이 N보다 커지면 안되므로 
	        // 0 값을 넣고 반복문 종료
			else if (tmp >= N)
			{
				result = 0;
				break;
			}
	        tmp++;
		}
		System.out.print(result);
	}

}

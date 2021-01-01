package bj1065;
import java.util.Scanner;

public class Main {
	
	public static int splitNum(int a) {
		int o =0;
		int t =0;
		int h =0;
		int split = a;
		int result=0;
		
		int n=(int)Math.pow(10, 2);
		h = split/n;
		split-=h*n;
		
		n=(int)Math.pow(10, 1);
		t = split/n;
		split-=t*n;
		
		n=(int)Math.pow(10, 0);
		o = split/n;
		split-=o*n;

		result=check(o,t,h);
		return result;
	}
	
	public static int check(int o, int t, int h) {
		int result=0;
		if((o-t)==(t-h)) {
			result=1;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int result=0;
		for(int i=1;i<=N;i++) {
			if(i<=99) {
				result++;
			}
			else {
				if(splitNum(i)==1) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
}

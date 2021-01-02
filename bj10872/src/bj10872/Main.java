package bj10872;
import java.util.Scanner;

public class Main {

	public static int factorial(int a) {
		if(a==0) return 1;
		else return (a*factorial(a-1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int N=scanner.nextInt();
		int result = factorial(N);
		System.out.println(result);
	}
}

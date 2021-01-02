package bj10870;
import java.util.Scanner;

public class Main {

	public static int fibonacci(int a) {
		if(a==0) return 0;
		else if(a==1) return 1;
		else return (fibonacci(a-1) + fibonacci(a-2));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int result = fibonacci(n);
		System.out.println(result);
	}

}

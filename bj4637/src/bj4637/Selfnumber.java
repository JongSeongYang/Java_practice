package bj4637;

public class Selfnumber {
	
	public static void function(int a, int[] b) {
		int nowNum = a;
		while(nowNum<=10000) {
			b[nowNum]=1;		
			nowNum=sum(nowNum);			
		}	
	}
	
	public static int sum(int a) {
		int nextNum = a;
		int splitNum = a;
		
		for(int j=0;j<4;j++) {
			int n=(int)Math.pow(10, 3-j);
			int tmp=splitNum/n;
			nextNum+=tmp;
			splitNum-=tmp*n;
		}	
		return nextNum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[10001];
		for(int i=1;i<=10000;i++) {
			if(num[i]==0) {
				function(i,num);
				System.out.println(i);
			}
		}
	}

}

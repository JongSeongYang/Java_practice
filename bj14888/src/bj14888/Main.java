package bj14888;

import java.io.*;

public class Main {

	static int N;
	static int[] num;
	static int[] operator = new int[4];
	static int min = 2147483647;
	static int max = -2147483648;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static int operate(int a, int b, int op) {
		int result=0;
		if(op==0) result = a+b;
		else if(op==1) result = a-b;
		else if(op==2) result = a*b;
		else if(op==3) {
			if(a<0) {
				a=(-1)*a;
				int tmp = a/b;
				result = -tmp;
			}
			else result=a/b;
		}
		return result;
	}
	
	public static void Put(int preResult, int useOpNum) throws Exception {
		if(useOpNum==N-1) {
			if(preResult<=min) min=preResult;
			if(preResult>=max) max=preResult;
			return;
		}
		for(int i=0;i<4;i++) {
			int result;
			if(operator[i]!=0) {
				result = operate(preResult,num[useOpNum+1], i);
				operator[i]--;
				Put(result,useOpNum+1);
				operator[i]++;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		N = Integer.parseInt(br.readLine());
		num=new int[N];
		String[] tmp = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			num[i]=Integer.parseInt(tmp[i]);
		}
		String[] tmp2 = br.readLine().split(" ");
		for(int i=0;i<4;i++) {
			operator[i]=Integer.parseInt(tmp2[i]);
		}
		Put(num[0],0);
		bw.write(max+"\n");
		bw.write(min+"\n");
		bw.flush();
		bw.close();
	}

}

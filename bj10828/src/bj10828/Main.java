package bj10828;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static Stack<String> stack = new Stack<>();
	
	public static void main(String[] args) throws IOException, EmptyStackException {
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			String[] tmp = br.readLine().split(" ");
			if(tmp[0].equals("push"))
				stack.push(tmp[1]);
			else if(tmp[0].equals("top"))
				if(stack.empty())
					bw.write("-1\n");
				else
					bw.write(stack.peek()+"\n");
			else if(tmp[0].equals("size"))
				bw.write(stack.size() + "\n");
			else if(tmp[0].equals("pop")) {
				if(stack.empty())
					bw.write("-1\n");
				else
					bw.write(stack.pop() + "\n");
			}
			else if(tmp[0].equals("empty")) {
				if(stack.empty())
					bw.write("1\n");
				else
					bw.write("0\n");
			}
		}
		bw.flush();
		bw.close();
		
	}
	

}

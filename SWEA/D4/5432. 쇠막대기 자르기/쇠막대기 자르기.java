import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack = new Stack<>();
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=tc;i++) {
			int res = 0;
			String[] tmp = br.readLine().split("");
			
			for(int j=0;j<tmp.length;j++) {
				if (tmp[j].equals("(")) stack.push(tmp[i]); // 열린괄호이면 스택에 넣기
				else {
					stack.pop();
					if(tmp[j-1].equals("(")) { // 그 전에 닫는 괄호이면 레이저
						res += stack.size();
					}
					else res+=1; // 그 전에 닫는 괄호였을경우, 쇠막대기 조각개수 추가
				}
			}
			
			System.out.printf("#%d %d\n",i,res);
		}
		
	}

}
import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=tc;i++) {
			int res = 0;
			String[] original = br.readLine().split(""); // 원래상태 
			String[] buffer = new String[original.length]; // 초기상태
			Arrays.fill(buffer, "0"); // 배열을 0으로 채우기
			
			for(int j=0;j<original.length;j++) {
				
				if(buffer.equals(original)) break;
				else {
					if(!(original[j].equals(buffer[j]))) {
						if(original[j].equals("1")) { // 1일경우
							for(int k=j;k<original.length;k++) {
								buffer[k] = "1";
							}
						}
						else { // 0일경우
							for(int k=j;k<original.length;k++) {
								buffer[k] = "0";
							}
						}
						
						res++;
					}
				
				}
				
			}
			
			System.out.printf("#%d %d\n",i,res);
		}
		
	}

}
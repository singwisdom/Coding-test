import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			int n = Integer.parseInt(br.readLine());
			int[] block = new int[n];
			String[] tmp = br.readLine().split(" ");
			int up = 0, down = 0;
			
			for (int i = 0; i < block.length; i++) {
				block[i] = Integer.parseInt(tmp[i]); // 블록 높이 입력받기
			}
			
			for (int i = 0; i < block.length-1; i++) {
				
				if(block[i+1] - block[i] > 0) {
					up = Math.max(up, block[i+1] - block[i]);
				}
				else if(block[i]> block[i+1]) {
					down = Math.max(down, block[i] - block[i+1]);
				}
			}
			
			bw.write("#"+t+" "+up+" "+down+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
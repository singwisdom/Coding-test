

import java.util.Arrays;
import java.util.Iterator;
import java.io.*;

public class Solution {
	
	public static int[] where(String[][] arr, int h, int w) {
		int[] res = new int[2];
		for (int j = 0; j < h; j++) {
			 for (int k = 0; k < w; k++) {
				if(arr[j][k].equals("<") || arr[j][k].equals(">") || arr[j][k].equals("^") || arr[j][k].equals("v")) {
					res[0] = j;
					res[1] = k; // 현재 전차의 위치 파악
				}
			 }
		}
		return res;
}		

	public static void main(String[] args) throws IOException {
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 int tc = Integer.parseInt(br.readLine());
		 
		 for (int i = 1; i <= tc; i++) {
			 String[] buffer = br.readLine().split(" ");
			 int h = Integer.parseInt(buffer[0]);
			 int w = Integer.parseInt(buffer[1]);
			 int r = 0;
			 int c = 0;
			 String[][] map = new String[h][w];
			 
			 for (int j = 0; j < h; j++) {
				 String[] input = br.readLine().split("");
 				 for (int k = 0; k < w; k++) {
 					if(input[k].equals("<") || input[k].equals(">") || input[k].equals("^") || input[k].equals("v")) {
 						r = j;
 						c = k; // 현재 전차의 위치 파악
 					}
					map[j][k] = input[k]; // 배열에 입력하기
				}
				
			}
			 
			 int n = Integer.parseInt(br.readLine()); // 문자열의 길이 (명렁어 개수)
			 String[] command = br.readLine().split(""); // 명령어
			 for (int a = 0; a < command.length; a++) {
				 
				 if(command[a].equals("U")) { // 전차가 바라보는 방향 위쪽으로 바꾸고 평지라면 이동
					 int[] tmp = where(map,h,w);
					 r = tmp[0];
					 c = tmp[1];
					 
					 map[r][c] = "^";
					 if(r-1>=0 && map[r-1][c].equals(".")) {
						 map[r][c] = ".";
						 map[r-1][c] = "^";
					 }
					 
				 }
				 
				 else if(command[a].equals("D")) {
					 int[] tmp = where(map,h,w);
					 r = tmp[0];
					 c = tmp[1];
					 map[r][c] = "v";
					 if(r+1<h && map[r+1][c].equals(".")) {
						 map[r][c] = ".";
						 map[r+1][c] = "v";
					 }
				 }
				 
				 else if(command[a].equals("L")) {
					 int[] tmp = where(map,h,w);
					 r = tmp[0];
					 c = tmp[1];
					 map[r][c] = "<";
					 if(c-1>=0 && map[r][c-1].equals(".")) {
						 map[r][c] = ".";
						 map[r][c-1] = "<";
					 }
				 }
				 
				 else if(command[a].equals("R")) {
					 int[] tmp = where(map,h,w);
					 r = tmp[0];
					 c = tmp[1];
					 map[r][c] = ">";
					 if(c+1<w && map[r][c+1].equals(".")) {
						 map[r][c] = ".";
						 map[r][c+1] = ">";
					 }
				 }
				 
				 else if (command[a].equals("S")){
					 int[] tmp = where(map,h,w);
					 r = tmp[0];
					 c = tmp[1];
					 
					 if(map[r][c].equals("^")) { // 위쪽을 바라보는 전차라면
						 for(int b=0;b<=r;b++) {
							 if(map[r-b][c].equals("#")) {break;}
							 else if(map[r-b][c].equals("*")) {
								 map[r-b][c] = ".";
								 break;
							 }
								 
						 }
					 }
					 else if(map[r][c].equals("v")) { // 아래쪽을 바라보는 전차라면
						 for(int b=0;b<h-r;b++) {
							 if (map[r+b][c].equals("#")){break;}
							 else if(map[r+b][c].equals("*")) {
								 map[r+b][c] = ".";
								 break;
							 }
						 }
					 }
					 else if(map[r][c].equals("<")) { // 왼쪽을 바라보는 전차라면
						 for(int b=0;b<=c;b++) {
							 if (map[r][c-b].equals("#")){break;}
							 else if(map[r][c-b].equals("*")) {
								 map[r][c-b] = ".";
								 break;
							 }
						 }
					 }
					 else if(map[r][c].equals(">")) { // 오른쪽을 바라보는 전차라면
						 for(int b=0;b<w-c;b++) {
							 if (map[r][c+b].equals("#")){break;}
							 else if(map[r][c+b].equals("*")) {
								 map[r][c+b] = ".";
								 break;
							 }
						 }
					 }
					 
					 
				 }
				
				
			}
			 
			bw.write("#"+i+" ");
			for(int l=0;l<h;l++) {
				for(int s=0;s<w;s++) {
					bw.write(map[l][s]+"");
				}
					
				bw.write("\n");
			}
			
			
			
		}
			 
		 bw.flush();
			bw.close();
			br.close();

	}

}

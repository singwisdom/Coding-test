import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int count, inputR, inputC, answer;
	static boolean find;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		inputR = Integer.parseInt(st.nextToken());
		inputC = Integer.parseInt(st.nextToken());
		
		recursive(N, 0, 0);
		
		bw.write(count+"\n");
		bw.flush();
	}
	
	private static void recursive(int N, int r, int c) {
		
		if(N==0) {
			return;
		}
		
		int size = (int) Math.pow(2, N-1);
		int area = size * size;
		
		// 1사분면
		if(inputR < r+size && inputC < c+size) {
			recursive(N-1, r, c);
		}
		
		// 2사분면
		else if(inputR < r+size && inputC >= c+size ) {
			count += area;
			recursive(N-1, r, c+size);
		}
		
		// 3사분면
		else if(inputR >= r+size && inputC < c+size) {
			count += 2*area;
			recursive(N-1, r+size, c);
		}
		
		// 4사분면
		else if(inputR >= r+size && inputC >= c+size) {
			count += 3*area;
			recursive(N-1, r+size, c+size);
		}
	}

}
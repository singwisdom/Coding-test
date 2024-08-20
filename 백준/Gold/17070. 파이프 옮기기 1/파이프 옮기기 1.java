import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map;
	static int N,count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 집의 크기
		map = new int[N][N];
		count = 0; // 개수 세는 변수
		
		// 배열 입력받기
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		dfs(0,1,0); // r,c는 파이프 끝의 위치, k는 파이프의 상태(가로,세로,대각선)
		System.out.println(count);
	}

	private static void dfs(int r, int c, int k) {
		// 목적지에 도착했다면 return
		if(r==N-1 && c==N-1) {
			count+=1;
			return;
		}
		
		// 가로인 경우
		if(k==0) {
			if(c+1<N && map[r][c+1]!=1) dfs(r,c+1,0); // 가로
			if(r+1 <N && c+1<N) {
				if(map[r+1][c]!=1 && map[r][c+1]!=1 && map[r+1][c+1]!=1) dfs(r+1,c+1,2); // 대각선
			}
		}
		// 세로인 경우
		else if(k==1) {
			if(r+1<N && map[r+1][c]!=1) dfs(r+1,c,1);// 세로
			if(r+1 <N && c+1<N) {
				if(map[r+1][c]!=1 && map[r][c+1]!=1 && map[r+1][c+1]!=1) dfs(r+1,c+1,2); // 대각선
			}
			
		}
		// 대각선인 경우
		else if(k==2) {
			if(c+1<N && map[r][c+1]!=1) dfs(r,c+1,0); // 가로
			if(r+1<N && map[r+1][c]!=1) dfs(r+1,c,1);// 세로
			if(r+1 <N && c+1<N) {
				if(map[r+1][c]!=1 && map[r][c+1]!=1 && map[r+1][c+1]!=1) dfs(r+1,c+1,2); // 대각선
			}
		}
		
	}

}
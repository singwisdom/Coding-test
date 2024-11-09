import java.io.*;
import java.util.*;

public class Solution {

	static int N,K,max,res;
	static int[][] map;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static boolean[][] visit;
	static boolean isCut;
 	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 지도의 크기
			K = Integer.parseInt(st.nextToken()); // 최대 공사 가능 깊이
			map = new int[N][N];
			max = res = 0;
			
			/* 배열 입력받기 */
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}
			
			/* max인 곳에서 dfs 돌리기 ? */
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == max) {
						visit = new boolean[N][N];
						isCut = false;
						visit[i][j] = true;
						dfs(i,j,1);
					}
				}
			}
			bw.write("#"+tc+" "+res+"\n");
		}
		bw.close();

	}
 	
	private static void dfs(int r, int c, int count) {
		// 리턴 어떻게 할건데 ?
		res = Math.max(res, count);
		//print(visit); // 디버깅용 함수
		
		for (int i = 0; i < 4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			
			if(nr>=0 && nr<N && nc>=0 && nc<N && !visit[nr][nc]) {
				if(map[nr][nc] < map[r][c]) { // 공사 없이 갈 수 있다면 방문
					visit[nr][nc] = true;
					dfs(nr, nc, count+1);
					visit[nr][nc] = false;
				} else {
					// 공사를 해야 갈 수 있다면 
					if(!isCut && (map[nr][nc]-K < map[r][c])) {
						isCut = true;
						visit[nr][nc] = true;
						int tmp = map[nr][nc];
						map[nr][nc] = map[r][c]-1;
						dfs(nr, nc, count+1);
						map[nr][nc] = tmp;
						isCut = false;
						visit[nr][nc] = false;
					}
				}
				
			}
		}
		
	}

	private static void print(boolean[][] visit2) {
		for (int i = 0; i < visit2.length; i++) {
			System.out.println(Arrays.toString(visit[i]));
		}
		System.out.println("==========================");
		
	}

}

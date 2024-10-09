import java.io.*;
import java.util.*;

public class Main {

	static int N,M, cnt;
	static int[][] map, dp;
	static boolean[][] visit;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 가로
		M = Integer.parseInt(st.nextToken()); // 세로
		map = new int[N][M];
		dp = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dp[i][j] = -1;
			}
		}
		
		// DFS
		cnt = dfs(0,0);
		
		bw.write(cnt+"\n");
		bw.flush();

	}
	
	private static int dfs(int r, int c) {
		if(r==N-1 && c ==M-1) return 1; // 목적지에 도착했으면 return
		
		if(dp[r][c]!=-1) return dp[r][c]; // 이미 계산된 경로가 있다면
		
		visit[r][c] = true; // 방문처리
		int cntPath = 0;
		
		for (int i = 0; i < dr.length; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0 && nr<N && nc>=0 && nc<M) {
				if((map[r][c] > map[nr][nc]) && !visit[nr][nc]) {
					cntPath += dfs(nr,nc);
				}
			}
		}
		
		dp[r][c] = cntPath; // 현재 위치에서 목표지점까지 경로의 수 업데이트
		visit[r][c] = false; // 방문표시 해제
		
		return dp[r][c];
		
	}

}
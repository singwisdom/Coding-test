import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] map, dp;
	static boolean[][] visit;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int max = Integer.MIN_VALUE;
		
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		dp = new int[N][N];
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // 배열 입력받기
			}
		}
		
		
		initDP();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int res = eatBamboo(i, j);
				max = Math.max(max, res);
			}
		}
		
		bw.write(max+"\n");
		bw.close();

	}
	

	private static void initDP() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dp[i][j] = -1; // dp 배열 초기화 하기
			}
		}
		
	}

	private static int eatBamboo(int r, int c) {
		
		// dp에 저장된 경로가 있다면 return
		if(dp[r][c]!=-1) return dp[r][c];
		
		dp[r][c] = 1; // Top-Down DP
		
		for (int i = 0; i < dr.length; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if(nr>=0 && nr<N && nc>=0 && nc<N && !visit[nr][nc] && (map[r][c] < map[nr][nc])) {
				dp[r][c] = Math.max(dp[r][c], eatBamboo(nr,nc)+1);
			}
		}

		return dp[r][c];
	}

}
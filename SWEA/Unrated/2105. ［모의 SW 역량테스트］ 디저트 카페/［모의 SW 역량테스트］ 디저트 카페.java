import java.io.*;
import java.util.*;

public class Solution {

	static int N, res, max, flag;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { -1, 1, 1, -1 };
	static int[] start = new int[2];
	static boolean[] dessert;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // TC 개수
		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			max = Integer.MIN_VALUE;
			res = -1;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 모든 곳에서 백트래킹 돌려보기 ?!
			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {
					visit = new boolean[N][N];
					dessert = new boolean[101];
					start[0] = i;
					start[1] = j;
					visit[i][j] = true;
					dessert[map[i][j]] = true;
					dfs(i, j, 1, 0);

				}
			}
			res = (max != Integer.MIN_VALUE) ? max : -1;
			bw.write("#" + tc + " " + res + "\n");
		}
		bw.close();
	}

	private static void dfs(int r, int c, int k, int prevDir) {
		// 출발점으로 돌아왔다면 return
		if (start[0] == r && start[1] == c && k>2) {
			max = Math.max(k-1, max);
			return;
		}

		for (int i = prevDir; i < dc.length; i++) { // 이전 방향을 같이 기억해줘야 함
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if (!visit[nr][nc] && !dessert[map[nr][nc]]) {
					visit[nr][nc] = true;
					dessert[map[nr][nc]] = true;
					dfs(nr, nc, k + 1, i); // dfs 호출
					visit[nr][nc] = false;
					dessert[map[nr][nc]] = false;
				} else if (nr == start[0] && nc == start[1] && k > 2) {
					dfs(nr, nc, k + 1, i); // dfs 호출 (다시 출발점으로 돌아가는 경우)
				}

			}
		}

	}

}

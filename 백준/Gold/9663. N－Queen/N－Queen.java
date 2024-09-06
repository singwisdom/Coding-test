import java.io.*;
import java.util.*;

public class Main {

	static int N, count;
	static boolean[] visit;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine()); // 체스판의 크기
		map = new int[N][N];
		visit = new boolean[N];
		count = 0; // 경우의 수

		// 퀸 => 상,하,좌,우,대각선 (8방향으로 공격 가능)

		dfs(0, visit); // 0,0에서 시작

		// 정답 출력
		System.out.println(count);

	}

	// cnt:depth(깊이), c가 현재
	private static void dfs(int cnt, boolean[] visit) {

		// N개의 퀸이 놓였을 경우, 경우의 수 +1
		if (cnt == N) {
			count += 1;
			return;
		}

		for (int i = 0; i < N; i++) {
			// 대각선으로 넣는 것이 가능하다면 !
			if (!visit[i] && isPossible(cnt, i)) {

				map[cnt][i] = 1;
				visit[i] = true;
				dfs(cnt + 1, visit);

				// 원복을 해주자 !
				map[cnt][i] = 0;
				visit[i] = false;

			}
		}

	}

	// 대각선을 확인하는 함수
	private static boolean isPossible(int r, int c) {

		// 1시방향 대각선 확인해주기
		int nr = r - 1;
		int nc = c + 1;
		while (true) {
			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if (map[nr][nc] != 0)
					return false;
			}
			else break;
			nr -= 1;
			nc += 1;
		}

		// 11시방향 대각선 확인하기
		nr = r-1;
		nc = c-1;
		while(true) {
			if(nr>=0 && nr<N && nc>=0 && nc<N) {
				if(map[nr][nc]!=0) return false;
			}
			else break;
			nr-=1;
			nc-=1;
		}
		return true;
	}

}
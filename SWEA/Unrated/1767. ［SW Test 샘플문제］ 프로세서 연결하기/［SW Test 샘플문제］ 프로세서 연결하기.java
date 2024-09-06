import java.util.*;
import java.io.*;

public class Solution {

	static int n;
	static int[][] map;
	static int pCnt; // 프로세스
	static ArrayList<Point> arrayList;
	static int coreMax;
	static int lineMin;

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // TC의 개수

		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine()); // map의 크기
			map = new int[n][n];
			arrayList = new ArrayList<>();
			coreMax = Integer.MIN_VALUE;
			lineMin = Integer.MAX_VALUE;

			for (int r = 0; r < n; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < n; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if (map[r][c] == 1) {
						if (r == 0 || r == n - 1 || c == 0 || c == n - 1) {
							continue;
						}

						arrayList.add(new Point(r, c)); // 프로세서 리스트에 집어넣기
					}
				}
			}

			// idx, k,
			recur(0, 0, 0);

			bw.write("#"+tc+" "+lineMin+"\n");

		}
		bw.flush();
	}

	

	// 프로세서를 연결하는 경우와 하지 않는 경우.
	private static void recur(int idx, int k, int line) {
		if (idx == arrayList.size()) {
			if(k>coreMax) {
				coreMax = k;
				lineMin = line;
			}
			else if(k==coreMax) {
				lineMin = Math.min(lineMin, line);
			}
			return;
		}
		Point p = arrayList.get(idx);

		for (int i = 0; i < 4; i++) {
			int nr = p.r + dr[i];
			int nc = p.c + dc[i];

			int lineCnt = 0; // 라인의 개수를 세는 변수

			boolean flag = false;
			while (true) {

				if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
					flag = true;
					break;
				}

				if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == 0) {
					map[nr][nc] = 2;
					lineCnt += 1;
				}
				else break;

				nr += dr[i];
				nc += dc[i];
			}

			if (flag) {
				recur(idx + 1, k + 1, line + lineCnt); // 연결하는 경우
			}

			for (int j = 0; j < lineCnt; j++) {
				nr -= dr[i];
				nc -= dc[i];
				map[nr][nc] = 0;
			}

		}

		recur(idx + 1, k, line); // 연결하지 않는 경우
	}

	private static void printMap(int[][] map) {
		for (int r = 0; r < n; r++) {
			System.out.println(Arrays.toString(map[r]));
		}
		System.out.println("");
	}

	private static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

}
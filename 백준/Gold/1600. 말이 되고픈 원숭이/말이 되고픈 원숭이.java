// 틀린 이유 : 기본으로 원숭이로 움직이고, 그 다음에 말처럼 이동할 수 있으면 이동해야하는데,
// 처음부터 말 or 원숭이 처럼 움직이게 해서 틀린 것 같음
import java.io.*;
import java.util.*;

public class Main {

	static int k, w, h, min;
	static int[][] map;
	static boolean[][][] visit;
	static int[] hr = { -1, -2, -2, -1, 1, 1, 2, 2 }; // 말이 움직이는 방법?
	static int[] hc = { 2, 1, -1, -2, 2, -2, 1, -1 };
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static boolean is_End = false;

	static class Node {
		int r;
		int c;
		int dist;
		int hores;

		public Node(int r, int c, int dist, int hores) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.hores = hores;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		k = Integer.parseInt(br.readLine()); // 원숭이가 말처럼 뛸 수 있는 횟수
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken()); // 열
		h = Integer.parseInt(st.nextToken()); // 행

		map = new int[h][w]; // map 배열 선언
		visit = new boolean[h][w][k + 1]; // 방문 배열
		for (int i = 0; i < h; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 배열 입력받기
		}

		bfs();
		if (!is_End)
			System.out.println(-1);

	}

	private static void bfs() {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(0, 0, 0, 0)); // 시작점 큐에 넣기
		visit[0][0][0] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int r = node.r;
			int c = node.c;

			if (r == h - 1 && c == w - 1) {
				System.out.println(node.dist);
				is_End = true;
				return;
			}

			// 기본으로 원숭이 움직이기
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr >= 0 && nr < h && nc >= 0 && nc < w) {
					if (map[nr][nc] != 1 && !visit[nr][nc][node.hores]) {
						visit[nr][nc][node.hores] = true;
						queue.add(new Node(nr, nc, node.dist + 1, node.hores));
					}
				}
			}

			// 말처럼 움직일 수 있다면 말처럼 움직이기
			if (node.hores < k) {
				for (int i = 0; i < 8; i++) {
					int nr = r + hr[i];
					int nc = c + hc[i];

					if (nr >= 0 && nr < h && nc >= 0 && nc < w) {
						if (map[nr][nc] != 1 && !visit[nr][nc][node.hores + 1]) {
							visit[nr][nc][node.hores + 1] = true;
							queue.add(new Node(nr, nc, node.dist + 1, node.hores + 1));
						}
					}
				}
			}

		}

	}

}

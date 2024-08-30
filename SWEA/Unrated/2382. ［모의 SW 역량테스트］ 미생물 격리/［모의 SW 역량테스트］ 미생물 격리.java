import java.io.*;
import java.util.*;

public class Solution {

	static class Micro {
		public int name; // 군집명
		public int r, c; // 위치
		public int count; // 미생물수
		public int dir; // 이동방향 (상,하,좌,우 순서)

		public Micro(int name, int r, int c, int count, int dir) {
			super();
			this.name = name;
			this.r = r;
			this.c = c;
			this.count = count;
			this.dir = dir;
		}

	}

	static int N, M, K;
	static ArrayList<Micro> list;
	static int[][] map;
	static Queue<Micro> queue;
	static int[] dr = { 0, -1, 1, 0, 0 }; // 이동방향 (상,하,좌,우 순서)
	static int[] dc = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // TC개수
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // map의 크기
			M = Integer.parseInt(st.nextToken()); // 격리시간
			K = Integer.parseInt(st.nextToken()); // 미생물 군집 개수
			map = new int[N][N];
			list = new ArrayList<Micro>(); // 미생물 군집을 담을 리스트
			queue = new ArrayDeque();

			// 미생물 군집 배열 저장하기
			for (int i = 0; i < K; i++) {
				int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				list.add(new Micro(i + 1, tmp[0], tmp[1], tmp[2], tmp[3])); // 군집의 넘버링은 1부터 시작 !!
			}

			// M만큼 반복 아래 2개 -> 돌려보고 나중에 추가하기
			for (int time = 1; time <= M; time++) {
				// 군집의 count가 0이 아닌 애들만 큐에 넣어주기

				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).count != 0) {
						queue.add(list.get(i)); // 큐에 미생물 군집 정보 넣어주기
					}
				}

				// BFS로 돌리기
				bfs();

				// 다 돌리고 count가 0인 요소 제거
				for (int i = list.size() - 1; i >= 0; i--) {
					if (list.get(i).count == 0)
						list.remove(i);
				}
			}

			// 답 구하기
			int sum = 0;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).count != 0)
					sum += list.get(i).count;
			}
			bw.write("#" + tc + " " + sum + "\n");

		}
		bw.flush();

	}

	private static void bfs() {
		// BFS 메인 로직
		while (!queue.isEmpty()) {
			// 큐에서 꺼내서 이동하기
			Micro m = queue.poll();

			// System.out.println("현재 미생물 위치" + m.r + " " + m.c + " " + "미생물 정보:" + m.name +
			// " 개수:" + m.count + " 방향:" + m.dir);
			m.r = m.r + dr[m.dir];
			m.c = m.c + dc[m.dir];
		}

		// 리스트 돌면서 각각의 경우의 수 확인
		for (int i = 0; i < list.size(); i++) {

			Micro m = list.get(i);

			// 약품이 있는 구역이라면 방향 바꾸기
			if (m.r == 0 || m.r == N - 1 || m.c == 0 || m.c == N - 1) {
				if (m.dir == 1 || m.dir == 3) {
					m.dir += 1;
				} else if (m.dir == 2 || m.dir == 4) {
					m.dir -= 1;
				}

				// 위치, 미생물 개수 업데이트 하기
				m.count /= 2;
			}

			else {
				ArrayList<Micro> tmpList = new ArrayList<>();
				int max = 0;

				// 같은 구역에 있는 애들 찾기
				for (int j = 0; j < list.size(); j++) {
					// 같은 구역에 있다면,
					if (list.get(j).r == m.r && list.get(j).c == m.c) {
						tmpList.add(list.get(j));
						max = Math.max(max, list.get(j).count);

					}
				}

				int sum = 0;
				int maxMicroIdx = -1;
				for (int j = 0; j < tmpList.size(); j++) {
					Micro tmp = tmpList.get(j);
					// 합쳐질 애들의 미생물 개수만 담기
					if (tmp.count != max) {
						sum += tmp.count;
						tmp.count = 0;
					} else {
						maxMicroIdx = j;
					}
				}
				// 다 돌고 난 후 maxIdx에 count값 저장하기
				if (maxMicroIdx >= 0)
					tmpList.get(maxMicroIdx).count += sum;
			}

		}

	}

	// 디버깅용 함수
	private static void print() {

		for (int i = 0; i < list.size(); i++) {
			Micro m = list.get(i);
			if (m.count != 0)
				map[m.r][m.c] = m.count;
		}

		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println("===================");
	}

}
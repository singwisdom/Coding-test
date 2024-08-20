import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 변수선언
		int N = Integer.parseInt(st.nextToken()); // 가로
		int M = Integer.parseInt(st.nextToken()); // 세로
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][] origin = new int[N][M];

		// 배열에 입력받기
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		int spin = (Math.min(N, M)) / 2; // N과 M중에 짧은거 / 2 => 회전횟수

		// R만큼 배열 돌리기
		for (int i = 0; i < R; i++) {
			
			for (int j = 0; j < origin.length; j++) {
				origin[j] = map[j].clone(); // 배열 복사
				// origin[i] = map[i]; 이렇게 하면 주소값이 들어가서 origin값이 유지되지 않음!
			}
			
			int r = 0;
			int c = 0;

			for (int j = 0; j < spin; j++) {
				r = j;
				c = j;
				int dir = -1;
				int nr = j, nc = j;

				while (true) {
					// r과 c가 꼭짓점인지 점검하기
					if ((nr == j && nc == j) || (nr == N - 1 - j && nc == j) || (nr == N - 1 - j && nc == M - 1 - j)
							|| (nr == j && nc == M - 1 - j)) {
						dir += 1;
					}
					if (dir >= 4) break;

					nr = r + dr[dir]; // 가야하는 방향의 r,c
					nc = c + dc[dir];
					// System.out.println("r:" + r + " c:" + c + " nr:" + nr + " nc:" + nc);
					map[nr][nc] = origin[r][c];

					// 좌표값 업데이트
					r = nr;
					c = nc;
				}

			}

		}

		// 정답 출력
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				System.out.print(map[j][k]+" ");
			}
			System.out.println();
		}

	}

}
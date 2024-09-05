/*
 * 틀린 이유 : 문제 이해를 잘못함 4번타자를 1번 선수로 생각함,,,,
 */
import java.io.*;
import java.util.*;

public class Main {

	static int[] baseball, numbers;
	static int[][] player;
	static boolean[] visit;
	static int max, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine()); // 이닝 수
		baseball = new int[3]; // 1루-2루-3루
		player = new int[N][9]; // 각 이닝에서 선수들이 얻는 결과
		max = Integer.MIN_VALUE;
		visit = new boolean[9];
		numbers = new int[9];

		// 선수들 정보 입력받기
		for (int i = 0; i < N; i++) {
			player[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		// '1번 선수를 4번타자'로 설정하자 !!
		numbers[3] = 0;
		visit[0] = true;

		permutation(0);

		System.out.println(max);

	}

	// 순열 함수
	private static void permutation(int k) {

		if (k == 9) {
			// 순열이 다 만들어졌다면 게임을 시작해보쟝!
			// 게임 시작 !!
			max = Math.max(max, game());
			return;
		}

		if (k == 3) {
			permutation(k + 1);
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				numbers[k] = i;
				permutation(k + 1);
				visit[i] = false;
			}
		}

	}

	private static int game() {
		int score = 0; // 경기득점
		int out = 0; // 아웃
		int order = 0; // 선수 순서

		// 중간에 3아웃이 되었다면 다음 이닝 실행, 아웃이 되면 이닝+1
		for (int i = 0; i < N; i++) {
			out = 0;
			baseball = new int[3];

			while (out < 3) {

				int result = player[i][numbers[order]]; // 타자가 이닝에서 얻는 결과

				if (result == 0) {
					out += 1; // 아웃 +1 증가
				} else if (result == 1) {
					// 안타 (타자와 모든 주자 한 루씩 증가) -> 3루에 사람이 있으면 득점 +1
					if (baseball[2] == 1) {
						score += 1;
					}
					for (int j = 1; j >= 0; j--) {
                        baseball[j + 1] = baseball[j];
                    }

					// 1루에 타자 추가해주기
					baseball[0] = 1;

				} else if (result == 2) {
					// 2루타 -> 2,3루에 사람이 있으면 각각 득점+1, 1루에 있는 사람들은 3루로
					// 타자는 2루에 추가해주기
					if (baseball[2] == 1) {
						score += 1;
						baseball[2] = 0;
					}
					if (baseball[1] == 1) {
						score += 1;
					}

					if (baseball[0] == 1) {
						baseball[2] = 1;
						baseball[0] = 0; // 이 코드 추가 안해줘서 이상했음..
					}

					baseball[1] = 1; // 타자는 2루에

				} else if (result == 3) {
					// 3루타 -> 1,2,3루에 사람이 있으면 각각 득점 +1
					if (baseball[0] == 1) {
						score += 1;
						baseball[0] = 0;
					}
					if (baseball[1] == 1) {
						score += 1;
						baseball[1] = 0;
					}
					if (baseball[2] == 1) {
						score += 1;
						baseball[2] = 0;
					}

					// 타자는 3루에 배치
					baseball[2] = 1;

				} else if (result == 4) {
					// 홈런 -> 1,2,3루에 사람이 있으면 각각 득점 +1
					for (int j = 0; j < baseball.length; j++) {
						if (baseball[j] == 1) {
							score += 1;
							baseball[j] = 0;
						}
					}
					// 타자도 홈으로 진루하니 타자 점수+1 해주기
					score += 1;
				}

				order = (order + 1) % 9;
			}

		}

		return score;

	}

}
import java.io.*;
import java.util.*;

/*
 * 1. 테스트 케이스를 입력받는다.
 * 
 * 2. 셀들의 특성을 검사한다.
 * 
 * 3. 검사했는데 맞는게 없다 ? 그러면 약품 투입해 - 약품 투입하고 다시 검사한다.
 * 
 * 4. 검사 했는데 성능을 통과한다. 그러면 약품 최소 투입 횟수 업데이트해
 */

public class Solution {

	static int R, C, K, min;
	static boolean isMinUpdate;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			map = new int[R][C];

			// 배열을 입력받는다.
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); // A가 0, B가 1
				}
			}

			if (doCellTest() || K==1) {
				min = 0; // 약품처리 없이 통과 한다면 바로 답 출력
			} else {
				doMedicine(0, 0); // 약품 처리를 해야되겠죠 ?
			}
			bw.write("#" + tc + " " + min + "\n");
		}

		bw.close();
	}

	// 약품 처리를 해봅시다 !
	private static void doMedicine(int idx, int count) {
		//print();// 디버깅 해보쟈
		//System.out.println("=====================");

		// 검사 통과하면 return
		if (doCellTest()) {
			if (min > count) {
				min = count;
				isMinUpdate = true;
				return;
			}
		}

		// idx가 R이어도 return
		if (idx == R) {
			return;
		}

		if (min > count) {
			int[] tmpMap = map[idx].clone(); // 임시 배열에 저장하기

			// A를 투입한다. (B는 투입 안해)
			Arrays.fill(map[idx], 0);
			doMedicine(idx + 1, count + 1); // 다음 함수 호출
			map[idx] = tmpMap.clone(); // 원상복구 시키기

			// B를 투입한다. (A는 투입 안해)
			Arrays.fill(map[idx], 1);
			doMedicine(idx + 1, count + 1); // 다음 함수 호출
			map[idx] = tmpMap.clone(); // 원상복구 시키기

			// 아무것도 투입하지 않는다.
			doMedicine(idx + 1, count);
		}

	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			System.out.println(Arrays.toString(map[i]));
		}

	}

	private static boolean doCellTest() {
		int isPassCount = 0;
		int kCount = 0;

		// 열의 개수만큼 for문을 돌려
		for (int i = 0; i < C; i++) {
			// 0번 인덱스부터 k개만큼 계속 확인해서 isPass값을 1씩 업데이트해준다. 그리고 isPass가 나오는게 있으면 break하고 다음셀
			// 검사해
			for (int j = 0; j < R - K + 1; j++) {
				kCount = 0;
				int flag = map[j][i];
				for (int k = 0; k < K; k++) {
					if (map[j + k][i] == flag)
						kCount += 1;
					else
						break;
				}

				if (kCount == K) {
					isPassCount += 1;
					break;
				}
			}
			
			if(kCount != K) return false;
		}

		// 마지막에는 isPass의 개수와 열의 개수가 같은지 확인하자
		if (isPassCount == C)
			return true;
		return false;

	}

}

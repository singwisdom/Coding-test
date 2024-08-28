import java.io.*;
import java.util.*;

public class Main {

	static int[][] cycle;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 톱니바퀴 배열 => N극:0, S극:1
		cycle = new int[4][8]; 
		int[] center = new int[4]; // 12시 방향은 처음에 0번 인덱스로 초기화
		
		for (int i = 0; i < 4; i++) {
			cycle[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		
		int K = Integer.parseInt(br.readLine()); // 회전 횟수
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()); // 회전시킨 톱니바퀴 번호
			int dir = Integer.parseInt(st.nextToken()); // 방향 1:시계방향, -1:반시계 방향
			// 메인 로직 : 맞닿은 극을 확인하고 돌리기
			cycleOperation(num-1,dir);
		}
		
		// 점수 계산하기
		int result = 0;
		for (int i = 0; i < 4; i++) {
			if(cycle[i][0] == 1) {
				result += Math.pow(2, i);
			}
		}
		System.out.println(result);

	}

	// 회전시킬 톱니바퀴를 구하는 함수
	private static void cycleOperation(int idx, int dir) {
		
		leftSide(idx-1, -dir); // 왼쪽 톱니바퀴
		rightSide(idx+1, -dir); // 오른쪽 톱니바퀴
		rotation(idx,dir); // 회전하기
		
	}

	private static void rotation(int num, int dir) {
		if(dir==1) {
			// 시계방향 회전
			int tmp = cycle[num][7];
			for (int i = 7; i>0; i--) {
				cycle[num][i] = cycle[num][i-1]; // 배열 값 옮겨주기
			}
			cycle[num][0] = tmp;
		}
		else {
			// 반시계방향 회전
			int tmp = cycle[num][0];
			for (int i = 0; i<7; i++) {
				cycle[num][i] = cycle[num][i+1]; // 배열 값 옮겨주기
			}
			cycle[num][7] = tmp;
		}
	}

	private static void rightSide(int idx, int dir) {
		if(idx>3) return;
		if(cycle[idx][6]==cycle[idx-1][2]) return; //극이 같으면 회전 안하기
		rightSide(idx+1, -dir);
		rotation(idx, dir);
		
	}

	private static void leftSide(int idx, int dir) {
		if(idx <0) return;
		if(cycle[idx][2]==cycle[idx+1][6]) return; // 극이 같으면 회전하지 않음
		leftSide(idx-1, -dir);
		rotation(idx, dir);
		
	}

}
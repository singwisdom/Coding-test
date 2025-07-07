import java.io.*;
import java.util.*;

public class Main {

	static int res = Integer.MAX_VALUE;
	static int N, M;
	static int[][] map, chicken;
	static int[][] sel;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) cnt+=1;
			}
		}

		// 치킨집 구하기
		chicken = new int[cnt][2];
		int tmp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 2) {
					chicken[tmp][0] = i;
					chicken[tmp][1] = j;
					tmp+=1;
				}
			}
		}
		
		// 조합 구하기
		for (int i = 0; i <= M; i++) {
			sel = new int[M][2];
			combination(0,0);
		}
		
		bw.write(res+"\n");
		bw.flush();
	}
	
	// idx : 원본배열의 순서값, k : 선택한 갯수
	private static void combination(int idx, int k) {

		if(k == sel.length) {
			int tmpMin = 0;
			int min = 0;
			// 각 집마다 치킨거리 구하기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==1) {
						tmpMin = Integer.MAX_VALUE;
						for (int num = 0; num < sel.length; num++) {
							tmpMin = Math.min(tmpMin, Math.abs(sel[num][0]-i) + Math.abs(sel[num][1]-j));
						}
						min += tmpMin;
					}
					
				}
			}
			res = Math.min(res, min);
			return;
		}
		
		if(idx==chicken.length) return;
		
		// 선택하는 경우
		sel[k][0] = chicken[idx][0];
		sel[k][1] = chicken[idx][1];
		combination(idx+1, k+1);
		
		// 선택하지 않는 경우
		combination(idx+1, k);
	}

}

import java.io.*;
import java.util.*;

public class Main {

	static int[][] map, chicken, sel;
	static int N,M, result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = Integer.MAX_VALUE;
		int cnt = 0;
		
		map = new int[N][N];
		
		// 맵 입력받기 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) cnt+=1;
			}
		}
		
		// 치킨집 구하기 (치킨집 좌표 저장)
		chicken = new int[cnt][2];
		int tmp = 0;
		
		for(int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if(map[i][j]==2) {
					chicken[tmp][0] = i;
					chicken[tmp][1] = j;
					tmp+=1;
				}
			}
		}
		
		
		// 조합 구하기 		
		for (int i = 1; i <= M; i++) {
			sel = new int[M][2];
			combination(0,0);
			
		}
		
		bw.write(result+"\n");
		bw.close();
	
	}
	
	// idx : 원본배열의 순서값, k : 선택한 갯수
	private static void combination(int idx, int k) {
		
		if(k==sel.length) {
			// 치킨거리 구하기
			int tmpResult = 0;
			for(int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					// 집을 발견
					if(map[r][c]==1) {
						int tmpLength = Integer.MAX_VALUE;
						for (int i = 0; i < sel.length; i++) {
							tmpLength = Math.min(Math.abs(sel[i][0] - r) + Math.abs(sel[i][1] - c), tmpLength);
						}
						tmpResult += tmpLength;
					}
				}
			}
			result = Math.min(result, tmpResult);
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

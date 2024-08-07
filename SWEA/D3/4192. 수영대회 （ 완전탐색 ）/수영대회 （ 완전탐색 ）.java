import java.util.*;
import java.io.*;

public class Solution {

	static Deque<int[]> deque = new ArrayDeque<>();
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n]; // 수영장 크기
			
			// 배열에 상태 저장하기, 0: 지나갈 수 있음, 1: 장애물
			for (int i = 0; i < n; i++) { 
				int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				map[i] = tmp;
			}
			int[] ab = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 시작위치
			int[] cd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 도착위치
			
			bfs(ab); // 시작위치부터 시작
			if(map[cd[0]][cd[1]]==1 || map[cd[0]][cd[1]]<=1) System.out.printf("#%d %d\n",t,-1);
			else System.out.printf("#%d %d\n",t, map[cd[0]][cd[1]]);
		}

	}
	private static void bfs(int[] ab) {
		deque.add(ab); // 시작 위치
		int r = 0, c = 0;
		
		while(!deque.isEmpty()) {
			int[] tmp = deque.poll();
			r = tmp[0]; c = tmp[1];
			for (int i = 0; i < 4; i++) {
				if(r+dr[i]>=0 && r+dr[i]<n && c+dc[i]>=0 && c+dc[i]<n) { // 범위 안에 들어온다면 큐에 넣고 탐색
					if(map[r+dr[i]][c+dc[i]] == 0) {
						deque.add(new int[] {r+dr[i], c+dc[i]});
						map[r+dr[i]][c+dc[i]] = map[r][c]+1;
					}
				}
			}
			
		}
		
	}

}
import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static int n,m;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray(); // 배열에 입려받기
		}
		
		bfs(); // bfs 탐색
		System.out.println(map[n-1][m-1]);

	}

	private static void bfs() {
		Queue<int[]> queue = new ArrayDeque();
		queue.add(new int[] {0,0});
		
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			int r = arr[0];
			int c = arr[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				
				if(nr>=0 && nr<n && nc>=0 && nc<m) {
					if(map[nr][nc]==1) { // 이동할 수 있다면 이동하기
						queue.add(new int[] {nr,nc});
						map[nr][nc] = map[r][c]+1; // dist+1 해주기
					}
				}
			}
		}
		
		
	}

}

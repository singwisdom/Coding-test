import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	static boolean visit[][];
	static int n,m;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			visit = new boolean[n][m];
			int count = 0;
			
			for (int i = 0; i < k; i++) {
				int[] tmp = Arrays.stream(br.readLine().split(" " )).mapToInt(Integer::parseInt).toArray();
				map[tmp[1]][tmp[0]] = 1; // 배추의 위치 저장
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(map[i][j]==1 && !visit[i][j]) {
						bfs(new int[] {i,j});
						count+=1;
					}
				}
			}
			
			System.out.println(count);
			
		}
	}

	private static void bfs(int arr[]) {
		Queue<int[]> queue = new ArrayDeque();
		queue.add(arr);
		visit[arr[0]][arr[1]] = true;
		
		while(!queue.isEmpty()) {
			int[] tmp= queue.poll();
			int r = tmp[0];
			int c = tmp[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr>=0 && nr<n && nc>=0 && nc<m) {
					if(map[nr][nc] == 1 && !visit[nr][nc]) {
						queue.add(new int[] {nr,nc});
						visit[nr][nc] = true;
					}
				}
			}
		}
		
	}

}

import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		int endX = 0;
		int endY = 0;
		
		// 배열 입력받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					endX = i;
					endY = j;
				}
			}
		}
		
		// BFS 돌리기
		Deque<Node> queue = new ArrayDeque<>();
		queue.add(new Node(endX, endY, 0));
		visited[endX][endY] = true;
		map[endX][endY] = 0;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			for (int i = 0; i < dr.length; i++) {
				int nr = n.r+dr[i];
				int nc = n.c+dc[i];
				if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] && map[nr][nc] ==1) {
					queue.add(new Node(nr, nc, n.cnt+1));
					visited[nr][nc] = true;
					map[nr][nc] = n.cnt+1;
				}
			}
		}
		
		// 갈 수 없는 땅 보정
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1 && visited[i][j] == false) {
					map[i][j] = -1;
				}
			}
		}
		
		// 결과 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bw.write(map[i][j] +" ");
			}
			bw.write("\n");
		}
		bw.flush();

	}
	static class Node{
		int r;
		int c;
		int cnt;
		
		public Node(int r, int c, int cnt){
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

}

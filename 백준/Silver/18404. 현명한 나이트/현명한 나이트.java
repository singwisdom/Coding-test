import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = {-2,-2,-1, -1, 1, 1, 2, 2};
	static int[] dc = {-1,1,-2,2, -2, 2, -1, 1};
	static Deque<Node> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		boolean[][] isVisited = new boolean[N+1][N+1];
		int[] res = new int[M];
		
		st = new StringTokenizer(br.readLine());
		int nightX = Integer.parseInt(st.nextToken());
		int nightY = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map[r][c] = i+1;
		}
		
		// BFS 돌리기
		queue.add(new Node(nightX, nightY, 0));
		isVisited[nightX][nightY] = true;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			for (int i = 0; i < dr.length; i++) {
				int nr = n.r+dr[i];
				int nc = n.c+dc[i];
				
				if(nr>=1 && nr<N+1 && nc>=1 && nc<N+1 && !isVisited[nr][nc]) {
					queue.add(new Node(nr, nc, n.cnt+1));
					isVisited[nr][nc] = true;
					if(map[nr][nc]!=0) {
						res[map[nr][nc]-1] = n.cnt+1;
					}
				}
			}
		}
		
		// 답 출력
		for (int i = 0; i < res.length; i++) {
			bw.write(res[i]+" ");
		}
		bw.flush();
	}
	
	static class Node{
		int r;
		int c;
		int cnt;
		
		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

}
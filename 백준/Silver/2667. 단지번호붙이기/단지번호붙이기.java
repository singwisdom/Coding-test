import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		int total = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		// BFS 돌리기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					total +=1;
					int cnt = 1;
					Deque<Node> queue = new ArrayDeque<>();
					queue.add(new Node(i, j));
					visited[i][j] = true;
					
					while(!queue.isEmpty()) {
						Node n = queue.poll();
						for (int k = 0; k < dr.length; k++) {
							int nr = n.r+dr[k];
							int nc = n.c+dc[k];
							
							if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && map[nr][nc]==1) {
								queue.add(new Node(nr, nc));
								visited[nr][nc] = true;
								cnt+=1;
							}
						}
					}
					pq.add(cnt);
				}
			}
		}
		
		// 정답 출력
		bw.write(total+"\n");
		while(!pq.isEmpty()) {
			bw.write(pq.poll()+"\n");
		}
		bw.flush();

	}
	
	static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
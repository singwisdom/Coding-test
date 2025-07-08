import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int res = Integer.MIN_VALUE;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		
		// 배열 입력받기
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// BFS
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 'L') {
					Deque<Node> queue = new ArrayDeque<>();
					boolean[][] visited = new boolean[N][M];
					queue.add(new Node(i,j,0));
					visited[i][j] = true;
					
					while(!queue.isEmpty()) {
						Node n = queue.poll();
						for (int k = 0; k < dr.length; k++) {
							int nr = n.r+dr[k];
							int nc = n.c+dc[k];
							
							if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] && map[nr][nc]=='L') {
								queue.add(new Node(nr, nc, n.cnt+1));
								visited[nr][nc] = true;
								res = Math.max(res, n.cnt+1);
							}
						}
					}
				}
			}
		}
		
		bw.write(res+"\n");
		bw.flush();
	}
	static class Node{
		int r, c, cnt;
		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

}
import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		boolean[][] visited = new boolean[N][N];
		int[] cnt = new int[2];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// 적록색약 아닌 사람
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					cnt[0]+=1;
					Deque<Node> queue = new ArrayDeque<>();
					queue.add(new Node(i,j, map[i][j]));
					visited[i][j] = true;
					
					while(!queue.isEmpty()) {
						Node n = queue.poll();
						for (int k = 0; k < dr.length; k++) {
							int nr = n.r+dr[k];
							int nc = n.c+dc[k];
							
							if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && n.str == map[nr][nc]) {
								queue.add(new Node(nr, nc, map[nr][nc]));
								visited[nr][nc] = true;
							}
						}
					}
				}
			}
		}
		
		
		// 적록색약인사람
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					cnt[1]+=1;
					Deque<Node> queue = new ArrayDeque<>();
					queue.add(new Node(i, j, map[i][j]));
					visited[i][j] = true;
					
					while(!queue.isEmpty()) {
						Node n = queue.poll();
						for (int k = 0; k < dr.length; k++) {
							int nr = n.r+dr[k];
							int nc = n.c+dc[k];
							
							if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]) {
								if((n.str == 'R' || n.str =='G') && (map[nr][nc] =='R' || map[nr][nc] =='G')) {
									queue.add(new Node(nr, nc, map[nr][nc]));
									visited[nr][nc] = true;
								}
								else if(n.str =='B' && map[nr][nc] =='B') {
									queue.add(new Node(nr, nc, map[nr][nc]));
									visited[nr][nc] = true;
								}
							}
						}
					}
				}
			}
		}
		
		bw.write(cnt[0] +" " +cnt[1]+"\n");
		bw.flush();

	}
	static class Node{
		int r;
		int c;
		char str;
		public Node(int r, int c, char str) {
			this.r = r;
			this.c = c;
			this.str = str;
		}
	}
}

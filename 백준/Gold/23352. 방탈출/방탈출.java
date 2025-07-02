import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int length = Integer.MIN_VALUE;
		int[] password = new int[2];
		password[1] = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// BFS 완탐
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] !=0) {
					boolean[][] visited = new boolean[N][M];
					Deque<Node> queue = new ArrayDeque<>();
					queue.add(new Node(i, j, 0));
					visited[i][j] = true;
					
					while(!queue.isEmpty()) {
						Node n = queue.poll();
						for (int k = 0; k < dr.length; k++) {
							int nr = n.r+dr[k];
							int nc = n.c+dc[k];
							
							if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] && map[nr][nc]!=0) {
								queue.add(new Node(nr, nc, n.cnt+1));
								visited[nr][nc] = true;
								
								if(length <= n.cnt+1) {
									length = n.cnt+1;
									//bw.write("length : " + length+"\n");
									
									if(password[0] < length) {
										password[1] = map[i][j] + map[nr][nc];
										password[0] = length;
									}
									
									else if(password[0] == length && password[1] <= map[i][j] + map[nr][nc]) {
										password[1] = map[i][j] + map[nr][nc];
									}
									//bw.write("password : " + map[i][j]+", "+map[nr][nc]+"\n");
								}
							}
						}
					}
					
				}
			}
		}
		
		if(password[1] == Integer.MIN_VALUE) bw.write("0\n");
		else bw.write(password[1]+"\n");
		
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
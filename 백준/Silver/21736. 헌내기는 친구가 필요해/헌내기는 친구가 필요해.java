import java.io.*;
import java.util.*;

public class Main {
	
	static int res;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int nx = 0, ny = 0;
		char[][] map = new char[N][M];
		boolean[][] isVisited = new boolean[N][M];
		
		// 배열 입력받기
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j]=='I') {
					nx = i;
					ny = j;
				}
			}
		}
		
		// BFS 돌리기
		Deque<Node> queue = new ArrayDeque<>();
		queue.add(new Node(nx,ny));
		isVisited[nx][ny] = true;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M && !isVisited[nr][nc] && map[nr][nc]!='X') {
					if(map[nr][nc]=='P') {
						queue.add(new Node(nr, nc));
						res +=1;
					}
					else {
						queue.add(new Node(nr, nc));
					}
					isVisited[nr][nc] = true;
						
				}
			}
		}
		
		// 결과 구하기
		if(res > 0) bw.write(res+"\n");
		else bw.write("TT\n");
		bw.flush();
	}
	
	static class Node {
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
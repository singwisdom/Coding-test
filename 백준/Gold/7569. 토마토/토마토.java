import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = {0,0,1,-1,0,0};
	static int[] dc = {1,-1,0,0,0,0};
	static int[] dh = {0,0,0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int startR = -1;
		int startC = -1;
		int startH = -1;
		
		boolean isAllTomato = true;
		
		int[][][] map = new int[H][N][M];
		boolean[][][] visited = new boolean[H][N][M];
		Queue<Node> queue = new ArrayDeque<>();
		
		// 배열 입력받기 
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[h][i][j] = Integer.parseInt(st.nextToken());
					if(map[h][i][j] == 1) {
						queue.add(new Node(h, i, j, 0));
						visited[h][i][j] = true;
						if(startR ==-1 && startC ==-1 && startH ==-1) {
							startH = h;
							startR = i;
							startC = j;
						}
					}
					
					if(map[h][i][j]==0) {
						isAllTomato = false;
					}
				}
			}
		}
		
		
		
		// BFS 돌리기
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			for (int i = 0; i < dr.length; i++) {
				int nr = n.r+dr[i];
				int nc = n.c+dc[i];
				int nh = n.h+dh[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M && nh>=0 && nh<H && !visited[nh][nr][nc]) {
					if(map[nh][nr][nc]==0) {
						map[nh][nr][nc] = n.cnt+1;
						visited[nh][nr][nc] = true;
						queue.add(new Node(nh, nr, nc, n.cnt+1));
					}
				}
			}
		}
		
		// 토마토 익은거 계산하기
		int day = Integer.MIN_VALUE;
		boolean isEnd = false;
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[h][i][j]==0) {
						isEnd = true;
					}else {
						day = Math.max(day, map[h][i][j]);
					}

				}

			}

		}
		
		if(isAllTomato) bw.write("0\n");
		else if(isEnd) bw.write("-1\n");
		else bw.write(day+"\n");
		bw.flush();

	}
	
	static class Node{
		int r, c, h, cnt;
		public Node(int h, int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.h = h;
			this.cnt = cnt;
		}
	}

}

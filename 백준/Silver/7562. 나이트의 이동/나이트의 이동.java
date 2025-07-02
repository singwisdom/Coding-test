import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = {-2,-2,-1, -1, 1, 1, 2, 2};
	static int[] dc = {-1,1,-2,2, -2, 2, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int testCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCase; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			st = new StringTokenizer(br.readLine());
			int nightX = Integer.parseInt(st.nextToken());
			int nightY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int findX = Integer.parseInt(st.nextToken());
			int findY = Integer.parseInt(st.nextToken());
			int res = Integer.MAX_VALUE;
			
			if(nightX == findX && nightY == findY) {
				bw.write("0\n");
				continue;
			}
			
			// BFS 돌리기
			Deque<Node> queue = new ArrayDeque<>();
			queue.add(new Node(nightX, nightY, 0));
			visited[nightX][nightY] = true;
			
			while(!queue.isEmpty()) {
				Node n = queue.poll();
				
				for (int j = 0; j < dr.length; j++) {
					int nr = n.r+dr[j];
					int nc = n.c+dc[j];
					
					if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]) {
						if(nr==findX && nc==findY) {
							res = Math.min(res, n.cnt+1);
						}
						queue.add(new Node(nr, nc, n.cnt+1));
						visited[nr][nc] = true;
					}
				}
			}
			bw.write(res+"\n");
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
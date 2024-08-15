import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static boolean[][][] visit;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	static int n,m;
	static boolean isEnd = false;
	
	static class Node{
		int x;
		int y;
		int dist;
		int boom;
		
		public Node(int x, int y, int dist, int boom) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.boom = boom;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		n = nm[0];
		m = nm[1];
		map = new int[nm[0]][nm[1]]; // 0 : 이동할 수 있는 곳, 1: 벽
		visit = new boolean [nm[0]][nm[1]][2];
		
		// 배열 집어 넣기
		for (int i = 0; i < nm[0]; i++) {
			map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		
		bfs(); // bfs로 탐색
		
		if(!isEnd) System.out.println(-1);
	}
	
	private static void bfs() {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(0,0,1,0));
		visit[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.x;
			int y = node.y;
			
			if(x==n-1 && y==m-1) {
				System.out.println(node.dist);
				isEnd = true;
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x+dr[i];
				int ny = y+dc[i];
				
				if(nx >=0 && nx<n && ny>=0 && ny<m) {
					if(map[nx][ny] == 0 && !visit[nx][ny][node.boom]) { // 벽이 아니면
						visit[nx][ny][node.boom] = true;
						queue.add(new Node(nx,ny,node.dist+1,node.boom));
					}
					else { // 벽이라면
						// 벽을 부순적이 없다면 부수기
						if(node.boom==0 && !visit[nx][ny][node.boom]) {
							visit[nx][ny][node.boom+1] = true;
							queue.add(new Node(nx,ny,node.dist+1, node.boom+1)); // 벽 부쉈다고 표시하기
						}
					}

				}
			}
			
		}
		
	}

}

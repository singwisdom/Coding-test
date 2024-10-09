import java.io.*;
import java.util.*;

public class Main {

	static int N,M,T;
	static int[][] map, mapClone;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static int[] up,down;
	
	static class Node{
		int r,c;
		int dust;
		public Node(int r, int c, int dust) {
			super();
			this.r = r;
			this.c = c;
			this.dust = dust;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //행
		M = Integer.parseInt(st.nextToken()); //열
		T = Integer.parseInt(st.nextToken()); //T초 
		map = new int[N][M];
		mapClone = new int[N][M];
		up = new int[2];
		down = new int[2];
		int res =  0;
		
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		findCleaner(); // 공기 청정기 위치 구하기
		
		for (int t = 0; t < T; t++) {
			
			bfs(); // step1) 미세먼지 확산
			clean(); // step2) 공기청정기 작동
			
		}

		// 남아있는 미세먼지 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]!=-1) res += map[i][j];
			}
		}
		
		bw.write(res+"\n");
		bw.flush();

	}
	
	private static void clean() {
		
		for (int i = 0; i < N; i++) {
			mapClone[i] = map[i].clone(); // 맵 복사
		}
		
		// 위쪽 확산
		int r = up[0];
		int c = up[1] +1;
		int[] dirX = {0,-1,0,1};
		int[] dirY = {1,0,-1,0};
		int idx = 0;
		
		map[r][c] = 0;
		while(idx<4) {
			if((r==0&&c==0) || (r==0&&c==M-1) || (r==up[0] && c==M-1)) idx++;
			//System.out.println(r+" "+c);
			if(map[r+dirX[idx]][c+dirY[idx]]!=-1) {
				map[r+dirX[idx]][c+dirY[idx]] = mapClone[r][c]; 
			}
			r = r+dirX[idx]; // r,c값 업데이트
			c = c+dirY[idx];
			if(map[r][c]==-1) break;
		}
		
		// 아래쪽 확산
		r = down[0];
		c = down[1]+1;
		dirX = new int[]{0,1,0,-1};
		dirY = new int[]{1,0,-1,0};
		idx = 0;
		map[r][c] = 0;
		while(idx<4) {
			if((r==down[0] && c==M-1) || (r==N-1 &&c==M-1) ||(r==N-1 && c==0)) idx++;
			if(map[r+dirX[idx]][c+dirY[idx]]!=-1) {
				map[r+dirX[idx]][c+dirY[idx]] = mapClone[r][c]; 
			}
			r = r+dirX[idx]; // r,c값 업데이트
			c = c+dirY[idx];
			if(map[r][c]==-1) break;
		}
		
	}

	private static void findCleaner() {
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==-1) {
					if(cnt == 0) {
						up[0] = i;
						up[1] = j;
						cnt++;
					} else {
						down[0] = i;
						down[1] = j;
					}
				}
			}
		}
		
	}

	private static void bfs() {
		Queue<Node> queue = new ArrayDeque<>();
		Queue<Node> queueSave = new ArrayDeque<>();
		
		// 미세먼지가 있는 노드를 큐에 넣기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] != 0) {
					queue.add(new Node(i,j,map[i][j]));
				}
			}
		}
		
		// 큐를 돌리면서 확산 시키기 !
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			int cnt = 0;
			for (int i = 0; i < dr.length; i++) {
				int nr = n.r+dr[i];
				int nc = n.c+dc[i];
	
				if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]!=-1) {
					queueSave.add(new Node(nr,nc, map[n.r][n.c]/5));
					cnt++;
				}
			}
			map[n.r][n.c] = map[n.r][n.c] - (map[n.r][n.c]/5) * cnt;
		}
		
		// map 업데이트 하기 (확산되는 먼지 양 더해주기)
		while(!queueSave.isEmpty()) {
			Node n = queueSave.poll();
			map[n.r][n.c] += n.dust;
		}
		
	}

}

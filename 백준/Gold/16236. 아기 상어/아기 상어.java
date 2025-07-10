import java.io.*;
import java.util.*;
public class Main {

	static int[][] map, tmpMap;
	static int N, fishCount, sharkX, sharkY, totalTime, sharkSize, sharkTmp;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static int[] fish = new int[7];
 	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		sharkSize = 2;
		
		// 배열 입력받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					sharkX = i;
					sharkY = j;
				} else if(map[i][j]!=0 && map[i][j]!=9) {
					fishCount +=1;
					fish[map[i][j]] +=1;
				}
			}
		}
		
		// 시뮬레이션 돌리기
		while(true) {
			
			// 1단계 : 먹을 수 있는 물고기 개수 세기 (자신의 크기보다 작아야 함)
			int count = 0;			
			for (int i = 1; i <= 6; i++) {
				if(fish[i]>0 && i < sharkSize) {
					count+=fish[i];
				}
			}
			//System.out.println("물고기 수 : "+count+", "+fishCount);
			//System.out.println("현재 상어 사이즈 : "+sharkSize);
			
			// 먹을 수 있는 물고기가 많다면 가까운 물고기 세기
			if(count > 1) {
				//System.out.println("먹을 수 있는 물고기 여러마리 : "+count);
				
				// BFS 돌려서 가까운 물고기 세기
				int nearDistance = bfs(); // 가까운 물고기 거리
				//System.out.println("가까운 물고기 거리 : "+nearDistance);
				if(nearDistance == Integer.MAX_VALUE) {
					count = 0;
					break; // 물고기 위치로 갈 수 없으면 엄마 요청
				}
				int nearFish = 0; // 가까운 물고기 개수
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(nearDistance == tmpMap[i][j]) nearFish +=1;
					}
				}
				
				
				// 가까운 물고기 1개면 걔 바로 먹기 
				if(nearFish == 1) {
					//System.out.println("가까운 물고기 1개입니다");
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < N; j++) {
							if(nearDistance == tmpMap[i][j]) {
								//System.out.println("물고기 발견, 해당 위치로 갑니다 : "+i+", "+j);
								totalTime += nearDistance; // 시간 업데이트
								//System.out.println("시간 업 !! : "+totalTime);
								sharkTmp+=1;
								fishCount -=1; // 물고기 개수 감소
								fish[map[i][j]] -=1; // 물고기 개수 업데이트
								if(sharkTmp == sharkSize) {
									sharkSize +=1;
									sharkTmp = 0;
								}
								map[i][j] = 0;
								map[sharkX][sharkY] = 0;
								sharkX = i;
								sharkY = j;
								map[sharkX][sharkY] = 9;
							}
						}
					}
				}
				
				// 가까운 물고기 2개 이상이라면 맨 위에 있는 물고기 먹기 , 맨 위에 있는 물고기 2개 이상이라면 맨 왼쪽 물고기 먹자
				else if(nearFish >=2) {
					//System.out.println("가까운 물고기가 "+nearFish+"개입니다");
					List<Node> list = new ArrayList<>();
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < N; j++) {
							if(nearDistance == tmpMap[i][j]) {
								list.add(new Node(i,j,tmpMap[i][j]));
							}
						}
					}
					
					// 리스트 정렬해서 첫번째 인덱스 물고기 먹기
					list.sort((a,b) -> {
						if(a.r == b.r) return Integer.compare(a.c, b.c); // 맨 위가 같다면 맨 왼쪽
						return Integer.compare(a.r, b.r); // 맨 위 기준으로 정렬
					});
					
					// 물고기 먹기 
					Node n = list.get(0);
					//System.out.println("물고기 발견, 해당 위치로 갑니다 : "+n.r+", "+n.c);
					totalTime+= nearDistance; // 시간 업데이트
					//System.out.println("시간 업 !! : "+totalTime);
					sharkTmp+=1;
					fishCount -=1; // 물고기 개수 감소
					fish[map[n.r][n.c]] -=1; // 물고기 개수 업데이트
					if(sharkTmp == sharkSize) {
						sharkSize +=1;
						sharkTmp = 0;
					}
					map[n.r][n.c] = 0;
					map[sharkX][sharkY] = 0;
					sharkX = n.r;
					sharkY = n.c;
					map[sharkX][sharkY] = 9;
				}
				
			}
			
			// 먹을 수 있는 물고기 1마리면 걔 먹으러 가야지
			else if(count ==1) {
				//System.out.println("먹을 수 있는 물고기 1마리");
				Deque<Node> queue = new ArrayDeque<>();
				boolean[][] visited = new boolean[N][N];
				boolean isFound = false;
				queue.add(new Node(sharkX, sharkY, 0));
				visited[sharkX][sharkY] = true;
				
				while(!queue.isEmpty()) {
					if(isFound) break;
					Node n = queue.poll();
					for (int i = 0; i < dr.length; i++) {
						if(isFound) break;
						int nr = n.r+dr[i];
						int nc = n.c+dc[i];

						if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && map[nr][nc] <= sharkSize) {
							queue.add(new Node(nr, nc, n.cnt+1));
							visited[nr][nc] = true;
							
							// 물고기 발견
							if(map[nr][nc] < sharkSize && map[nr][nc]!=0) {
								//System.out.println("물고기 발견, 해당 위치로 갑니다 ! : "+nr+", "+nc);
								totalTime += n.cnt+1;
								//System.out.println("시간 업 !! : "+totalTime);
								isFound = true;
								sharkTmp+=1;
								fishCount -=1;
								fish[map[nr][nc]] -=1;
								if(sharkTmp == sharkSize) {
									
									sharkSize +=1;
									//System.out.println("상어 크기 증가 : "+sharkSize);
									sharkTmp = 0;
								}
								map[nr][nc] = 0;
								map[sharkX][sharkY] = 0;
								sharkX = nr;
								sharkY = nc;
								map[sharkX][sharkY] = 9;
							}
						}
					}
				}
				// 물고기 위치로 갈 수 없으면 엄마 요청
				if(!isFound) {
					break;
				}
				
			}
			
			else if(count == 0 || fishCount == 0) {
				break;
			}
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
			
		}
		bw.write(totalTime+"\n");
		bw.flush();
		
	}
 	
 	private static int bfs() {
 		int near = Integer.MAX_VALUE;
 		Deque<Node> queue = new ArrayDeque<>();
 		tmpMap = new int[N][N];
 		boolean[][] visited = new boolean[N][N];
 		queue.add(new Node(sharkX, sharkY, 0));
 		visited[sharkX][sharkY] = true;
 		
 		while(!queue.isEmpty()) {
 			Node n = queue.poll();
 			for (int i = 0; i < dr.length; i++) {
				int nr = n.r+dr[i];
				int nc = n.c+dc[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && map[nr][nc] <= sharkSize) {
					queue.add(new Node(nr, nc, n.cnt+1));
					visited[nr][nc] = true;
					
					// 물고기 발견 (거리를 업데이트 해주는거임)
					if(map[nr][nc] < sharkSize && map[nr][nc]!=0) {
						tmpMap[nr][nc] = n.cnt+1;
						near = Math.min(near, tmpMap[nr][nc]);
					}
				}
			}
 		}
 		
 		return near;
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

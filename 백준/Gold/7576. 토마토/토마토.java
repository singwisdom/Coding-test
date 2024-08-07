import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static Deque<int[]> queue = new ArrayDeque();
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,1,-1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        map = new int[nm[1]][nm[0]];
        int tomato = 0; // 안 익은 토마토 개수 세기
        
        for (int i = 0; i < nm[1]; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < nm[0]; j++) {
                map[i][j] = tmp[j];
                if(map[i][j]==1) queue.add(new int[] {i,j});
                else tomato+=1;
            }
        }
        if(tomato==0) System.out.println(0);
        else {
        	bfs(); // 시작점은 익은 토마토가 있는 곳, 배열로 넘겨주기
        	tomato=0;
        	int max = Integer.MIN_VALUE;
        	// 토마토가 다 익었는지 확인, 다 익었다면 며칠 걸렸는지 구하기
        	for (int i = 0; i < nm[1]; i++) {
				for (int j = 0; j < nm[0]; j++) {
					if(map[i][j]==0) tomato+=1;
					max = Math.max(max, map[i][j]);
				}
			}
        	
        	if(tomato>0) System.out.println(-1);
        	else System.out.println(max-1); // 2가 1일차라서 -1해주기
        }
    }

    // 1: 익은토마토, 0: 익지 않은 토마토, -1: 토마토 없음
    private static void bfs() {
        int r=0, c=0, nr=0, nc=0;
        
        while(!queue.isEmpty()) {
        	int[] arr = queue.poll();
        	r = arr[0];
        	c = arr[1];
        	
        	for (int i = 0; i < 4; i++) { // 4방으로 돌면서 토마토 익히기
        		nr = r+dr[i];
        		nc = c+dc[i];
				if(nr>=0 && nr<map.length && nc>=0 && nc<map[0].length) {
					if(map[nr][nc] ==0) {
						map[nr][nc] = map[r][c]+1; // 안 익은 토마토라면 익었다고 표시해주기
						queue.add(new int[] {nr,nc}); // 다음 탐색할 노드 집어넣기
					}
				}
			}
        	
//        	for (int i = 0; i < map.length; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
        }
    }
}
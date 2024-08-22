import java.io.*;
import java.util.*;

/*
 * 처음에 틀린 이유 : BFS를 돌릴때 처음 인자값을 0,0으로 주었음.. 그래서 0,0이 바이러스가 퍼질 수 있는 곳인데도 처음에 무조건 방문배열을 true로 하니까 답이 다르게 나왔당
 */
public class Main {

    static int[][] wall, map, origin;
    static int[][] sel = new int[3][2];
    static boolean[][] visit;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,1,-1};
    static int max = Integer.MIN_VALUE; // 안전구역 최대 개수 
    static int N,M,cnt,cnt2;
    static Queue<Node> queue = new ArrayDeque();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // N크기
        M = Integer.parseInt(st.nextToken()); // M크기
        map = new int[N][M]; // map 선언
        origin = new int[N][M];
        visit = new boolean[N][M]; // 방문배열
        
        cnt = cnt2 =0; // 벽을 세울 수 있는 개수
        
        // 배열 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                origin[i][j] = map[i][j];
                if(map[i][j]==0) cnt+=1; // 벽이 아닌 곳 카운트
            }
        }
        
        // 벽을 세울 수 있는 곳 wall 배열에 저장하기
        wall = new int[cnt][2];
        int tmp = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==0) {
                    wall[tmp][0] = i;
                    wall[tmp][1] = j;
                    tmp+=1;
                }
            }
        }
        
        // 조합 구하기 nC3 (여기서 n은 cnt)
        permutation(0,0);
        System.out.println(max);

    }
    
    // idx : 원본배열의 순서값, k : 선택한 갯수
    private static void permutation(int idx, int k) {
    	
        if(k==sel.length) {
        	
        	// 출력
//            for (int i = 0; i < sel.length; i++) {
//                System.out.println(Arrays.toString(sel[i]));
//            }
                  
            // 배열 바꾸기
            for (int i = 0; i < sel.length; i++) {
                map[sel[i][0]][sel[i][1]] = 1;
            }
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 2)  queue.offer(new Node(i,j)); // 바이러스가 있는 곳 큐에 담기 
                    
                }
            }
            
            bfs(); // bfs 진행
            
            max = Math.max(max, (cnt-3-cnt2));
            // ==> 이거 cnt가 0의 개수, cnt2가 원래 바이러스의 개수니까 (cnt -3- bfs에서 offer)한 횟수 이런식으로 배열 안돌고 0인 구역 구할 수 있을듯

            
            //배열 원상복구, 방문 배열 초기화하기
            for (int i = 0; i < N; i++) {
            	map[i] = origin[i].clone();
                Arrays.fill(visit[i], false);
            }
            
            cnt2=0; // cnt초기화
            return;
        }
        
        if(idx==wall.length) return;
        
        sel[k] = wall[idx];
        permutation(idx+1, k+1); // 선택하는 경우
        permutation(idx+1, k); // 선택하지 않는 경우
        
    }

    private static void bfs() {
        
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nr = n.r+dr[k];
                int nc = n.c+dc[k];
                
                if(nr>=0 && nr<N && nc>=0 && nc<M) {
                    if(!visit[nr][nc] && map[nr][nc]==0) { // 바이러스가 퍼질 수 있는 곳이면 큐에 넣기
                        queue.offer(new Node(nr,nc));
                        visit[nr][nc] = true;
                        map[nr][nc] = 2;
                        cnt2+=1;
                    }
                }
            }
            
        }
        
    }
    
    static class Node{
        int r;
        int c;
        public Node(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }
    }

}
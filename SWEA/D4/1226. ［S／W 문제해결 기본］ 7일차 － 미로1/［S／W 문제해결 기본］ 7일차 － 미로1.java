import java.io.*;
import java.util.*;

public class Solution {

	static int[][] map;
	static int startX, startY;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	static boolean [][] visit;
	
	static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for (int tc = 1; tc <=10; tc++) {
			map = new int[16][16];
			visit = new boolean[16][16];
			int k = Integer.parseInt(br.readLine()); // TC 번호
			
			for (int i = 0; i < 16; i++) {
                String line = br.readLine();
                for (int j = 0; j < 16; j++) {
                    map[i][j] = line.charAt(j) - '0'; // 문자에서 숫자로 변환

                    if (map[i][j] == 2) {
                        startX = i;
                        startY = j;
                    }
                }
            }
			int res = bfs();
			bw.write("#"+tc+" "+res+"\n");
			
		}
		bw.flush();
		bw.close();
		br.close();

	}


	private static int bfs() {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(startX, startY));
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			visit[n.r][n.c] = true;
			map[n.r][n.c] = 4;
			
			for (int i = 0; i < dc.length; i++) {
				int nr = n.r+dr[i];
				int nc = n.c+dc[i];
				if(nr>=0&&nr<16&&nc>=0&&nc<16&&!visit[nr][nc]&&map[nr][nc]!=1) {
					if(map[nr][nc]==3) return 1;
					else {
						queue.offer(new Node(nr,nc));
						visit[nr][nc] = true;
						map[nr][nc] = 4;
					}
				}
			}
		}
		
		return 0;
	}

}

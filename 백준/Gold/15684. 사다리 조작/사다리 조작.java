import java.util.*;
import java.io.*;

public class Main {

	static int N,M,H, res;
	static int[][] map;
	static boolean isOkay = false;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로선의 개수
		M = Integer.parseInt(st.nextToken()); // 가로선의 개수
		H = Integer.parseInt(st.nextToken()); // 가로선을 놓을 수 있는 위치의 개수
		map = new int[H+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1; // 1이면 오른쪽으로 이동
			map[a][b+1] = 2; // 2면 왼쪽으로 이동
		}
	

		for (int count = 0; count<=3; count++) {
			res = count;
			dfs(1,0); // 백트래킹 하기
			if(isOkay) break;
		}
	
		if(isOkay) bw.write(res+"\n");
		else bw.write("-1\n");
		bw.close();

	}
	
	private static void dfs(int r, int ladderLine) {
		if(isOkay) return;
		
		if(res == ladderLine) {
			if(downLadder()) isOkay = true;
			return;
		}
		
		// 추가할 수 있는 사다리의 개수를 추가하면서 백트래킹
		for (int i = r; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if(map[i][j] == 0 && map[i][j+1] ==0) {
					map[i][j] = 1;
					map[i][j+1] = 2;
					
					dfs(i,ladderLine+1);
					
					// 가로선 다시 제거하기
					map[i][j] = 0;
					map[i][j+1] = 0;
				}
			}
		}
		
	}

	// 사다리 타는 함수
	private static boolean downLadder() {		
		for (int i = 1; i <= N; i++) {
			int nx = 1, ny = i;
			for (int j = 0; j < H; j++) {
				if(map[nx][ny] == 1) ny++;
				else if(map[nx][ny]==2) ny--;
				nx++;
			}
			
			if(i!=ny) return false;
		}
		return true;
	}

}

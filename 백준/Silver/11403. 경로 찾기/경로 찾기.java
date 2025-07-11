import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] list = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 1) {
					list[i].add(j);
				}
			}
		}
		
		// BFS 돌리기
		int[][] res = new int[N][N];
		for (int i = 0; i < N; i++) {
			Deque<Integer> queue = new ArrayDeque<>();
			boolean[] visited = new boolean[N];
			queue.add(i);
			
			while(!queue.isEmpty()) {
				Integer num = queue.poll();
				for (int j = 0; j < list[num].size(); j++) {
					if(!visited[list[num].get(j)]) {
						queue.add(list[num].get(j));
						visited[list[num].get(j)] = true;
						res[i][list[num].get(j)] = 1;
					}
				}
			}
		}
		
		// 결과 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < res.length; j++) {
				bw.write(res[i][j]+" ");
			}
			bw.write("\n");
		}
		
		bw.flush();
	}

}
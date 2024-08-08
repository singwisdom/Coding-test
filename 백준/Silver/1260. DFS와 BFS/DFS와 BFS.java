import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] node;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		
		// n: 정점의 개수, m: 간선의 개수, v:탐색 시작 번호
		int[] nmv = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		node = new int[nmv[0]+1][nmv[0]+1];
		visit = new boolean[nmv[0]+1];
		
		for (int i = 0; i < nmv[1]; i++) {
			int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			node[tmp[0]][tmp[1]] = node[tmp[1]][tmp[0]] = 1; 
		}
		
		dfs(nmv[2]);
		Arrays.fill(visit, false);
		System.out.println();
		bfs(nmv[2]);

	}

	private static void dfs(int num) {
		// DFS는 스택을 사용
		visit[num] = true; // 방문했다고 표시
		System.out.print(num+" ");
		
		for (int i = 1; i < node.length; i++) {
			if(node[num][i] ==1 && !visit[i]) {
				dfs(i);
			}
		}
	}

	private static void bfs(int num) {
		// BFS는 큐를 사용
		Queue<Integer> q  = new ArrayDeque();
		q.add(num); // 해당 정점 번호를 넣어준다
		visit[num] = true; // 방문했다고 표시
		System.out.print(num+" ");
		
		while(!q.isEmpty()) {
			int idx = q.poll();
			for (int i = 1; i < node.length; i++) {
				if(node[idx][i] == 1 && !visit[i]) {
					q.add(i);
					visit[i] = true;
					System.out.print(i+" ");
				}
			}
		}
		
	}

}

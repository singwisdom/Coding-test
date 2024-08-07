import java.util.*;
import java.io.*;

public class Main {
	static Deque<Integer> deque = new ArrayDeque<>();
	static boolean[] visit;
	static int[][] computer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		computer = new int[num+1][num+1];
		visit = new boolean[num+1];
		
		for (int i = 0; i < n; i++) {
			int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			computer[tmp[0]][tmp[1]] = 1; // 연결된 바이러스 넣기
			computer[tmp[1]][tmp[0]] = 1;
		}
		
		System.out.println(bfs(1));

	}
	private static int bfs(int num) {
		deque.add(num);
		visit[num] = true; // 방문했다고 표시
		int count = 0;
		
		while(!deque.isEmpty()) {
			int idx = deque.poll();
			
			for (int i = 1; i < computer.length; i++) {
				if(computer[idx][i]==1 &&!visit[i]) {
					deque.add(i); // 큐에 넣어주기
					visit[i] = true; // 방문했다고 표시
					count+=1; // 1번에 연결된 컴퓨터 수 증가
				}
			}
		}
		return count;
		
	}

}
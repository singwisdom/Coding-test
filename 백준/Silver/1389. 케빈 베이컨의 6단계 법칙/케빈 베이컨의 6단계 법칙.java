import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 초기 입력 받기
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		
		// 연결리스트 초기화
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		// 친구 관계 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		// BFS 구현
		int[][] res = new int[N+1][2];
		for (int i = 1; i <= N; i++) {
			Deque<Node> queue = new ArrayDeque<>();
			boolean[] visited = new boolean[N+1];
			queue.add(new Node(i, 0));
			visited[i] = true;
			int cnt = 0;
			
			while(!queue.isEmpty()) {
				Node n = queue.poll();
				for (int j = 0; j < arr[n.num].size(); j++) {
					if(!visited[arr[n.num].get(j)]) {
						queue.add(new Node(arr[n.num].get(j), n.cnt+1));
						visited[arr[n.num].get(j)] = true;
						cnt += n.cnt+1;
					}
				}
			}
			res[i][0] = cnt;
			res[i][1] = i;
		}
		
		// 정답 출력
		Arrays.sort(res, (a,b)-> {
			if(a[0]!=b[0]) return Integer.compare(a[0], b[0]);
			else return Integer.compare(a[1], b[1]);
		});
		bw.write(res[1][1]+"\n");
		bw.flush();

	}
	static class Node{
		int num;
		int cnt;
		public Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}

}
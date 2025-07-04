import java.io.*;
import java.util.*;

public class Main {

	static int count = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ladder = Integer.parseInt(st.nextToken());
		int snake = Integer.parseInt(st.nextToken());
		int[] map = new int[101];
		boolean[] visited = new boolean[101];
		
		for (int i = 0; i < (ladder + snake); i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			int destination = Integer.parseInt(st.nextToken());
			map[index] = destination;
		}
		
		Deque<Node> queue = new ArrayDeque<>();
		queue.add(new Node(1, 0));
		visited[1] = true;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			for (int i = 1; i <=6; i++) {
				int nr = n.idx + i;
				if(nr<=100 && !visited[nr]) {
					if(map[nr]!=0) {
						queue.add(new Node(map[nr], n.cnt+1));
						visited[map[nr]] = true;
					}else {
						queue.add(new Node(nr, n.cnt+1));
					}
					visited[nr] = true;
					
					if(nr == 100) {
						count = Math.min(count, n.cnt+1);
					}
				}
			}
		}
		
		bw.write(count+"\n");
		bw.flush();
	}
	static class Node{
		int idx;
		int cnt;
		public Node(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}

}
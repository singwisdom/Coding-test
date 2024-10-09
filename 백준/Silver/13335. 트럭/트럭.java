import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 트럭의 수
		int w = Integer.parseInt(st.nextToken()); // 다리의 길이
		int l = Integer.parseInt(st.nextToken()); // 최대 하중
		Queue<Integer> truck = new ArrayDeque(); // 트럭 배열
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			truck.add(Integer.parseInt(st.nextToken()));
		}
		
		Queue<Integer> bridge = new ArrayDeque();
		for (int i = 0; i < w; i++) {
			bridge.add(0);
		}
		
		// Main logic
		int time = 0;
		int weightBridge = 0;
		
		while(!bridge.isEmpty()) {
			time++;
			weightBridge -= bridge.poll();
			
			if(truck.isEmpty()) continue; // 트럭이 비어있으면 건너뛰기
			
			// 만약 다리 위를 지나갈 수 있으면
			if(truck.peek() + weightBridge <= l) { 
				int tmp = truck.poll(); // 트럭 큐에서 꺼내서 다리위에 놓고, 다리 무게 갱신
				weightBridge += tmp;
				bridge.add(tmp);
			} else {
				bridge.add(0); // 지나갈 수 없으면 0 삽입
			}
		}
		System.out.println(time); // 정답 출력
	}

}
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Deque<Integer> deque = new ArrayDeque();
		int num = Integer.parseInt(br.readLine());
		for (int i = 1; i <= num; i++) {
			deque.add(i); // 원소 집어넣기
		}
		
		while(deque.size()>1) {
			
			deque.pollFirst(); // 제일 위 카드 버리기
			if(deque.size()==1) break; // 버리고 1개가 남았을경우, break
			
			int tmp = deque.pollFirst(); // 위 카드 버리고, 아래로 옮기기
			deque.add(tmp);
		}
		System.out.println(deque.peekFirst()); // 하나남은 카드 출력
		
	}
}

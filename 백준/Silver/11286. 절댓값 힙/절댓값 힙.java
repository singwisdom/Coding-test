import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		PriorityQueue<Integer> queue2 = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num!=0) {
				if(num<0) queue2.add(num);
				else queue.add(num);
			}
			
			if(num==0) {
				
				if(queue.size()==0 && queue2.size()==0) bw.write("0\n");
				else if(queue.size()==0 && queue2.size() > 0) {
					bw.write(queue2.poll()+"\n");
				}
				else if(queue.size() > 0 && queue2.size() ==0 ) {
					bw.write(queue.poll()+"\n");
				}
				else {
					int tmp = queue.peek();
					int tmp2 = queue2.peek();
					
					if(Math.abs(tmp) < Math.abs(tmp2)) {
						bw.write(queue.poll()+"\n");
					} else if(Math.abs(tmp2) < Math.abs(tmp)) {
						bw.write(queue2.poll()+"\n");
					} else {
						bw.write(queue2.poll()+"\n");
					}
				}
				
			}
		}
		
		bw.flush();
	}

}
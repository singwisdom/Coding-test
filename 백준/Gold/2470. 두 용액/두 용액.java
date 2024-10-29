import java.util.*;
import java.io.*;

public class Main {

	static int N,min;
	static int[] res, map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		res = new int[2];
		min = Integer.MAX_VALUE;
		
 		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken()); // 배열 입력받기
		}
		
		run();
		Arrays.sort(res);
		bw.write(res[0]+" "+res[1]+"\n");
		bw.close();

	}

	private static void run() {
		Arrays.sort(map); // 일단 정렬
		
		int start = 0;
		int end = N-1;
		
		while(start<end) {
			int sum = map[start]+map[end];
			
			if(min > Math.abs(sum)) {
				min = Math.abs(sum);
				res[0] = map[start];
				res[1] = map[end];
			}
			
			if(sum == 0) break;
			
			if(sum < 0) start++; // 합계가 0보다 작으면 start를 늘리기
			else end --;
			
		}
		
	}

}

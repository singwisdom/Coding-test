import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 집의 개수
		int C = Integer.parseInt(st.nextToken()); // 공유기 개수
		long[] home = new long[N];
		
		for (int i = 0; i < N; i++) {
			home[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(home); // 좌표 정렬
		
		long minDist = 1;
		long maxDist = home[N-1] - home[0];
		long mid = 0;
		long result = 0;
		
		while(minDist<=maxDist) {
			mid = (minDist + maxDist) / 2;
			long count = 1;
			long tmp = home[0];
			
			for (int i = 1; i < N; i++) {
				if(home[i] >= tmp + mid) {
					count ++; // 카운트를 증가시켜주고, tmp값 갱신
					tmp = home[i]; // 공유기를 설치한 집
				}
				if(count >= C) break;
			}
			
			if(count >= C) {
				minDist = mid+1; // 거리를 넓혀야 된다면, 범위 넓히기
				result = mid;
			}else {
				maxDist = mid-1; // 거리를 더 좁혀도 된다면 범위 줄이기
			}
		}

		bw.write(result+"\n");
		bw.close();
	
	}

}
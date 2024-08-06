import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < tc; t++) {
			Map<String, Integer> costume  = new HashMap();
			int n = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < n; i++) { // 맵에 자료 집어넣기
				String[] tmp = br.readLine().split(" ");
				if(!costume.containsKey(tmp[1])) costume.put(tmp[1], 1); // 같은 종류의 옷이 없다면 초기값 넣어주기
				else {
					costume.replace(tmp[1],costume.get(tmp[1])+1); // 같은 종류의 옷이 있다면 +1 해주기
				}
			}
			
			int count = 1;
			for (int num : costume.values()) {
				count *= (num+1);
			}
			
			System.out.println(count-1); // 아예 옷을 입지 않는 경우를 빼주기
			
		}

	}

}
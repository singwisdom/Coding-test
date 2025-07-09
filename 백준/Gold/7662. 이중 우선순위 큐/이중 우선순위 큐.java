import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int TC = Integer.parseInt(st.nextToken());
		for (int testcase = 0; testcase < TC; testcase++) {
			int k = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<>();
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				String word = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				if(word.equals("I")) {
					map.put(num, map.getOrDefault(num, 0)+1);
				}else {
					if(map.size()==0) continue;
					int key = (num==1) ? map.lastKey() : map.firstKey();
					
					if (map.get(key) == 1) {
                        map.remove(key);
                    } else {
                        map.put(key, map.get(key) - 1);
                    }
					
				}
			}
			
			// 정답 출력
			if(map.size()==0) bw.write("EMPTY\n");
			else bw.write(map.lastKey()+" "+map.firstKey()+"\n");

			bw.flush();
		}

	}

}
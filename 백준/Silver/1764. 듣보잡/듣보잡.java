import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]); // 듣도 못한 사람
		int m = Integer.parseInt(nm[1]); // 보도 못한 사람
		
		Set<String> hear = new HashSet<String>();
		Set<String> see = new HashSet<String>();
		
		for(int i=0;i<n;i++) {
			String tmp = br.readLine();
			hear.add(tmp);
		}
		
		for(int i=0;i<m;i++) {
			String tmp = br.readLine();
			see.add(tmp);
		}
		
		see.retainAll(hear); // 교집합 구하기
		ArrayList<String> hear_see = new ArrayList<>(see); // list로 변환
		Collections.sort(hear_see); // 정렬하기
		
		bw.write(hear_see.size()+"\n");
		for(String buffer : hear_see) {
			bw.write(buffer+"\n");
		}
		bw.flush();
		
	}

}
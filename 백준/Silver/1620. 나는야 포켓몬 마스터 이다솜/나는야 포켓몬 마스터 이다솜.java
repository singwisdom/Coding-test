import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]); // 포켓몬 수
		int m = Integer.parseInt(nm[1]); // 맞춰야하는 문제 수
		HashMap<String, Integer> map1 = new HashMap<>(); // key: 포켓몬 이름, value: 숫자
		HashMap<Integer, String> map2 = new HashMap<>(); // key: 숫자 , value: 포켓몬 이름
		
		// 포켓몬 도감에 입력하기
		for(int i=1;i<=n;i++) {
			String name = br.readLine();
			map1.put(name,i);
			map2.put(i, name);
		}
		
		// 문제 풀기
		for(int j=0;j<m;j++) {
			String tmp = br.readLine();
			boolean is_digit = false;
			
			// 숫자가 들어왔는지 확인
			for(char x : tmp.toCharArray()) {
				if(Character.isDigit(x)) {
					is_digit = true;
					break;
				}
			}
			
			if(is_digit == false) { // 포켓몬 이름이 들어왔다면, key 찾기
				bw.write(map1.get(tmp)+"\n");
			}
			
			else if(is_digit == true) { // value로 key 찾기
				bw.write(map2.get(Integer.parseInt(tmp))+"\n");
			}
			
		}
		bw.flush();

	}

}

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // n이 동전, k가 가치의 합
		int[] money = new int[nk[0]];
		int res = 0; // 결과값
		
		for(int i=0;i<nk[0];i++) {
			money[i] = Integer.parseInt(br.readLine()); // money 배열에 입력받기
		}
		
		for(int j=money.length-1;j>=0;j--) {
			if(nk[1] / money[j] >=1) { // 나눌 수 있다면 나머지값으로 업데이트해주기
				res += (nk[1] / money[j]);
				nk[1] %= money[j]; 
			}
		}
		
		bw.write(res+"\n");
		bw.flush();
	}
}
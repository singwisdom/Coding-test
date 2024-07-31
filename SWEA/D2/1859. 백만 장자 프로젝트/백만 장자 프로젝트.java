import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] day = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int max = day[n-1];
			long cnt = 0l, sum = 0l, res = 0l;
			// 뒤에서 부터 접근하면서 최대값을 갱신해준다, 최대값보다 더 큰 값을 만났을 경우, 그동안 사들인 물건을 다 팔고 이윤을 남겨야 함
			
			for (int i = n-1; i>=0; i--) {
				if(max > day[i]) { // 현재 판매값이 최고가보다 작다면, 사들인다.
					sum += day[i];
					cnt++;
				}
				else { // 현재 판매값이 최고가보다 더 크다면, 그동안 사들인거를 팔아야 함
					res += (max*cnt)- sum;
					max = day[i];
					sum = 0; // 초기화 해주기
					cnt = 0;
				}
			}
			res += (max*cnt)-sum;
			bw.write("#"+t+" "+res+"\n");
			
		}
		bw.flush();
	}

}
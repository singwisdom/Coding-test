import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] num;
	static Integer[] prime;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		num = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			num[i] = i; // 배열 채우기
		}
		
		int res = 0;

		if (N >= 2) {
			getPrime(); // 소수 구하기
			res = run();// 연속된 소수 합 구하기
		}

		bw.write(res+"\n");
		bw.close();

	}

	private static int run() {
		int count = 0;
		int start = 0;
		int end = 0;
		int sum = 0;

		/*
		 * 1. sum보다 크다면 start+1
		 * 2. sum보다 작다면 end+1
		 * 3. sum과 같다면 cnt증가,right는 왼쪽으로
		 */
		
		while(true) {
			if(sum <= N) {
				if(end < prime.length) {
					sum+=prime[end];
				}
				end++;
			} else if(sum > N) {
				sum -=prime[start];
				start++;
			}
			
			if(end > prime.length) break;
			if(sum == N) count++;
		}
	
		return count;
	}

	private static void getPrime() {
		num[0] = num[1] = 0;
		
		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (num[i] == 0) continue;
			for (int j = 2 * i; j <= N; j += i) {
				num[j] = 0;
			}
		}
		
		List<Integer> tmp = new ArrayList<>();
		
		for (int i = 0; i < num.length; i++) {
			if(num[i] !=0) tmp.add(num[i]); // 소수인 수를 담기
		}

		prime = tmp.stream().toArray(Integer[]::new);
	}
}
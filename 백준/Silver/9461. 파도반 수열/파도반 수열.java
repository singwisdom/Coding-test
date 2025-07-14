import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testcase = Integer.parseInt(br.readLine());
		long[] res = new long[101];
		
		// DP 구하기
		res[1] = res[2] = res[3] = 1;
		res[4] = res[5] = 2;
		
		for (int i = 6; i <= 100; i++) {
			res[i] = res[i-1] + res[i-5];
		}
		
		for (int i = 0; i < testcase; i++) {
			int N = Integer.parseInt(br.readLine());
			bw.write(res[N]+"\n");
		}
		bw.flush();
	}

}

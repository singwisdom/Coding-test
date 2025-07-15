import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] res = new int[1001];
		
		// 초기식
		res[1] = 1;
		res[2] = 3;
		res[3] = 5;
		
		for (int i = 3; i <= N; i++) {
			res[i] = (res[i-1] + 2*res[i-2]) % 10007;
		}
		bw.write(res[N]+"\n");
		bw.flush();
	}

}
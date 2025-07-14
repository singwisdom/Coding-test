import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] res = new int[1001];
		
		res[1] = 1;
		res[2] = 2;
		
		for (int i = 3; i <=N; i++) {
			res[i] = (res[i-2] + res[i-1]) %10007; // 오버플로우 방지 위해 10007로 나눈 답을 저장해줘야 함
		}
		
		bw.write(res[N]+"\n");
		bw.flush();
	}

}
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] stair = new int[301];
		int[] score = new int[301];
		
		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		score[1] = stair[1];
		score[2] = stair[1] + stair[2];
		score[3] = Math.max(stair[1], stair[2]) + stair[3];
		
		for (int i = 4; i <= N; i++) {
			score[i] = Math.max(score[i-3]+stair[i-1], score[i-2]) + stair[i];
		}
		
		bw.write(score[N]+"\n");
		bw.flush();

	}

}
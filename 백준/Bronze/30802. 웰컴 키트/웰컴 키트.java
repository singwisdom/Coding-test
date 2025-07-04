import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] shirt = new int[6];
		int[] TP = new int[2];
		int T = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < shirt.length; i++) {
			shirt[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		TP[0] = Integer.parseInt(st.nextToken());
		TP[1] = Integer.parseInt(st.nextToken());
		
		// T 구하기
		for (int i = 0; i < shirt.length; i++) {
			if(shirt[i]!=0) { // 0이 아닌걸 고려해야함
				if(TP[0] - shirt[i] >=0) {
					T+=1;
				}else {
					if(shirt[i]%TP[0] ==0) {
						T += shirt[i]/TP[0];
					}else {
						T += (shirt[i]/TP[0] +1);
					}
				}
			}
			
		}
				
		bw.write(T+"\n");
		bw.write(N/TP[1]+" "+N%TP[1]+"\n");
		bw.flush();

	}

}
import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;
	static int[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		v = new int[m];
		
		for (int i = 0; i < n; i++) {
			arr[i] = i+1; // 배열 초기화
		}
		
		comp(0, 0);
		
	}
	
	// idx : 원본배열의 순서값, k : 선택한 갯수
	private static void comp(int idx, int k) {
		
		if(k == v.length) {
			for (int i = 0; i < v.length; i++) {
				System.out.print(v[i]+" ");
			}
			System.out.println();
			return;
		}
		
		if(idx==arr.length) return;
		
		v[k] = arr[idx];
		// 선택하는 경우
		comp(idx+1, k+1);
		// 선택하지 않는 경우
		comp(idx+1,k);
	}
	
}
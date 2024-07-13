
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int i=1;i<=tc;i++) {
			int n = sc.nextInt(); // 배열의 크기
			String[][] arr = new String[n][n];
			String[][] res = new String[n][3];
			String tmp = "";
			
			for(int j=0;j<n;j++) { // 배열 입력받기
				for (int k=0;k<n;k++) {
					arr[j][k] = sc.next();
				}
			}
			
			// 90도 회전하기
			for(int j=0;j<n;j++) {
				tmp = "";
				for (int k=0;k<n;k++) {
					tmp += arr[k][j];
				}
				res[j][0] = new StringBuilder(tmp).reverse().toString(); // 문자열 뒤집기
			}
			
			// 180도 회전하기
			for(int j=n-1;j>=0;j--) {
				tmp = "";
				for (int k=0;k<n;k++) {
					tmp += arr[j][k];
				}
				res[(n-1)-j][1] = new StringBuilder(tmp).reverse().toString(); // 문자열 뒤집기
			}
			
			// 270도 회전하기
			for(int j=n-1;j>=0;j--) { 
				tmp = "";
				for (int k=0;k<n;k++) {
					tmp += arr[k][j];
				}
				res[(n-1)-j][2] = tmp; // 
			}
			
			System.out.println("#"+i);
			for(int j=0;j<n;j++) { // 배열 출력하기
				for (int k=0;k<3;k++) {
					System.out.print(res[j][k]+" ");
				}
				System.out.println();
			}
			
		}
	}
}
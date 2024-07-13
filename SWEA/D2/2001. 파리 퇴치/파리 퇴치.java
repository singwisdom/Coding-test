
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
			int n = sc.nextInt(); // 배열 크기
			int m = sc.nextInt(); // 파리채 크기
			int[][] arr = new int[n][n];
			int count = 0;
			int tmp = 0;
			
			for(int j=0;j<n;j++) { // 배열 입력받기
				for(int k=0;k<n;k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			
			for(int a=0;a<n-m+1;a++) {
				for(int b=0;b<n-m+1;b++) {
					for(int c=0;c<m;c++) {
						for(int d=0;d<m;d++) {
							tmp += arr[c+a][d+b];
						}
					}
					count = Math.max(count, tmp);
					tmp = 0;
					
				}
			}
			
			System.out.println("#"+i+" "+count);
		}
	}
}
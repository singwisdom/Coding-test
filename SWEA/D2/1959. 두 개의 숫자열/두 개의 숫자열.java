
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
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] arr1 = new int[n];
			int[] arr2 = new int[m];
			int max = 0;
			
			for(int j=0;j<n;j++) { // 첫번째 배열 입력받기
				arr1[j] = sc.nextInt();
			}
			for(int j=0;j<m;j++) { // 두번째 배열 입력받기
				arr2[j] = sc.nextInt();
			}
		
			if(n>m) {
				for(int j=0;j<n-m+1;j++) {
					int result = 0;
					for(int k=0;k<m;k++) {
						result += arr1[j+k] * arr2[k]; //j+k를 생각 못햇음...int k=j; 이렇게 생각함...
					}
					max = Math.max(max, result);
				}
			}
			else if(n<m) {
				for(int j=0;j<m-n+1;j++) {
					int result = 0;
					for(int k=0;k<n;k++) {
						result += arr1[k] * arr2[j+k];
					}
					max = Math.max(max, result);
				}
			}
			else {
				int result = 0;
				for(int j=0;j<n;j++) {
					result += arr1[j] * arr2[j];
				}
			}
			
			System.out.printf("#%d %d\n",i,max);
			
		}
	}
}
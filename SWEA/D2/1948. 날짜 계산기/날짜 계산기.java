
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
		int[] arr = {0,31,28,31,30,31,30,31,31,30, 31,30,31};
		for(int i=1;i<=tc;i++) {
			int month1 = sc.nextInt();
			int day1 = sc.nextInt();
			int month2 = sc.nextInt();
			int day2 = sc.nextInt();
			int res = 0;
			
			// 월이 같을 경우 그냥 날짜만 계산
			if(month1 == month2) {
				res = day2 - day1 + 1;
			}
			// 월이 다를 경우 배열 참고해서 날짜 계산
			else {
				for(int j=month1+1;j<month2;j++) {
					res += arr[j]; // 각 사이의 월의 날짜들 계산
				}
				res += arr[month1] - day1 + 1;
				res += day2;
				
			}
			
			System.out.println("#"+i+" "+res);
		}
	}
}
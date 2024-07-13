
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
			int hour1 = sc.nextInt();
			int min1 = sc.nextInt();
			int hour2 = sc.nextInt();
			int min2 = sc.nextInt();
			int res_h = 0, res_m = 0;
			
			res_m = min1+min2;
			res_h = hour1+hour2;
			
			if(res_m>=60) {
				res_h += 1;
				res_m-=60;
			}
			
			if(res_h>12) {
				res_h -=12;
			}
			
			System.out.println("#"+i+" "+res_h+" "+res_m);
		}
	}
}
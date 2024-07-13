
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
		int[] arr = {50000,10000,5000,1000,500,100,50,10};
		int tc = sc.nextInt();
		
		for(int i=1;i<=tc;i++) {
			int money = sc.nextInt();
			int[] res = new int[8];
			
			for(int j=0;j<8;j++) {
				res[j] += (money/arr[j]);
				money %= arr[j];
			}
			
			
			System.out.println("#"+i);
			for(int j=0;j<8;j++) {
				System.out.print(res[j]+" ");
			}
            System.out.println();
		}
	}
}
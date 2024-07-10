
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
		
		//가위 :1 , 바위 :2, 보:3
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(a==1&&b==2) {System.out.println("B");}
		else if(a==1&&b==3) {System.out.println("A");}
		else if(a==2&&b==1) {System.out.println("A");}
		else if(a==2&&b==3) {System.out.println("B");}
		else if(a==3&&b==1) {System.out.println("B");}
		else {System.out.println("A");}
	}
}
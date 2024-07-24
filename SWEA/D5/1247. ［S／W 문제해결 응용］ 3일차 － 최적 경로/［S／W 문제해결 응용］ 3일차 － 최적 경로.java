import java.util.*;
import java.io.*;

public class Solution {

    public static Set<Integer> res;
    public static int[][] house;
    public static int[] office;
    public static int[] my_house;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
    
        for(int i=1;i<=tc;i++) {
        	int n = Integer.parseInt(br.readLine()); // 고객의 수
        	 
            house = new int[n][2]; // 고객의 집을 저장하는 배열
            office = new int[2]; // 회사 위치
            my_house = new int[2]; // 우리집 위치
            int[] arr = new int[n];
            boolean[] v = new boolean[arr.length];
            res = new HashSet<Integer>();
            
           
            
            for(int j=0;j<n;j++) {
                arr[j] = j;
            }
            
            String[] tmp = br.readLine().split(" ");
            office[0] = Integer.parseInt(tmp[0]);
            office[1] = Integer.parseInt(tmp[1]);
            my_house[0] = Integer.parseInt(tmp[2]);
            my_house[1] = Integer.parseInt(tmp[3]);
            
            int k=0;
            for(int j=4;j<n*2+4;j+=2) {
                house[k][0] = Integer.parseInt(tmp[j]);  // 고객 위치 저장 x좌표
                house[k][1] = Integer.parseInt(tmp[j+1]); // 고객 위치 저장 y좌표
                k++;
            }
            
            recursive(arr, new int[arr.length],0,v);

            System.out.printf("#%d %d\n",i,Collections.min(res)); // 최솟값 출력
        }
        
        
    }
    
    private static void recursive(int[] arr, int[] sel, int k, boolean[] v) {
        
        // basis part (여기서 경로 구하기)
        if(k == sel.length) {
            int sum = 0;
            
            // 회사에서 첫번째 고객 집
            sum += Math.abs(office[0] - house[sel[0]][0]); // x좌표
            sum += Math.abs(office[1] - house[sel[0]][1]); // y좌표
            
            // 마지막 고객 집에서 우리집까지거리
            sum += Math.abs(house[sel[sel.length-1]][0] - my_house[0]); // x좌표
            sum += Math.abs(house[sel[sel.length-1]][1] - my_house[1]); // y좌표
            
            for(int i=0;i<sel.length-1;i++) {
                sum += Math.abs(house[sel[i]][0] - house[sel[i+1]][0]); // x좌표
                sum += Math.abs(house[sel[i]][1] - house[sel[i+1]][1]); // y좌표
            }
            
            res.add(sum);
            return ;
        }
        
        // inductive part
        for(int i=0;i<arr.length;i++) {
            if(v[i] == false) {
                v[i] = true;
                sel[k] = arr[i];
                recursive(arr,sel,k+1,v);
                v[i] = false;
            }
        }
    }

}
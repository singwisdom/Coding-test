import java.io.*;
import java.util.*;
 
public class Solution {
 
    static int N, M, startX, startY, endX, endY, res;
    static int[] dr = { 0, 0, 0, 1, -1 };
    static int[] dc = { 0, 1, -1, 0, 0 };
    static boolean[][] visit;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine()); // TC 개수
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken()) + 100;
            startY = Integer.parseInt(st.nextToken()) + 100;
            endX = Integer.parseInt(st.nextToken()) + 100;
            endY = Integer.parseInt(st.nextToken()) + 100;
            res = Integer.MAX_VALUE;
 
            dfs(startX, startY, true);
            dfs(startX, startY,false);
            bw.write("#"+tc+" "+res+"\n");
        }
        bw.close();
    }
 
    private static void dfs(int r, int c, boolean dir) {
        int nr = r;
        int nc = c;
        int cnt = 0;
         
        while (true) {
            if (nr == endX && nc == endY) {
                res = Math.min(res, cnt);
                break;
            }
            // 만약에 이전 방향이 세로였다면 지금은 가로이동만 해야하고, 이전 방향이 가로였다면 지금은 세로 이동만 가능해
            // dir = false 이면 세로 이동, dir = true 이면 가로이동
            if(dir) {
                if(nr > endX) nr--;
                else nr++;
                dir = false;
            }else {
                if(nc > endY) nc--;
                else nc++;
                dir = true;
            }
            cnt++;
        }
 
    }
 
}
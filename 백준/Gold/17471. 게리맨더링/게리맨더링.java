
import java.io.*;
import java.util.*;

public class Main {

	
	static class Node{
		int v;
		
		Node(int v){
			this.v = v;
		}
	}
	
	static int[] arr, people;
	static ArrayList<Node>[] adjList;
	static List<Integer> arr_red = new ArrayList<>();
	static List<Integer> arr_blue = new ArrayList<>();
	static int min = Integer.MAX_VALUE;
	static int n;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine()); // 구역 수 
		adjList = new ArrayList[n+1]; // 인접리스트
		
		arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = i+1;
		
		people = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 인구 수 
	
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList();
			int[] tmp= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int j = 0; j < tmp[0]; j++) {
				adjList[i].add(new Node(tmp[j+1])); // 인접리스트에 연결된 노드 추가
			}
		}
		
		boolean[] sel = new boolean[arr.length];
		recursive(0,0,sel); // 부분집합 구하기
		if(min== Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
		
	}
	
	private static void recursive(int idx, int k, boolean[] sel) {
		
		// basis part(반복의 횟수)
		if(idx == arr.length){
			for (int i = 0; i < sel.length; i++) {
				if(sel[i] == true) {
					arr_red.add(arr[i]);
				}
				else if(sel[i]==false) {
					arr_blue.add(arr[i]);
					
				}
			}
			if(arr_red.size()!=n && arr_blue.size()!=n && arr_red.size()!=0 && arr_blue.size()!=0) {
				boolean red = bfs(arr_red, new boolean[n+1]);
				boolean blue = bfs(arr_blue, new boolean[n+1]);
				
				if(red && blue) {
					int tmp1 = 0;
					int tmp2 = 0;
					
					for (int i = 0; i < arr_red.size(); i++) {
						tmp1+=people[arr_red.get(i)-1];
						//System.out.println(arr_red.get(i));
					}
					for (int i = 0; i < arr_blue.size(); i++) {
						tmp2+=people[arr_blue.get(i)-1];
					}
					min = Math.min(min, Math.abs(tmp1-tmp2));
				}
			}
			
			arr_red.clear();
			arr_blue.clear();
			return;
		}
		
		// inductive part(하나의 반복의 순간에 발생할 수 있는 모든 경우)
		// 선택하는 경우
		sel[idx] = true;
		recursive(idx+1, k+1, sel);
		
		// 선택하지 않는 경우
		sel[idx] = false;
		recursive(idx+1, k, sel);
		
	}
	
	private static boolean bfs(List<Integer> arr, boolean[] v) {
		
		Queue<Integer> queue = new ArrayDeque();
		int count = 1;
		queue.offer(arr.get(0));
		v[arr.get(0)] = true;
		
		while(!queue.isEmpty()) {
			Integer p = queue.poll();
			
			for (int i = 0; i < adjList[p].size(); i++) {
				if(arr.contains(adjList[p].get(i).v)) {
					if(!v[adjList[p].get(i).v]) {
						v[adjList[p].get(i).v] = true;
						count+=1; // arr의 size와 현재 방문한 노드의 번호가 같은지 확인하는 변수
						Node n = adjList[p].get(i);
						queue.offer(n.v);
					}
					
				}
			}
		}
		//System.out.println(arr.size()+ " "+count);
		if(arr.size() == count) return true;
		else return false;
		
	}
	

}

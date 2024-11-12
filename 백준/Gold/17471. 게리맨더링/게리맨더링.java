import java.io.*;
import java.util.*;

public class Main {

	static int N, minPeople;
	static int[] people, arr;
	static boolean[] visit;
	static ArrayList<Node>[] list;
	static ArrayList<Integer> red, blue;

	static class Node {
		int num;

		public Node(int num) {
			super();
			this.num = num;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine().trim()); // 선거구의 개수
		people = new int[N];
		arr = new int[N + 1];
		visit = new boolean[N + 1];
		list = new ArrayList[N + 1]; // 선거구의 연결리스트
		minPeople = Integer.MAX_VALUE;

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken()); // 인구 수 입력받기
		}

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Node>(); // ArrayList 초기화
		}

		for (int i = 1; i < arr.length; i++) {
			arr[i] = i; // 부분집합을 구하기 위해 배열을 입력
		}

		// TC 입력받기
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int tmp = Integer.parseInt(st.nextToken());
			for (int j = 0; j < tmp; j++) {
				list[i].add(new Node(Integer.parseInt(st.nextToken())));
			}

		}

		doGary(1); // 게리맨더링 구하기
		int res = (minPeople == Integer.MAX_VALUE) ? -1 : minPeople;
		bw.write(res + "\n");
		bw.close();

	}

	private static void doGary(int idx) {
		if (idx == arr.length) {
			red = new ArrayList<>();
			blue = new ArrayList<>();

			for (int i = 1; i < visit.length; i++) {
				if (visit[i] == true) {
					red.add(i);
				} else
					blue.add(i);
			}

			if (red.size() != 0 && blue.size() != 0) {
				boolean isRedConnection = isAllConnection(red); // red, blue가 각각 연결이 되었는지 확인
				boolean isBlueConnection = isAllConnection(blue);

				//System.out.println("=======================");
				if (isRedConnection && isBlueConnection) {
					calculatePeople(); // 인구수 계산하기
				}
			}
			return;
		}

		// 선택하는 경우
		visit[idx] = true;
		doGary(idx + 1);

		// 선택하지 않는 경우
		visit[idx] = false;
		doGary(idx + 1);

	}

	private static boolean isAllConnection(ArrayList<Integer> arr) {

		//System.out.println(Arrays.toString(arr.toArray()));
		
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		int countArea = 0;
		boolean[] visitArea = new boolean[N+1];
		
		queue.offer(arr.get(0)); // 0번 인덱스부터 넣읍시다.
		visitArea[arr.get(0)] = true;
		countArea+=1;
		
		while(!queue.isEmpty()) {
			int vertex = queue.poll();
			for (int i = 0; i < list[vertex].size(); i++) {
				int tmpVertex = list[vertex].get(i).num;
				// 연결된 선거구이고, 아직 방문을 안했다면 방문처리 해주자
				if(arr.contains(tmpVertex) && !visitArea[tmpVertex]) {
					visitArea[tmpVertex] = true;
					queue.offer(tmpVertex);
					countArea +=1;
				}
			}
		}
		
		if(countArea == arr.size()) return true;
		return false;
	}

	
	private static void calculatePeople() {
		int redCount = 0, blueCount = 0;

		for (int vertex : red) {
			redCount += people[vertex - 1]; // 레드 구역 인구수 더하기
		}

		for (int vertex : blue) {
			blueCount += people[vertex - 1]; // 블루 구역 인구수 더하기
		}

		minPeople = Math.min(minPeople, Math.abs(redCount - blueCount));

	}

}

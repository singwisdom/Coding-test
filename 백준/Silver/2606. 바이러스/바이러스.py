# 백준 2606번 : 바이러스
# 알고리즘 & 자료구조 : BFS를 통해 구현하면 될 것 같음

from collections import deque

def bfs(i,q,n):
    count = 0
    is_check = [False] * (n+1)

    q.append(i) # 1번 컴퓨터 입력
    is_check[i] = True

    while q :
        num = q.popleft()
        if num != 1 : count += 1 # 1을 통해 걸린 컴퓨터 개수를 세는 것이므로 1은 제외

        for x in computer[num]:
            if not is_check[x] : # 방문하지 않았던 노드라면
                q.append(x) # 큐에 추가
                is_check[x] = True # 방문했다고 표시

    return count

n = int(input()) # 컴퓨터의 수 , 1번부터 번호가 매겨짐
pair = int(input())
computer = [[] for _ in range(n+1)]
q = deque()

for i in range(pair): # 연결된 리스트 만들어주기
    a,b = list(map(int, input().split()))
    computer[a].append(b)
    computer[b].append(a)

res = bfs(1,q,n)
print(res)
################################
# 백준 1260번 : BFS와 DFS

import sys
from collections import deque

def dfs(graph, start, visited_dfs):
    
    visited_dfs[start] = True
    print(start, end=' ')

    for i in graph[start] :
        if not visited_dfs[i] : dfs(graph, i, visited_dfs)
    

def bfs(graph, start, visited_bfs):

    queue = deque([start])
    visited_bfs[start] = True

    while queue :
        v = queue.popleft()
        print(v, end=' ')

        for i in graph[v] :
            if not visited_bfs[i] : 
                queue.append(i)
                visited_bfs[i] = True



# n : 정점의 개수, m : 간선의 개수 , v : 탐색 시작 번호
n,m,v = map(int, sys.stdin.readline().strip().split())
graph = [[] for i in range(n+1)]

visited_dfs = [False]*(n+1)
visited_bfs = [False]*(n+1)

for i in range(1,m+1): # 그래프 생성
    a,b = map(int, sys.stdin.readline().strip().split())
    graph[a].append(b)
    graph[b].append(a)

for j in range(1,n+1): # 노드 정렬
    graph[j].sort()


dfs(graph, v, visited_dfs)
print()
bfs(graph, v, visited_bfs)

################################
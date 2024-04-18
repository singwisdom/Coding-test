# 백준 1926번 : 그림
# https://www.acmicpc.net/problem/1926
# 알고리즘 : BFS

from collections import deque


def bfs(x,y) :
    pic[x][y] = 0 # 방문했다고 표시

    dx = [1,0,-1,0]
    dy = [0,1,0,-1]
    width = 1

    q.append([x,y])

    while q :
        x,y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0<=nx<n and 0<=ny<m and pic[nx][ny] == 1 :
                q.append([nx,ny])
                pic[nx][ny] = 0
                width += 1

    return width
            


# n : 세로크기 (행) ,  m : 가로크기 (열)
n, m = map(int, input().split())

# 입력 받기
pic = [list(map(int, input().split())) for _ in range(n)] 

# 방문 여부 판단
#vis = [[False] * m for _ in range(n)]
count = 0
width = 0
q = deque()


for i in range(n):
    for j in range(m):
        if pic[i][j] == 1 :
            count += 1
            width = max(bfs(i,j), width)

print(count)
print(width)
# SWEA 2005번 : 파스칼의 삼각형
# 알고리즘 & 자료구조 :

tc = int(input())
for t in range(1,tc+1):
    n = int(input())
    tri = [[0 for i in range(_+1)] for _ in range(n)]
    tri[0][0] = 1 # 항상 첫번째 숫자는 1

    a = b = c = d = 0 # (a,b), (c,d)
    for i in range(1,n):
        for j in range(len(tri[i])):
            a = c = i-1
            b = j-1
            d = j
            if 0<=a<n and 0<=b<len(tri[a]) and 0<=c<n and 0<=d<len(tri[c]): tri[i][j] = tri[a][b] + tri[c][d]
            elif a<0 or a>=n or b<0 or b>=len(tri[a]) : tri[i][j] = tri[c][d]
            elif c < 0 or c >= n or d < 0 or d >= len(tri[c]): tri[i][j] = tri[a][b]
    print(f'#{t}')

    for i in range(n):
         print(' '.join(map(str, tri[i])))
# SWEA 5215번 : 햄버거 다이어트
# 알고리즘 & 자료구조 : 0/1 KnapSack과 유사함

tc = int(input())
for t in range(1,tc+1):
    n,l = map(int, input().split()) # n이 재료의 개수, l이 제한 칼로리
    info = [[0,0]]
    burger = [[0 for _ in range(l+1)] for x in range(n+1)]
    for _ in range(n):
        info.append(list(map(int, input().split()))) # 점수, 칼로리

    # 핵심 알고리즘
    for i in range(1,n+1):
        for j in range(1,l+1):
            score = info[i][0]
            kcal = info[i][1]

            if j < kcal : burger[i][j] = burger[i-1][j]
            else :
                burger[i][j] = max(burger[i-1][j], burger[i-1][j-kcal]+score)

    print(f'#{t} {burger[n][l]}')
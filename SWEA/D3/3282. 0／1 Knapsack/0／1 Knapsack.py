# SWEA 3282번 : 0/1 Knapsack
# 알고리즘 & 자료구조 :

tc = int(input())
for t in range(1,tc+1):

    n,k = map(int, input().split()) # n: 물건의 개수, k: 가방의 부피
    info = [list(map(int, input().split())) for _ in range(n)]  # 물건의 정보 입력 (부피, 가치)
    bag = [[0 for _ in range(k+1)] for i in range(n+1)] # 테이블 정의

    for i in range(1,n+1):
        for j in range(1,k+1):
            weight = info[i-1][0]
            value = info[i-1][1]

            if j < weight :
                bag[i][j] = bag[i-1][j] # 가방에 넣을 수 없으면 위에 값 그대로 가져오기
            else : # 가방에 넣을 수 있다면
                bag[i][j] = max(bag[i-1][j], bag[i-1][j-weight] + value)
                # 현재 물건의 무게 만큼 뺀 곳의 최대값 + 현재 물건의 가치를 비교해서 max인 값 집어넣기

    print(f'#{t} {bag[n][k]}')
# SWEA 2001번 : 파리퇴치
# 알고리즘 & 자료구조 : for문...

tc = int(input())
for num in range(1,tc+1):
    n,m = map(int, input().split())
    fly = list() # 파리 저장할 배열

    for i in range(n):
        fly.append(list(map(int, input().split()))) # 배열 입력

    ## 핵심 알고리즘 ##
    result = 0
    add = 0
    for i in range(n-m+1):
        for j in range(n-m+1):
            for k in range(i,i+m):
                for l in range(j,j+m):
                    add += fly[k][l]
            result = max(result, add)
            add = 0
            
    print(f'#{num} {result}')
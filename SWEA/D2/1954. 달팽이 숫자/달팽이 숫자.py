# SWEA 1954번 : 달팽이 숫자
# 알고리즘 & 자료구조 : 오른쪽, 아래, 왼쪽, 위 이 순서대로 방향벡터 바꿔주기

vector = [(0,1),(1,0),(0,-1),(-1,0)] # 각각 오른쪽, 아래, 왼쪽, 위
tc = int(input())
for t in range(1,tc+1):

    n = int(input()) # 크기 N*N
    snail = [[0 for _ in range(n)] for x in range(n)]
    snail[0][0] = 1

    v = 0
    i = 0
    j = 0
    for num in range(2,(n*n)+1):
        # 일단 이동
        i += vector[v][0]
        j += vector[v][1]

        # 이동한 곳이 범위 내에 있거나, 숫자가 채워져 있지 않다면 배열 채우기
        if 0<=i<n and 0<=j<n and snail[i][j] == 0 : 
            snail[i][j] = num
        # 숫자가 있거나 배열 인덱스를 초과한다면 방향을 바꿈
        else : 
            i -= vector[v][0] # 더해져 있던거 다시 빼기
            j -= vector[v][1] 
            
			# 방향벡터 전환
            if v == 3 :  v = 0
            else : v += 1

            i += vector[v][0] # 바뀐 방향벡터로 다시 더해주기
            j += vector[v][1]
            if 0<=i<n and 0<=j<n and snail[i][j] == 0 : 
                snail[i][j] = num


    # 정답 출력
    print(f'#{t}')
    for x in range(n):
        for y in range(n):
            print(snail[x][y], end = ' ')
        print()
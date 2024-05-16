# 백준 1018번 : 체스판 다시 칠하기
# 알고리즘 & 자료구조 :

n,m = map(int, input().split()) # n이 행, m이 열
lst = [list(str(input())) for _ in range(n)]

# W로 시작하는 lst 만들기
w_list = [['W' for i in range(m)] for _ in range(n)]
for i in range(n):
    for j in range(m):
        # i가 0 또는 짝수일 때, 홀수 j만 B로 바꿔주면 됨
        if i == 0 or i % 2 == 0 :
            if j % 2 != 0 : w_list[i][j] = 'B'
        # i가 홀수일때, 짝수j 혹은 0번 인덱스만 B로 바꿔주면 됨
        else :
            if j == 0 or j % 2 == 0 : w_list[i][j] = 'B'

# B로 시작하는 lst 만들기 => w_list 뒤집어서 저장하면 안됨.. 어떤 경우에는 뒤집은게 똑같을 수 있음 W로 시작해서 W로 끝나는 경우..
b_list = [['B' for i in range(m)] for _ in range(n)]
for i in range(n):
    for j in range(m):
        # i가 0 또는 짝수일 때, 홀수 j만 W로 바꿔주면 됨
        if i == 0 or i % 2 == 0 :
            if j % 2 != 0 : b_list[i][j] = 'W'
        # i가 홀수일때, 짝수j 혹은 0번 인덱스만 W로 바꿔주면 됨
        else :
            if j == 0 or j % 2 == 0 : b_list[i][j] = 'W'


cnt = list()
# for문 돌면서 최소 찾기
for a in range(n-7):
    for b in range(m-7):
        count1 = 0
        count2 = 0
        for i in range(a,a+8):
            for j in range(b,b+8):
                if lst[i][j] != w_list[i][j] : count1 += 1
                if lst[i][j] != b_list[i][j] : count2 += 1
        cnt.append(count1)
        cnt.append(count2)
        
print(min(cnt))
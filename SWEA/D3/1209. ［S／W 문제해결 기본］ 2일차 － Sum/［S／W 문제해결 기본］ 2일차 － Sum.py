# SWEA 1209번 : Sum
# 자료구조 & 알고리즘 : 반복문,,?

row_list = list()
col_list = list()
box = list()


for i in range(10) :
    n = int(input()) # tc 번호
    max_sum = 0
    
    for j in range(100): # 배열 입력받음
        box.append(list(map(int, input().split()))) 

    ## 각 행의 합##
    for j in range(100):
        sum = 0
        for k in range(100):
            sum += box[j][k]
        row_list.append(sum)
       
    ## 각 열의 합 ##
    for j in range(100):
        sum = 0
        for k in range(100):
            sum += box[k][j]
        col_list.append(sum)

    sum = 0
    ## 좌 대각선 합 ##
    for j in range(100):
        for k in range(100):
            if j == k : sum += box[j][k]
    max_sum = max(sum, max_sum)

    sum = 0
    ## 우 대각선 합 ##
    for j in range(100):
        for k in range(100):
            if j+k == 100 : sum += box[j][k]
    max_sum = max(sum, max_sum)

    row_list.sort()
    col_list.sort()
    max_sum = max(max_sum, row_list[-1], col_list[-1])

    print(f'#{n} {max_sum}')

    box.clear()
    col_list.clear()
    row_list.clear()
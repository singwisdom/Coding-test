# SWEA 1979번 : 어디에 단어가 들어갈 수 있을까
# 알고리즘 & 자료구조 : for문 돌면서 확인

tc = int(input())
for t in range(1,tc+1):

    n,k = map(int, input().split())
    puzzle = [list(map(int, input().split())) for _ in range(n)] # 퍼즐 입력받기
    row_col = list()

    string = ''
    # 가로 탐색
    for i in range(n):
        for j in range(n):
            if puzzle[i][j] == 1 : string += '1'
            if len(string)!=0 :  # 0을 만났거나 배열의 끝이고, str에 무언가가 있으면 넣고 string 초기화
                if puzzle[i][j] == 0 or j == n-1 :
                    row_col.append(string)
                    string = '' 

    # 세로 탐색
    string = ''
    for i in range(n):
        for j in range(n):
            if puzzle[j][i] == 1 : string += '1'
            if len(string)!=0 :  # 0을 만났거나 배열의 끝이고, str에 무언가가 있으면 넣고 string 초기화
                if puzzle[j][i] == 0 or j == n-1 :
                    row_col.append(string)
                    string = '' 

    str_find= '1'*k
    print(f'#{t} {row_col.count(str_find)}')
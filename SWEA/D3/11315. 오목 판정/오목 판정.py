# SWEA 11315번 : 오목판정
# 알고리즘 & 자료구조 : BFS로 풀어보기 / 그냥 구현으로 풀어보기

def find_omok(n):

    is_col_find = False
    omok = list()

    for i in range(n): # 입력
        string = str(input())
        if string.find('ooooo') != -1 : is_col_find = True # 가로 행렬 확인하면서 5개 연속인거 있으면 빠져나오기
        else : omok.append(list(string))

    if is_col_find : return 'YES'

    # 세로 확인하기
    for i in range(n):
        tmp = ''
        for j in range(n):
            tmp += omok[j][i]
        if tmp.find('ooooo') != -1 :  return 'YES'  # 세로 행렬 확인하면서 5개 연속인거 있으면 바로 빠져나오기

    # 왼쪽 대각선 확인하기
    
    for i in range(n*2 -1):
        tmp = ''
        for x in range(n):
            for y in range(n):
                if x+y == i :
                    tmp += omok[x][y]
        if tmp.find('ooooo') != -1 : return 'YES'

    # 오른쪽 대각선 확인하기
    omok_90 = list(map(list, zip(*omok[::-1])))
    for i in range(n*2 -1):
        tmp = ''
        for x in range(n):
            for y in range(n):
                if x+y == i :
                    tmp += omok_90[x][y]
        if tmp.find('ooooo') != -1 : return 'YES'


# 메인 함수
tc = int(input())
for t in range(1,tc+1):
    n = int(input())
    result = ''
    result = find_omok(n)

    if result == 'YES' : print(f'#{t} YES')
    else : print(f'#{t} NO')
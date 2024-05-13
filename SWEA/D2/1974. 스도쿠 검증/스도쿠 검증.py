# SWEA 1974번 : 스도쿠 검증
# 알고리즘 & 자료구조 : 겹치면 바로 break, 출력하기

def find(num, puzzle):

    # 가로 탐색
    for i in range(9):
        p_set = set(puzzle[i])
        if len(num-p_set) != 0: return 0

    # 세로 탐색
    col_puzzle = list(map(list, zip(*puzzle[::-1]))) # 90도 배열 회전
    for i in range(9):
        p_set = set(col_puzzle[i])
        if len(num - p_set) != 0: return 0

    li = [[0,1,2],[3,4,5],[6,7,8]]

    # 3*3 격자 탐색
    for i in range(3):
        for j in range(3):
            tmp = set()
            for k in li[i]:
                for l in li[j]:
                    tmp.add(puzzle[k][l])
            if len(num-tmp) != 0: return 0
            tmp.clear()


tc = int(input())

for t in range(1,tc+1):
    puzzle = list()
    num = set()
    for i in range(1, 10):
        num.add(i)

    for i in range(9): # 스도쿠 배열 입력
        puzzle.append(list(map(int, input().split())))

    res = find(num, puzzle)

    if res == 0 : print(f'#{t} 0')
    else : print(f'#{t} 1')
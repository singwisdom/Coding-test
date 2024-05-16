# 백준 1811번 : 마인크래프트
# 알고리즘 & 자료구조 : 모르겠으면 완탐.... lst[i][j]번째 인덱스와 같게 고르게 한다고 가정하기
# 시간 줄이려면 이미 했었던 땅의 높이라면 건너뛰기  => [[256, 256], [0,0]] 의 경우 답과 다름. 이 경우에는 128 높이도 고려해야함 !

import sys

n,m,block = map(int, sys.stdin.readline().split()) # b가 인벤토리에 들어있는 블록의 개수
mine = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
answer = int(1e9)
height = 0
# 좌표 (i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다. ==> 2초 걸림
# 인벤토리에서 블록 하나를 꺼내어 좌표 (i, j)의 가장 위에 있는 블록 위에 놓는다. ==> 1초 걸림

for i in range(257):
    standard = i
    use_block = 0
    take_block = 0

    for a in range(n):
        for b in range(m):
            if mine[a][b] > standard : # 땅의 높이가 더 높다면 블록을 꺼내야함 (2초)
                take_block += mine[a][b] - standard # 블록 제거하여 인벤토리에 넣는다
                # time += 2 * (mine[a][b] - standard) # time 더해줌

            else : # 땅의 높이가 더 낮다면 인벤토리에서 가져와야함 (1초)
                use_block += standard - mine[a][b] # tmp 개수만큼 인벤토리에서 가져와야함
                # time += standard - mine[a][b]

    if take_block + block >= use_block :
        if (take_block * 2) + use_block <= answer :
            answer = (take_block * 2) + use_block # 블록의 개수가 곧 시간을 뜻함
            height = standard
            # 어차피 i가 오름차순이므로, 시간이 가장 최소이면 높이가 가장 최대가 나오게 되어있음

print(answer, height)
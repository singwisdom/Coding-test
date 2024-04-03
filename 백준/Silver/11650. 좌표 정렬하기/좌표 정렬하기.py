# 백준 11650번 : 좌표 정렬하기
# https://www.acmicpc.net/problem/11650

# 나의 풀이 => key값 정렬을 이용하여, 각각 인덱스별로 우선정렬하기

import sys

n = int(input())
num_list = list()

for i in range(n):
    x,y = map(int, sys.stdin.readline().split())
    num_list.append([x,y])

# 다중정렬을 이용 (여기서는 x를 기준으로 우선 정렬, 그 다음 y기준으로 정렬)
num_list.sort(key=lambda x:(x[0], x[1]))

# 출력
for i in range(len(num_list)) :
    sys.stdout.write("{} {}\n".format(num_list[i][0], num_list[i][1]))
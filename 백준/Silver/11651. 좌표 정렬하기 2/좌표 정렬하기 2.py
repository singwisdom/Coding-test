# 백준 11561번 : 좌표 정렬하기2
# https://www.acmicpc.net/problem/11651

import sys

n = int(input())
num_list = list()

# x,y 좌표 입력받기
for i in range(n): 
    x,y = map(int, sys.stdin.readline().split())
    num_list.append([x,y])

# y좌표 우선 정렬, 그 후 x좌표 정렬
num_list.sort(key=lambda x:(x[1],x[0]))

for i in range(len(num_list)):
    sys.stdout.write("{} {}\n".format(num_list[i][0], num_list[i][1]))
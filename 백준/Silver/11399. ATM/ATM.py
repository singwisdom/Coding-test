# 백준 11399번 : ATM
# https://www.acmicpc.net/problem/11399
# 알고리즘, 자료구조 : 정렬

import sys

n = int(input())
input_str = sys.stdin.readline().rstrip().split()
sum = 0
result = 0
time = [[int(num), i+1] for i, num in enumerate(input_str)] # enumerate

############ 중요 !! #################
time.sort(key = lambda x:x[0]) # Pi 기준으로 오름차순으로 정렬하기
#print(time)

for j in range(len(time)):
    sum += time[j][0]
    result += sum

print(result)
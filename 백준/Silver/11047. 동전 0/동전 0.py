# 백준 11047번 : 동전 0
# https://www.acmicpc.net/problem/11047
# 자료구조, 알고리즘 :

import sys

n,k = map(int, input().split())
money = list()
count = 0 # 최솟값을 저장하는 변수

for i in range(n): # 동전 저장
    money.append(int(sys.stdin.readline().rstrip()))

money.reverse() # 내림차순으로 정렬

for j in money :
    
    if k>=j :
        count += k // j # 몫 저장
        k = k % j # 나머지 저장
    if k == 0 : break

print(count)
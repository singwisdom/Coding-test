# 백준 18110번 : sloved.ac
# https://www.acmicpc.net/problem/18110
# 알고리즘 : 

import sys
import math

n = int(input())
num = list()
sum = 0

if n==0 : print("0") # 의견은 0부터
else : 
    for i in range(n):
        num.append(int(sys.stdin.readline().rstrip()))

    num.sort()

    # 30% 절사평균에 따라 제외하는 사람 구하기 (avg는 각 15%를 나타냄)
    avg = math.floor(((n*0.3) / 2) + 0.5)

    for i in range(avg, n-avg) :
        sum += num[i]

    sum = math.floor(sum/(n-avg*2) + 0.5)

    print(sum)
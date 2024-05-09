# SWEA 3131번 : 100만 이하의 모든 소수
# 자료구조 & 알고리즘 : 에라토스테네스의 체

import math
max = 1000000
num = [True for _ in range(max+1)] # 배열 생성
num[1] = False

# 에라토스테네스의 체에서는 제곱근까지만 계산하면 됨 2부터 while문 돌면서 해당 배수 제거
for i in range(2,int(math.sqrt(max))+1):
    if num[i] == True :
        j = 2
        while i*j <= max :
            num[i*j] = False # 배수 제거, False로 만들기
            j+=1

for j in range(2,max+1):
    if num[j] : print(j, end=' ')
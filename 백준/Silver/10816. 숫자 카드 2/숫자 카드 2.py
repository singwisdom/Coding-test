# 백준 10816번 : 숫자카드 2
# https://www.acmicpc.net/problem/10816
# 알고리즘 : 딕셔너리로 시간단축하기

import sys

n = int(input())
num = dict()
arr = list(map(int, sys.stdin.readline().rstrip().split()))


# 리스트에 있는 내용을 딕셔너리로 저장 key는 숫자, value는 카드 개수
for x in arr :
    if x in num :
        num[x] +=1
    else : num[x] = 1

#print(arr)
#print(num)

m = int(input())
find = list(map(int, sys.stdin.readline().rstrip().split()))

for i in find :
    if i in num :
        sys.stdout.write(str(num[i])+" ")
    else : sys.stdout.write("0 ") # 카드를 갖고 있지 않은 경우 0 출력
sys.stdout.write("\n")